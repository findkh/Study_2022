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

