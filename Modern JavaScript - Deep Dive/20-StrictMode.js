/*
1. strict mode
자바스크립트 언어의 문법을 좀 더 엄격히 적용하여 오류를 발생시킬 가능성이 높거나 자바스크립트 엔진의 최적화 작업에 문제를 일으킬 수 있는 코드에 대해 명시적인 에러를 발생시킨다.
2. strict mode 적용
    전역의 선두 또는 함수 몸체의 선두에 use strict;를 추가한다.
    전역의 선두에 추가하면 스크립트 전체에  strict mode가 적용된다.
3. 전역에 strict mode를 적용하는 것은 피하자
    전역에 적용한 strict mode는 스크립트 단위로 적용된다.
    strict mode 스크립트와 none-strict mode 스크립트를 혼용하는 것은 오류가 발생할 수 있으니 전역에 적용하는 것은 바람직하지 않다.
    즉시 실행 함수로 스크립트 전체를 감싸서 스코프를 구분하고 즉시 실행함수의 선두에 strict mode를 적용한다.
4. strict mode를 적용하는 것도 피하자
    함수단위로 적용할 때도 strict mode를 적용한 것과 적용하지 않은 것이 섞이면 문제가 발생할 수 있다.
    따라서 strict mode는 즉시 실행 함수로 감싼 스크립트 단위로 적용하는 것이 바람직하다.
5. strict mode가 발생시키는 에러
5-1. 암묵적 전역
    선언하지 않은 변수를 참조하면 ReferenceError가 발생한다.
5-2. 변수, 함수, 매개변수의 삭제
    delete 연산자로 변수, 함수, 매개변수를 삭제하면 SyntaxError가 발생한다.
5-3. 매개 변수 이름의 중복
    중복된 매개이름 변수를 사용하면 SyntaxError가 발생한다.
5-4. with 문의 사용
    with 문을 사용하면 SyntaxError가 발생한다.
6. stric mode 적용에 의한 변화
6-1. 일반 함수 this
    stric mode에서 함수를 일반 함수로서 호출하면 this에 undefined가 바인딩된다.
    생성자 함수가 아닌 일반 함수 내부에서는 this를 사용할 필요가 없기 때문이다. 이때 에러는 발생하지 않는다.
6-2. arguments 객체
    strict mode에서는 매개변수에 전달된 인수를 재할당하여 변경해도 arguments 객체에 반영되지 않는다.
*/

//5-1 에러
// (function () {
//     'use strict';

//     x = 1;
//     console.log(x); //Uncaught ReferenceError: x is not defined
// }());


//5-2 에러
(function () {
    'use strict';

    var x = 1;
    //delete x; //Uncaught SyntaxError: Delete of an unqualified identifier in strict mode.

    function foo(a) {
        //delete a; //Uncaught SyntaxError: Delete of an unqualified identifier in strict mode.
    }
    //delete foo; //Uncaught SyntaxError: Delete of an unqualified identifier in strict mode.
}());

//5-3 에러
(function () {
    'use strict';
    // function foo(x, x) { //Uncaught SyntaxError: Duplicate parameter name not allowed in this context
    //     return x + x;
    // }
    //console.log(foo(1, 2));
}());

//5-4 에러
(function () {
    'use strict';
    
    //Uncaught SyntaxError: Strict mode code may not include a with statement
    // with({x:1}) {
    //     console.log(x);
    // }
}());

//6-1
(function () {
    'use strict';
    
    function foo() {
        console.log(this); //undefined
    }

    foo();

    function Foo() {
        console.log(this); //Foo{}
    }
    new Foo();
}());

//6-2
(function (a) {
    'use strict';
    //매개변수에 전달된 인수를 재할당하여 변경
    a = 2;

    //변경된 인수가 arguments 객체에 반영되지 않는다.
    console.log(arguments); //Arguments [1, callee: (...), Symbol(Symbol.iterator): ƒ]
}(1));