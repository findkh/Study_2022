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

-- 2-3. subquery : 독립적으로 수행되는 서브쿼리
explain
select (select count(*) from 부서사원_매핑 as 매핑)as 카운트,
	   (select max(연봉) from 급여) as 급여;
	  
-- 2-4. derived : from 절에 작성된 서브쿼리(from 절의 별도 임시 테이블인 인라인뷰)
explain
select 사원.사원번호, 급여.연봉
from 사원,
	(select 사원번호, max(연봉) as 연봉 from 급여 where 사원번호 between 10001 and 20000) as 급여
where 사원.사원번호 = 급여.사원번호;

-- 2-5. union : union 및 union all 구문으로 합쳐진 select 문에서 첫 번째 select 구문을 제외한 이후 select 구문에 해당한다는 것을 나타냄
-- 				union 구문의 첫 번째 select 절은 primary 유형으로 출력
explain
select 'M' as 성별, max(입사일자) as 입사일자
from 사원 as 사원1
where 성별 = 'M'
union 
select 'F' as 성별, min(입사일자) as 입사일자
from 사원 as 사원2
where 성별 = 'F';

-- 2-6. union result : union all이 아닌 union 구문으로 select 절을 결합했을 때 출력. 별도의 메모리 또는 디스크에 임시 테이블을 만들어 중복을 제거
explain
select 사원_통합.*
from (
	select max(입사일자) as 입사일자
	from 사원 as 사원1
	where 성별 = 'M'
	union 
	select min(입사일자) as 입사일자
	from 사원 as 사원2
	where 성별 = 'F'
) as 사원_통합;

-- 2-7. dependent subquery : union 또는 union all을 사용하는 서브쿼리가 메인 테이블의 영향을 받은 경우로, union으로 연결된 단위쿼리 들 중에서 처음으로 작성한 단위 쿼리
-- 		성능에 불리하여 튜닝 대상
explain
select 관리자.부서번호,
	(select 사원1.이름 from 사원 as 사원1 where 성별 = 'F' and 사원1.사원번호
		union all 		
	 select 사원2.이름 from 사원 as 사원2 where 성별 = 'M' and 사원2.사원번호 = 관리자.사원번호  -- where절 메인 테이블로부터 값을 공급받는 구조가 성능을 떨어트림
	) as 이름
from 부서관리자 as 관리자;

-- 2-8. dependent union : union 또는 union all을 사용하는 서브쿼리가 메인 테이블의 영향을 받는 경우
-- 						  union으로 연결된 단위 쿼리 중 첫번 째 쿼리를 제외한 두 번째 단위 쿼리에 해당
explain
select 관리자.부서번호,
	(select 사원1.이름 from 사원 as 사원1 where 성별 = 'F' and 사원1.사원번호 = 관리자.사원번호
		union all
	 select 사원2.이름 from 사원 as 사원2 where 성별 = 'M' and 사원2.사원번호 = 관리자.사원번호
	) as 이름
from 부서관리자 as 관리자;

-- 2-9. uncacheable subquery : 메모리에 상주하여 재활용되어야할 서브쿼리가 재사용되지 못할 떄 출력하는 유형
-- 		1. 해당 서브쿼리 안에 사용자 정의 함수나 사용자 변수가 포함
-- 		2. rand(), uuid() 함수 등을 사용하여 매번 조회시마다 결과가 달라지는 경우
explain
select * from 사원 where 사원번호 = (select round(rand()*1000000));

-- 2-10. materialized : in절 구문에 연결된 서브쿼리가 임시 테이블을 생성한 뒤, 조인이나 가공 작업을 수행할 떄 출력되는 유형
-- 						in 절의 서브쿼리를 임시 테이블로 만들어서 조인 작업을 수행
explain
select * from 사원 where 사원번호 in (select 사원번호 from 급여 where 시작일자> '2020-01-01');

-- 3. table : 테이블명을 쵸시하는 항목
explain
select 사원.사원번호, 급여.연봉 
from 사원,
	(select 사원번호, max(연봉) as 연봉 from 급여 where 사원번호 between 10001 and 20000) as 급여
where 사원.사원번호 = 급여.사원번호;

-- 4. partitions : 실행 계획의 부가 정보 데이터가 저장된 논리적인 영역을 표시

-- 5. type : 테이블의 데이터를 어떻게 찾을지에 관한 정보를 제공. ex)테이블을 처음부터 끝까지 전부 확인할 지 아니면 인덱스를 통해 바로 데이터를 찾아갈지

-- 5-1. system : 테이블에 데이터가 없거나 한 개만 있는 경우로 성능상 최상의 type임
create table myisam_테이블 (
	col1 int(11) null default null
)
engine=myisam;
insert into myisam_테이블 values(1);
explain
select * from myisam_테이블;

-- 5-2. const : 조회되는 데이터가 단 1건일 때 출력
explain
select * from 사원 where 사원번호 = 10001;

-- 5-3. eq_ref : 조인이 수행될 때 드리븐 테이블의 데이터에 접근하며 고유 인덱스 또는 기본 키로 단 1건의 데이터를 조회하는 방식, 드라이빙 테이블과 조인 키가 드리븐 테이블에 유일-> 성능상 유리
explain
select 매핑.사원번호, 부서.부서번호, 부서.부서명
from 부서사원_매핑 as 매핑,
	 부서
where 매핑.부서번호 = 부서.부서번호 and 매핑.사원번호 between 100001 and 100010;

-- 5-4. ref : 조인을 수행할 때 드리븐 테이블의 데이터 접근 범위가 2개 이상일 경우를 의미
explain
select 사원.사원번호, 직급.직급명
from 사원, 직급
where 사원.사원번호 = 직급.사원번호 and 사원.사원번호 between 100001 and 100010;

explain
select * from 사원 where 입사일자 = '1985-11-21';

-- 5-5. ref_or_null : ref유형과 유사 is null 구문에 대해 인덱스를 활용하도록 최적화된 방식, null은 가장 앞쪽으로 정렬
-- 					  null 데이터양이 적다면 ref_of_null방식을 활용했을 때 효율적이나 null이 많다면 튜닝 대상
explain
select * from 사원출입기록 where 출입문 is null or 출입문 = 'A';

-- 5-6. range : 테이블 내의 연속된 데이터 범위를 조회, =, <>, >, >=, <, <=, ㅑㄴ ㅜㅕㅣㅣ, <=>, between, in 연산을 통해 범위 스캔을 수행하는 방식
-- 				스캔할 범위가 넓으면 성능 저하로 튜닝 대상
explain
select * from 사원 where 사원번호 between 10001 and 100000;

-- 5-7. fulltext : 텍스트 검색을 빠르게 처리하기 위해 전문 인덱스를 사용하여 데이터에 접근

-- 5-8. index_merge : 결합된 인덱스들이 동시에 사용되는 유형
explain
select * from 사원 where 사원번호 between 10001 and 100000 and 입사일자 = '1985-11-21';

-- 5-9. index : type 항목의 index 유형은 인덱스 풀 스캔을 의미함.
explain
select 사원번호 from 직급 where 직급명 = 'Manager';

-- 5-10. all : 테이블 풀 스캔 방식, 활용할 수 있는 인덱스가 없거나, 인덱스를 활용하는게 비효율적일 때 선택됨
explain
select * from 사원;