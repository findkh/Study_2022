/*
RegExp
1. 정규 표현식(Regular Expression)
    일정한 패턴을 가진 문자열의 집합을 표현하기 위해 사용하는 형식 언어다.
    문자열을 대상으로 패턴 매칭 기능을 제공한다. 패턴 매칭 기능이란 특정 패턴과 일치하는 문자열을 검색하거나 추출 또는 치환할 수 있는 기능을 말한다.
    정규식을 사용하면 반복문과 조건문 없이 패턴을 정의하고 테스트하는 것으로 간단히 체크할 수 있다. 
2. 정규 표현식의 생성
    정규 표현식 객체를 생성하기 위해서는 정규 표현식 리터럴과 RegExp 생성자 함수를 사용할 수 있다.
    /regexp/i
    / -> 시작과 종료 기호
    regexp -> 패턴
    i -> 플래그
3. RegExp  메서드
3-1. RegExp.prototype.exec
    exec 메서드는 인수로 전다받은 문자열에 대해 정규 표현식의 패턴을 검색하여 매칭 결과를 배열로 반환한다.
    매칭 결과가 없는 경우 null을 반환한다.
3-2. RegExp.prototype.test
    test 메서드는 인수로 전달받은 문자열에 대해 정규 표현식의 패턴을 검색하여 매칭 결과를 불리언 값으로 반환한다.
3-3. String.prototype.match
    대상 문자열과 인수로 전달받은 정규 표현식과의 매칭 결과를 배열로 반환한다.
    exec 메서드는 문자열 내의 모든 패턴을 검색하는 g 플러그를 지정해도 첫 번째 매칭 결과만을 반환하지만,
    match 메서드는 g 플래그가 지정되면 모든 결과를 배열로 반환한다.
4. 플래그
    i : ignore case - 대소문자를 구별하지 않고 패턴을 검색한다.
    g : global - 대상 문자열 내에서 패턴과 일치하는 모든 문자열을 전역 검색한다.
    m : multi line - 문자열의 행이 바뀌더라도 패턴 검색을 계속한다.
    플래그는 옵션이므로 선택적으로 사용할 수 있고 순서 상관 없이 하나 이상의 플래그를 동시에 설정할 수 있다.
    플래그를 사용하지 않은 경우 대소문자를 구별해서 패턴을 검색한다.
    문자열에 패턴 검색 매칭 대상이 1개 이상 존재해도 첫 번쨰 매칭한 대상만 검색하고 종료한다.
5. 패턴
5-1. 문자열 검색
    정규 표현식을 생성하는 것만으로 검색이 수행되지 않고, 메서드를 사용하여야 한다.
5-2. 임의의 문자열
    . 마침표는 임의의 문자 한 개를 의미한다.    
5-3. 반복 검색
    {m,n}은 앞선 패턴이 최소 m번 최대 n번 반복되는 문자열을 의미한다.
    콤마뒤에 공백이 있으면 정상 동작하지 않는다.
    {n}은 앞선 패턴이 n번 반복되는 문자열을 의미한다. {n}은 {n,n}과 같다.
    {n,}은 앞선 패턴이 최소 n번 이상 반복되는 문자열을 의미한다.
    +는 앞선 패턴이 최소 한번 이상 반복되는 문자열을 의미한다.
    ?는 앞선 패턴이 최대 한 번 이상(0포함) 반복되는 문자열을 의미한다
5-4. OR 검색
    |은 or의 의미를 갖는다.
    분해되지 않은 단어 레벨로 검색하기 위해서는 +를 함께 사용한다.
    []내의 문자는 or로 동작한다. [] 뒤에 +를 사용하면 앞선 패턴을 한 번 이상 반복한다.
    범위를 지정하려면 [] 내에 -를 사용한다.
    \d는 숫자를 의미한다. = [0-9]
    \w는 알파벳, 숫자, 언더스코어를 의미한다 = [A-za-z0-9]
    \W는 알파벳, 숫자, 언더스코어가 아닌 문자를 의미한다.
5-5. NOT 검색
    [...] 내의 ^는 not의 의미를 갖는다.
5-6. 시작 위치로 검색
    [...] 밖의 ^은 문자열의 시작을 의미한다.
5-7. 마지막 위치로 검색
    $는 문자열의 마지막을 의미한다.
*/

let tel = '010-1111-1일11';
//정규식 리터럴로 패턴 정의
const phoneRegExp = /^\d{3}-\d{4}-\d{4}$/;
console.log(phoneRegExp.test(tel)); //false

let target = 'Hafa is my Friend!';
//패턴: is
//플래그 : i -> 대소문자를 구별하지 않고 검색
const regExp = /is/i;
console.log(regExp.test(target)); //true

console.log(regExp.exec(target)); //[ 'is', index: 5, input: 'Hafa is my Friend!', groups: undefined ]

console.log(regExp.test(target)); //true

console.log(target.match(regExp)); //[ 'is', index: 5, input: 'Hafa is my Friend!', groups: undefined ]

let target2 = 'Hafa is cat, Hafa is my friend';
const regExp2 = /is/g;
console.log(target2.match(regExp2)); //[ 'is', 'is' ]
console.log(regExp2.exec(target2));
/*
[
  'is',
  index: 5,
  input: 'Hafa is cat, Hafa is my friend',
  groups: undefined
] */
console.log(target2.match(/Is/ig));

let regExp3 = /.../g;
console.log(target2.match(regExp3));
/* 
[
  'Haf', 'a i', 's c',
  'at,', ' Ha', 'fa ',
  'is ', 'my ', 'fri',
  'end'
]
*/

let target3 = 'A AA B BB bB AAA';
//A가 최소 1번 최대 2번 반복되는 문자열을 검색한다.
let regExp4 = /A{1,2}/g;
console.log(target3.match(regExp4)); //[ 'A', 'AA', 'AA', 'A' ]

let regExp5 = /A{2}/g;
console.log(target3.match(regExp5)); //[ 'AA', 'AA' ]

let regExp6 = /A+/g;
console.log(target3.match(regExp6)); //[ 'A', 'AA', 'AAA' ]

let target4 = 'color colour';
let regExp7 = /colou?r/g; //colo다음 u가 0번 이상 반복되고 r이 이어지는 문자열 검색
console.log(target4.match(regExp7)); //[ 'color', 'colour' ]

let regExp8 = /A|B/g;
console.log(target3.match(regExp8));
/*
[
  'A', 'A', 'A', 'B',
  'B', 'B', 'B', 'A',
  'A', 'A'
]
*/

let regExp9 = /A+|B+/g;
console.log(target3.match(regExp9)); //[ 'A', 'AA', 'B', 'BB', 'B', 'AAA' ]

let target5 = 'A, a, B, b, AA, BB, Aa, Bb, Cc, cc, aa, bb';
let regexp1 = /[A-Z]+/g;
console.log(target5.match(regexp1)); 
/*
[
  'A',  'B', 'AA',
  'BB', 'A', 'B',
  'C'
]
 */

//대소문자 구분 없이
let regexp2 = /[A-Za-z]+/g;
console.log(target5.match(regexp2));
/*
[
  'A',  'a',  'B',  'b',
  'AA', 'BB', 'Aa', 'Bb',
  'Cc', 'cc', 'aa', 'bb'
]
*/

//숫자검색
let target6 = 'AA BB 12,345';
let regexp3 = /[0-9]+/g;
console.log(target6.match(regexp3));//[ '12', '345' ]

//쉼표 포함
let regexp4 = /[0-9,]+/g
console.log(target6.match(regexp4)); //[ '12,345' ]

// 숫자를 제외한 문자열
let target7 = 'AA BB 12 Aa Bb';
let regexp5 = /[^0-9]+/g;
console.log(target7.match(regexp5)) // -> ["AA BB ", " Aa Bb"]

// 'https'로 시작하는지 검사
let target8 = 'https://sudar.com';
let regexp6 = /^https/;
console.log(regexp6.test(target8)); // -> true

// 'com'으로 끝나는 검사
let regexp7 = /com$/;
console.log(regexp7.test(target8)); //true

let id = 'abc123';

// 알파벳 대소문자 또는 숫자로 시작하고 끝나며 4 ~ 10자리인지 검사
console.log(/^[A-Za-z0-9]{4,10}$/.test(id)); //true

//메일 주소 형식에 맞는지 검사
let email = 'watermoon14@naver.com';
console.log(/^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/.test(email)); //true