-- 1. 기본 키를 변형하는 나쁜 sql문
	-- 튜닝전
select * from 사원
where substring(사원번호,1,4) = 1100 and length(사원번호) = 5; -- 266ms
	-- 실행계획
	-- type이 All로 데이블 풀 스캔 방식으로 인덱스를 사용하지 않음
explain
select * from 사원
where substring(사원번호,1,4) = 1100 and length(사원번호) = 5;
	-- 튜닝
select count(1) from 사원; -- 30만건의 데이터
show index from 사원;
	-- 튜닝 결과
select * from 사원
where 사원번호 between 11000 and 11009; -- 0ms
-- 가공된 기본 키인 사원번호를 조정하여 작성. 
-- 또는
select * from 사원
where 사원번호 >= 11000 and 사원번호 <= 11009; -- 0ms

-- 2. 사용하지 않는 함수를 포함하는 나쁜 sql문
	-- 튜닝전
select ifnull(성별, "NO DATA") as 성별, count(1) 건수 
from 사원
group by ifnull(성별, 'NO DATA'); -- 531ms

explain
select ifnull(성별, "NO DATA") as 성별, count(1) 건수 
from 사원
group by ifnull(성별, 'NO DATA');
	-- 성별 열에는 null값이 존재하지 않음, 임시 테이블을 사용함
desc 사원;
	-- 튜닝 결과
select 성별, count(1) as 건수
from 사원
group by (성별); -- 159ms

-- 3. 형변환으로 인덱스를 활용하지 못하는 나쁜 sql문
	-- 튜닝 전
select count(1) from 급여 where 사용여부 = 1; -- 750ms
desc 급여;
explain
select count(1) from 급여 where 사용여부 = 1;
	-- 튜닝 수행
select 사용여부, count(1) from 급여
group by 사용여부; -- 672ms
	-- 튜닝 결과
select count(1) from 급여
where 사용여부 = '1'; -- 16ms

-- 4. 열을 결합하여 사용하는 나쁜 sql문
	-- 튜닝 전
select * from 사원 where concat(성별, ' ',성) = 'M Radwan'; -- 484ms

explain
select * from 사원 where concat(성별, ' ',성) = 'M Radwan';
-- 사원 테이블에만 접근하여 데이터를 가져오므로 하나의 행에 대해서만 실행 계획이 출력된다.
-- 테이블 풀 스캔으로 데이터를 처음부터 끝까지 스캔하므로 비효율적이다.
	-- 튜닝 수행
select concat(성별, ' ', 성) '성별_성', count(1) 
from 사원
where concat(성별, ' ', 성) = 'M Radwan' -- 102건
union all 
select '전체데이터', count(1)
from 사원;
	-- 튜닝 결과
select * from 사원
where 성별 = 'M' and 성 = 'Radwan' -- 23ms

-- 5. 습관적으로 중복을 제거하는 나쁜 sql
	-- 튜닝 전
select distinct 사원.사원번호, 사원.이름, 사원.성, 부서관리자.부서번호 
from 사원
join 부서관리자 on (사원.사원번호 = 부서관리자.사원번호); -- 15ms
-- 사원 테이블의 기본 키는 사원번호로 중복된 데이터가 없다. distinct 제거해도 무방
	-- 튜닝 결과
select 사원.사원번호, 사원.이름, 사원.성, 부서관리자.부서번호 
from 사원
join 부서관리자 on (사원.사원번호 = 부서관리자.사원번호); -- 1ms

-- 6. 다수 쿼리를 union 연산자로만 합치는 나쁜 sql
	-- 튜닝 전
explain
select 'M' as 성별, 사원번호
from 사원
where 성별 = 'M' and 성 = 'Baba'
union 
select 'F' as 성별, 사원번호
from 사원
where 성별 = 'F' and 성 = 'Baba'; -- 1ms

explain
select 성별, 사원번호
from 사원
where 성 = 'Baba'; -- 1ms 이렇게 하면 안되나?...

	-- 튜닝 수행
-- explain
select 'M' as 성별, 사원번호
from 사원
where 성별 = 'M' and 성 = 'Baba'
union all
select 'F' as 성별, 사원번호
from 사원
where 성별 = 'F' and 성 = 'Baba'; -- 1ms

-- union all과 union 차이
-- union all은 여러 개의 select문을 합치지만 union은 여러 개의 select 문 실행 결과를 합친 뒤중복된 데이터를 제거하는 작업까지 포함한다.

-- 7. 인덱스 고려 없이 열을 사용하는 나쁜 sql
	-- 튜닝 전
select 성, 성별, count(1) as 카운트
from 사원
group by 성, 성별 -- 348ms

-- 8. 엉뚱한 인덱스를 사용하는 나쁜 sql문
select 사원번호
from 사원
where 입사일자 like '1989%' and 사원번호 > 100000 -- 5ms

	-- 튜닝 수행
select 사원번호
from 사원
where 입사일자 >= '1989-01-01' and 입사일자 < '1990-01-01' and 사원번호 > 100000; -- 4ms