/*
1. 자바스크립트 객체의 분류
    - 표준 빌트인 객체(standard built-in objects/native objects/global objects)
        ECMAScript 사양에 정의된 객체를 말하며, 애플리케이션 전역의 공통 기능을 제공한다. 
        표준 빌트인 객체는 자바스크립트 실행 환경과 관계없이 언제나 사용할 수 있다.
        전역 객체의 프로퍼티로서 제공되고 별도의 선언 없이 전역 변수처럼 언제나 참조할 수 있다.
    - 호스트 객체(host objects)
        ECMAScript 사양에 정의되어 있지 않지만 자바스크립트 실행환경에서 추가로 제공하는 객체를 말한다        
    - 사용자 정의 객체(user-defined objects)
        표준 비릍인 객체와 호스트 객체처럼 기본 제공되는 객체가 아닌 직접 정의한 객체를 말한다.
2. 표준 빌트인 객체
    자바스크립트는 40여 개의 표준 빌트인 객체를 제공한다.
    Math, Reflect, JSON 을 제외한 표준 빌트인 객체는 모두 인스턴스를 생성할 수 있는 생성자 함수 객체다.
3. 원시값과 래퍼 객체
    원시값을 객체처럼 사용하면 자바스크립트 엔진은 암묵적으로 연관된 객체를 생성하여 생성된 객체로 프로퍼티에 접근하거나 메서드를 호출하고 다시 원시값으로 되돌린다.
    문자열, 숫자, 불리언 값에 대해 객체처럼 접근하면 생성되는 임시 객체를 래퍼 객체(wrapper object)라 한다.
4. 전역 객체(global object)
    전역 객체는 코드가 실행되기 이전 단계에 자바스크립트 엔진에 의해 어떤 객체보다도 먼저 생성되는 특수한 객체이며, 어떤 객체에도 속하지 않은 최상위 객체다.
    브라우저 환경에서는 window, Node.js 환경에서는 global이 전역 객체를 가리킨다.
    - 전역 객체는 개발자가 의도적으로 생성할 수 없다. 즉 전역 객체를 생성할 수 있는 생성자 함수가 제공되지 않는다. 
    - 전역 객체의 프로퍼티를 참조할 때 widnow(또는 global)를 생략할 수 있다.
    - 전역 객체는 Object, String, Number, Boolean, Function, Array, RegExp, Date, Math, Promise 같은 모든 표준 빌트인 객체를 프로퍼티로 가지고 있다.
    - 자바스크립트 실행 환경에 따라 추가적으로 프로퍼티와 메서드를 갖는다.
    - var 키워드로 선언한 전역 변수와 선언하지 않는 변수에 값을 할당한 암묵적 전역, 그리고 전역 함수는 전역 객체의 프로퍼티가 된다.
4-1. 빌트인 전역 프로퍼티
    빌트인 전역 프로퍼티는 전역 객체의 프로퍼티를 의미한다. 주로 애플리케이션 전역에서 사용하는 값을 제공한다.
        - Infinity : Infinity 프로퍼티는 무한대를 나타내는 숫자값 Infinity를 갖는다.
        - NaN : NaN 프로퍼티는 숫자가 아님(Not a Number)을 나타내는 숫자값 NaN을 갖는다. NaN 프로퍼티는 Number.NaN 프로퍼티와 같다.
        - undefined : undefined 프로퍼티는 원시 타입 undefined를 갖는다.
4-2. 빌트인 전역 함수
    빌트인 전역 함수는 애플리케이션 전역에서 호출할 수 있는 빌트인 함수로서 전역 객체의 메서드다.
        - eval : 자바스크립트 코드를 나타내는 문자열을 인수로 전달 받는다. 전달받은 문자열 코드가 표현식이라면 문자열 코드를 런타임에 평가하여 값을 생성하고,
                 전달받은 인수가 표현식이 아닌 문이라면 eval 함수는 문자열 코드를 런타임에 실행한다.
                 문자열 코드가 여러 개의 문으로 이루어져 있다면 모든 문을 실행한다.
                 인수로 전달 받은 문자열 코드가 여러 개의 문으로 이루어져 있다면 모든 문을 실행한 다음 마지막 결과값을 반환한다.
                 eval 함수는 자신이 호출된 위치에 해당하는 기존의 스코프를 런타임에 동적으로 수정한다.
                 eval 함수를 통해 사용자로부터 입력 받은 콘텐츠를 실행하는 것은 보안에 취약하고, 자바스크립트 엔진에 의해 최적화가 수행되지 않으므로 처리속도가 느리다.
        - isFinite : 전달 받은 인수가 정상적인 유한수인지 검사하여 유한수이면 true를 반환하고, 무한수이면 false를 반환한다.
                     전달 받은 인수의 타입이 숫자가 아닌 경우, 숫자로 타입을 변환한 후 검사를 수행한다.
                     이때 인수가 NaN으로 평가되는 값이라면 false를 반환한다.
                     null은 숫자로 변환하면 0이기 때문에 true를 반환한다.
        - isNaN : 전달 받은 인수가 NaN인지 검사하여 그 결과를 불리언 타입으로 반환한다. 
                  전달 받은 인수의 타입이 숫자가 아닌 경우 숫자로 타입을 변환한 후 검사를 수행한다.
        - parseFloat : 전달 받은 인수를 부동 소수점 숫자, 실수로 해석 하여 반환한다.
                      공백으로 구분된 문자열은 첫 번째 문자열만 반환한다.
                      첫번째 문자열을 숫자로 변환할 수 없다면 NaN을 반환한다.
                      앞 뒤 공백은 무시된다.
        - parseInt : 전달 받은 문자열 인수를 정수로 해석하여 반환한다.
                     전달 받은 인수가 문자열이 아니면 문자열로 변환한 다음 정수로 해석하여 반환한다.
                     두번쨰 인수로 진법을 나타내는 기수를 전달 할 수 있다. 기수를 지정하면 첫 번째 인수로 전달된 문자열을 해당 기수의 숫자로 해석하여 반환한다. 반환값은 언제나 10진수다.
                     기수를 생략하면 첫 번째 인수로 전달된 문자열을 10진수로 해석하여 반환한다.
                     기수를 지정하여 10진수 숫자를 해당 기수의 문자열로 변환하고 싶을 때는 Number.prototype.toString 메서드를 사용한다.
                     두번째 인수로 진법을 나타내는 기수를 지정하지 않더라도 첫 번째 인수로 전달된 문자열이 "0x" 또는 "0x"로 시작하는 16진수 리터럴이라면 16진수로 해석하여 10진수 정수로 반환한다.
                     2진수 리터럴과 8진수 리터럴은 제대로 해석하지 못한다.
                     문자열8진수로 해석하려면 반드시 지수를 지정해야 한다.
        - encodeURI/ decodeURI : encodeURI 함수는 완전한 URI를 문자열로 전달받아 이스케이프 처리를 위해 인코딩한다.
                                 decodeURI 함수는 인코딩된 URI를 인수로 전달받아 이스케이프 처리 이전으로 디코딩한다.
        - encodeURIComponent / decodeURIComponent : encodeURIComponent 함수는 URI 구성 요소를 인수로 전달 받아 인코딩한다.
                                                    decodeURIComponent 함수는 매개변수로 전달된 URI 구성 요소를 디코딩한다.
4-3. 암묵적 전역
    선언하지 않은 함수 내의 변수에 값을 할당하면 전역 객체의 프로퍼티가 되어 전역 변수처럼 동작한다. 이러한 현상을 암묵적 전역이라 한다.
    변수가 아니므로 변수 호이스팅이 발생하지 않는다.
    변수가 아닌 프로퍼티이기 때문에 delete 연산자로 삭제할 수 있다.
        

*/
console.log(window.parseInt('F', 16)); //15
console.log(parseInt('F', 16)); //15
console.log(window.parseInt === parseInt); //true

var foo = 1;
console.log(window.foo); //1
foo2 = 2;
console.log(window.foo2);//2
let foo3 = 3;
console.log(window.foo3); //undefined
//let이나 const 키워드로 선언한 전역 변수는 전역 객체의 프로퍼티가 아니다.

console.log(window.Infinity === Infinity);//true
//양의 무한대
console.log(3/0);
//음의 무한대
console.log(-3/0);
//Infinity는 숫자값이다.
console.log(typeof Infinity); //number

console.log(window.NaN); //NaN
console.log(Number('sudal')); //NaN
console.log(typeof NaN); //number

//eval
//표현식인 문
console.log(eval('1 + 2;')); //3
//표현식이 아닌 문
console.log(eval('var x = 5;')); //undefined

//eval 함수에 의해 런타임에 변수 선언문이 실행되어 x 변수가 선언됨
console.log(x); //5

//객체 리터럴은 반드시 괄호로 둘러싼다.
const o = eval('({a: 1})');
console.log(o); //{a: 1}

//함수 리터럴은 반드시 괄호로 둘러싼다.
const f = eval('(function() { return 1;})');
console.log(f()); //1

//eval 함수 동적 수정
const a = 7;
function foo4() {
    eval('var a = 8;');
    console.log(a); //8
}

foo4();
console.log(a); //7

console.log(isFinite(0)); //true
console.log(isFinite(2e64)); //true
console.log(isFinite('10')); //true
console.log(isFinite(Infinity)); //false
console.log(isFinite(NaN)); //false
console.log(isFinite('Hello')); //false
console.log(isFinite(null)); //true

console.log(isNaN(NaN)); //true
console.log(isNaN(10)); //false
console.log(isNaN('sudal')); //true
console.log(isNaN(' ')); //false

console.log(isNaN(true)); //false
console.log(isNaN(null)); //false null -> 0
console.log(isNaN({})); //true
console.log(isNaN(new Date())); //false

console.log(parseInt('10'));
console.log(parseInt('10', 2)); //2
console.log(parseInt('10', 8)); //8
console.log(parseInt('10', 16)); //16

const x3 = 15;
console.log(x3.toString(2)); //1111
//2진수로 해석하고 그 결과를 10진수 정수로 반환한다.
console.log(parseInt(x3.toString(2), 2)); //15

console.log(parseInt('0xf')); //15
console.log(parseInt('f', 16)); //15

console.log(parseInt('0b10')); //0
console.log(parseInt('0o10'));//10
console.log(parseInt('10', 2)); //2
console.log(parseInt('10', 8)); //8

const uri = 'http://test.com?no=1&name=sudal'
const enc = encodeURI(uri);
console.log(enc)

const uriComp = 'name=수달&job=programmer';
let enc2 = encodeURIComponent(uriComp);
console.log(enc2);
console.log(decodeURIComponent(enc2));