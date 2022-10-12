/*
String
1. String 생성자 함수
    new 연산자와 함꼐 호출하여 String 인스턴스를 생성할 수 있다.
    String 생성자 함수의 인수로 문자열을 전달하면서 new 연산자와 함께 호출하면 [[StringData]] 내부 슬롯에 인수로 전달 받은 문자열을 할당한 String 래퍼 객체를 생성한다.
    인수로 문자열이 아닌 값을 전달하면 인수를 문자열로 강제 변환한 후, [[StringData]] 내부 슬롯에 변환된 문자열을 할당한 String 래퍼 객체를 생성한다.
    new 연산자를 사용하지 않고 String 생성자 함수를 호출하면 String 인스턴스가 아닌 문자열을 반환한다. 이를 이용하여 명시적으로 타입을 변환하기도 한다.
2. length 프로퍼티
    문자열의 문자 개수를 반환한다.
3. String 메서드
    String 객체의 메서드는 언제나 새로운 문자열을 반환한다. 문자열은 불가능한 원시 값이기 때문에 String 래피 객체도 읽기 전용 객체로 제공된다.
3-1. String.prototype.indexOf
    indexOf 메서드는 대상 문자열에서 인수로 전달받은 문자열을 검색하여 첫 번쨰 인덱스를 반환한다. 검색에 실패하면 -1을 반환한다.
3-2. String.prototype.search
    search 메서드는 대상 문자열에서 인수로 전달받은 정규 표현식과 매치하는 무낮열을 검색하여 일치하는 문자열의 인덱스를 반환한다. 검색에 실패하면 -1을 반환한다.
3-3. String.prototype.includes
    대상 문자열에 인수로 전달받은 문자열이 포함되어 있는지 확인하여 그 결과를 true 또는 false로 반환한다.
3-4. String.prototype.startWith
    대상 문자열이 인수로 전달받은 문자열로 시작하는지 확인하여 그 결과를 true 또는 false로 반환한다.
3-5. String.prototype.endWith
    대상 문자열이 인수로 전달받은 무낮열로 끝나는지 확인하여 그 결과를 true 또는 false로 반환한다.
3-6. String.prototype.charAt
    문자열에서 인수로 전달받은 인덱스에 위치한 문자를 검색하여 반환한다.
    문자열의 범위는 정수여야 한다. 인덱스가 문자열의 범위를 벗어난 정수인 경우 빈 문자열을 반환한다.
    chartAt 메서드와 유사한 문자열 메서드는 chartCodeAt과 codePointAt이 있다.
3-7. String.prototype.substring
    대상 문자열에서 첫 번쨰 인수로 전달받은 인덱스에 위치하는 문자부터 두 번쨰 인수로 전라받은 인덱스에 위치하는 문자의 바로 이전 문자까지의 부분 문자열을 반환한다.
    두 번쨰 인수는 생략할 수 있다. 이때는 첫번째 인수로 전달한 인덱스에 위치하는 문자부터 마지막 문자까지 부분 문자열을 반환한다.
    indexOf 메서드와 함께 사용할 수 있다.
3-8. String.prototype.slice
    substring 메서드와 동일하게 동작한다. 단 slice 메서드에는 음수인 인수를 전달 할 수 있다.
    음수인 인수를 전달하면 대상 문자열의 가장 뒤에서부터 시작하여 문자열을 잘라내어 반환한다.
3-9. String.prototype.toUpperCase
    toUpperCase 메서드는 대상 문자열을 모두 대문자로 변경한 문자열을 반환한다.
3-10. String.prototype.toLowerCase
    대상 문자열을 모두 소문자로 변경한 문자열을 반환한다.
3-11. String.prototype.trim
    대상 문자열 앞뒤에 공백 문자가 있을 경우 이를 제거한 무낮열을 반환한다.
3-12. String.prototype.repeat
    대상 문자열을 인수로 전달받은 정수만큼 반복해 연결한 새로운 문자열을 반환한다.
    인수로 전달받은 정수가 0이면 빈 문자열을 반환하고, 음수이면 RageError를 발생시킨다.
    인수를 생략하면 기본값 0이 설정된다.
3-13. String.prototype.replace
    대상 문자열에서 첫 번쨰 인수로 전달받은 문자열 또는 정규 표현식을 검색하여 두 번째 인수로 전달한 문자열로 치환한 문자열을 반환한다.
    검색된 문자열이 여럿 존재할 경우 첫번째로 검색된 문자열만 치환한다.
3-14. String.prototype.split
    대상 문자열에서 첫 번째 인수로 전달한 문자열 또는 정규 표현식을 검색하여 문자열을 구분한 후 분리된 각 문자열로 이루어진 배열을 반환한다.
    인수로 빈 문자열을 전달하면 각 문자를 모두 분리하고 인수를 생략하면 대상 문자열 전체를 단일 요소로 한느 배열을 반환한다.
*/

const str = 'Hello world';
console.log(str.indexOf('l')); //2
console.log(str.indexOf('a')); //-1

console.log(str.search(/o/)); //4
console.log(str.search(/a/)); //-1

if(str.includes('Hello')) {
    console.log('Hello 있음'); //Hello 있음
}

console.log(str.startsWith('He')); //true
console.log(str.startsWith('wo')); //false
//문자열 str의 인덱스 6부터 시작하는 문자열이 wo로 시작하는지 확인
console.log(str.startsWith('wo', 6)); //true


console.log(str.endsWith('ld')); //true
console.log(str.endsWith('lo', 5)); //true

for(let i = 0; i < str.length; i++) {
    console.log(str.charAt(i));
    /*
    H
    e
    l
    l
    o
    
    w
    o
    r
    l
    d
    */
}

console.log(str.substring(0,5)); //Hello
console.log(str.substring(0, str.indexOf(' '))); //Hello

console.log(str.slice(0,5)); //Hello
console.log(str.slice(-5)); //world

const str2 = 'abc'
console.log(str2.repeat()); // ''
console.log(str2.repeat(0)); // ''
console.log(str2.repeat(1)); //abc
console.log(str2.repeat(2)); //abc
console.log(str2.repeat(2.5)); //abc
//console.log(str2.repeat(-1)); //RangeError: Invalid count value

const str3 = 'How are you doing?'
console.log(str3.split(' ')); //[ 'How', 'are', 'you', 'doing?' ]
console.log(str3.split(''));
/*
[
  'H', 'o', 'w', ' ', 'a',
  'r', 'e', ' ', 'y', 'o',
  'u', ' ', 'd', 'o', 'i',
  'n', 'g', '?'
]
*/
console.log(str3.split()); //[ 'How are you doing?' ]
console.log(str3.split(' ', 3)); //[ 'How', 'are', 'you' ]
