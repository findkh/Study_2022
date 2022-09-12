/*
ES6 함수의 추가 기능
1. 함수의 구분
    ES6 이전의 모든 함수는 일반 함수로서 호출할 수 있는 것은 물론 생성자 함수로서 호출할 수 있다.
    ES6 이전의 모든 함수는 callable이면서 constructor다.
2. 메서드
    ES6 사양에서 메서드는 메서드 축약 표현으로 정의된 함수만을 의미한다.
    ES6 사양에서 정의한 메서드는 인스턴스를 생성할 수 없는 non-constructor다. 따라서 ES6 메서드는 생성자 함수로서 호출할 수 없다.
    ES6 메서드는 자신을 바인딩한 객체를 가리키는 내부슬롯 [[HomeObject]]를 갖는다. 
    super 참조는 내부 슬롯[HomeObject]를 사용하여 수퍼클래스의 메서드를 참조하므로 내부 슬롯[[HomeObject]]를 갖는 ES6 메서드는 super 키워드를 사용할 수 있다.
*/

var foo = function() {
    return 1;
};

//일반적인 함수로서 호출
foo();

//생성자 함수로서 호출
new foo();

//메서드로서 호출
var obj = {foo : foo};
obj.foo();

[1, 2, 3].map(function (item) {
    return item * 2;
});

// const obj = {
//     x: 1,
//     //foo는 메서드다.
//     foo() {return this.x;},
//     //bar에 바인딩된 함수는 메서드가 아닌 일반 함수다.
//     bar: function() { return this.x; }
// };
// console.log(obj.foo());
// console.log(obj.bar());

const base = {
    name: 'Lee',
    sayHi() {
        return `Hi! ${this.name}`;
    }
};

const derived = {
    __proto__: base,

    sayHi() {
        return `${super.sayHi()}. how are you doing?`;
    }
};

console.log(derived.sayHi());