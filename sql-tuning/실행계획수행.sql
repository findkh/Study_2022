-- explain : 옵티마이저가 만든 실행 계획이 출력됨
-- explain 대신 describe나 desc를 입력해도 됨

explain
select * from 사원 where 사원번호 between 100001 and 200000;

describe
select * from 사원 where 사원번호 between 100001 and 200000;

desc
select * from 사원 where 사원번호 between 100001 and 200000;

-- 1. id : sql문이 출력되는 순서를 나타내고, 숫자가 작을 수록 먼저 수행, ID값이 같다면 Join 된 것임
explain
select 사원.사원번호, 사원.이름, 사원.성, 급여.연봉,
	(select max(부서번호)
	 from 부서사원_매핑 as 매핑 where 매핑.사원번호 = 사원.사원번호) as 카운트
from 사원, 급여


-- 2. select_type : sql문을 구성하는  select문의 유형을 출력
-- 2-1. simple : Union이나 내부 쿼리가 없는 select문
explain
select * from 사원 where 사원번호 = 100000;

explain 
select 사원.사원번호, 사원.이름, 사원.성, 급여.연봉 
from 사원,
	(select 사원번호, 연봉
	 from 급여
	 where 연봉 > 80000
	) as 급여
where 사원.사원번호 = 급여.사원번호 and 사원.사원번호 between 10001 and 10010;

-- 2-2. primary : 서브쿼리가 포함된 SQL문이 있을 때 첫번째 select 문에 해당하는 구문에 표시
-- 				  서브쿼리를 감싸는 외부 쿼리이거나, union이 포함된 sql문에서 첫번째 select 키워드가 작성된 구문에 표시
explain
select 사원.사원번호, 사원.이름, 사원.성,
	(select max(부서번호)
	 from 부서사원_매핑 as 매핑 where 매핑.사원번호 = 사원.사원번호) as 카운트
from 사원
where 사원.사원번호 = 100001;
