/*
Number
1. Number 생성자 함수
    표준 빌트인 객체인 Number 객체는 생성자 함수 객체다. new 연산자와 함께 호출하여 Number 인스턴스를 생성할 수 있다.
2. Number 프로퍼티
2-1. Number.EPSILON
    Number.EPSILON은 1과 1보다 큰 숫자 중에서 가장 작은 숫자와의 차이와 같다.
    부동소수점으로 인해 발생하는 오차를 해결하기 위해 사용한다. 
2-2. Number.MAX_VALUE
    Number.MAX_VALUE는 자바스크립트에서 표현할 수 있는 가장 큰 양수 값이다.
    Number.MAX_VALUE보다 큰 숫자는 Infinity다.
2-3. Number.MIN_VALUE
    Number.MIN_VALUE는 자바스크립트에서 표현할 수 있는 가장 작은 양수 값이다. 
    Number.MIN_VALUE보다 작은 숫자는 0이다.
2-4. Number.MAX_SAFE_INTEGER
    자바스크립트에서 안전하게 표현할 수 있는 가장 큰 정수값이다.
2-5. Number.MIN_SAFE_INTEGER
    자바스크립트에서 안전하게 표현할 수 있는 가장 작은 정수값이다.
2-6. Number.POSITIVE_INFINITY
    양의 무한대를 나타내는 숫자값 Infinity와 같다.
2-7. Number.NEGATIVE_INFINITY
    음의 무한대를 나타내는 숫자값 iInfinity와 같다.
2-8. Number.NaN
    숫자가 아님을 나타내는 숫자값이다. window.NaN과 같다.
3. Number 메서드
3-1. Number.isFinite
    Number.isFinite 정적 메서드는 인수로 전달된 숫자값이 정상적인 유한수, Infinity 또는 -Infinity가 아닌지 검사하여 그 결과를 불리언 값으로 반환한다.
3-2. Number.isInteger
    인수로 전달된 숫자값이 정수인지 검사하여 그 결과를 불리언 값으로 반환한다. 검사하기 전에 인수를 숫자로 암묵적 타입 변환하지 않는다.
3-3. Number.isNaN
    인수로 전달된 숫자 값이 NaN인지 검사하여 그 결과를 불리언 값으로 반환한다.
3-4. Number.isSafeInteger
    인수로 전달된 숫자값이 안전한 정수인지 검사하여 그 결과를 불리언 값으로 반환한다. 검사하기 전에 인수를 숫자로 암묵적 타입 변환하지 않는다.
3-5. Number.prototype.toExpoonential
    숫자를 지수 표기법으로 변환하여 문자열로 반환한다.
3-6. Number.prototype.toFixed
    숫자를 반올림하여 문자열로 반환한다.. 인수를 생략하면 기본값이 지정된다.
3-7. Number.prototype.toPrecision
    인수로 전달받은 전체 자릿수까지 유효하도록 나머지 자릿수를 반올림하여 문자열로 반환한다.
    인수로 전달 받은 전체 자릿수롤 표현할 수 없는 경우 지수 표기법으로 결과를 반환한다.
3-8. Number.prototype.toString
    숫자를 문자열로 변환하여 반환한다. 
 */

let numObj = new Number(10);
console.log(numObj); //[Number: 10]

numObj = new Number('Hello');
console.log(numObj); //[Number: NaN]

//epsilon
function isEqual(a, b) {
    return Math.abs(a - b) < Number.EPSILON;
}
console.log(isEqual(0.1 + 0.2, 0.3)); //true

console.log(Number.isFinite(0)); //true
console.log(Number.isFinite(Number.MAX_VALUE)); //true
console.log(Number.isFinite(Infinity)); //false

console.log((12345.6789).toFixed(2)); //12345.68