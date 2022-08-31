/*
1. this 키워드
    동작을 나타내는 메서드는 자신이 속한 객체의 상태, 즉 프로퍼티를 참조하고 변경할 수 있어야 한다. 이때 메서드가 자신이 속한 객체의 프로퍼티를 참조하려면 먼저 자신이 속한 객체를 가리키는 식별자를 참조할 수 있어야 한다.
    객체 리터럴 방식으로 생성한 객체의 경우 메서드 내부에서 메서드 자신이 속한 객체를 가리키는 식별자를 재귀적으로 참조할 수 있다.
    this는 자신이 속한 객체 또는 자신이 생성할 인스턴스를 가리키는 자기 참조 변수(self-referencing variable)다.
    this를 통해 자신이 속한 객체 또는 자신이 생성할 인스턴스의 프로퍼티나 메서드를 참조할 수 있다.
    this가 가리키는 값(this 바인딩)은 함수 호출 방식에 의해 동적으로 결정된다.
    this는 코드 어디에서든 참조 가능하다.(전역, 함수내부)
2. 함수 호출 방식과 this 바인딩
    this 바인딩은 함수 호출 방식, 즉 함수가 어떻게 호출되었는지에 따라 동적으로 결정된다.
2-1. 일반 함수 호출
    기본적으로 this에는 전역 객체가 바인딩된다.
    전역함수, 중첩 함수를 일반 함수로 호출하면 함수 내부의 this에는 전역 객체가 바인딩된다.
    객체를 생성하지 않는 일반 함수에서 this는 의미가 없다.
    strict mode가 적용된 일반 함수 내부의 this에는 undefined가 바인딩된다.
2-2. 메서드 호출
    메서드 내부의 this에는 메서드를 호출한 객체(메서드 호출할 때 마침표 연산자 앞에 기술한 객체)가 바인딩 된다.
    주의할 것은 메서드 내부의 this는 메서드를 소유한 객체가 아닌 메서드를 호출한 객체에 바인딩된다
2-3. 생성자 함수 호출
    생성자 함수 내부의 this에는 생성자 함수가 (미래에) 생성할 인스턴스가 바인딩된다.
2-4. Function.prototype.apply/call/bind 메서드에 의한 간접 호출
    이들 메서드는 모두 함수가 상속받아 사용할 수 있다.
    apply와 call 메서드의 본질적인 기능은 함수를 호출하는 것이다. apply와 call 메서드는 함수를 호출하면서 첫 번째 인수로 전달한 특정 객체를 호출한 함수의 this에 바인딩한다.
    apply 메서드는 호출할 함수의 인수를 배열로 묶어 전달하고,
    call 메서드는 인수를 쉼표로 구분한 리스트 형식으로 전달한다.
    bind 메서드는 메서드의 this와 메서드 내부의 중첩 함수 또는 콜백 함수의 this가 불일치하는 문제를 해결하기 위해 사용된다.


*/

//객체 리터럴
const circle = {
    //프로퍼티 : 객체 고유의 상태
    radius: 5,
    //메서드 :  상태 데이터를 참조하고 조작하는 동작
    getDiameter() {
        return 2 * circle.radius;
    }
};
console.log(circle.getDiameter()); //10

//생성자 함수
function Circle(radius) {
    this.radius = radius;
}

Circle.prototype.getDiameter = function () {
    return 2 * this.radius;
};

//인스턴스 생성
const circle2 = new Circle(5);
console.log(circle2.getDiameter());

//전역에서 this는 전역 객체 window를 가리킨다.
console.log(this); //Window

//일반 함수 내부에서 this는 전역 객체 window를 가리킨다.
function square(number) {
    console.log(this); //Window
    return number * number;
}
square(2);

//메서드 내부에서 this는 메서드를 호출한 객체를 가리킨다.
const person = {
    name: 'park',
    getName() {
        console.log(this); //{name: 'park', getName: ƒ}
        return this.name;
    }
};
console.log(person.getName()); //park

//생성자 함수 내부에서 this는 생성자 함수가 생성할 인스턴스를 가리킨다.
function Person(name) {
    this.name = name;
    console.log(this); //Person {name: 'hafa'}
}

const me = new Person('hafa');

function getThisBinding() {
    console.log('arguments', arguments); 
    //Arguments(3) [1, 2, 3, callee: ƒ, Symbol(Symbol.iterator): ƒ]
    //Arguments(3) [1, 2, 3, callee: ƒ, Symbol(Symbol.iterator): ƒ]
    return this;
}

//this로 사용할 객체
const thisArg = { a: 1 };

//getThisBinding 함수를 호출하면서 인수로 전달한 객체를 getThisBinding 함수의 this에 바인딩한다.
//apply 메서드는 호출할 함수의 인수를 배열로 묶어 전달한다.
console.log(getThisBinding.apply(thisArg, [1,2,3])); //{a: 1}

//call 메서드는 호출할 함수의 인수를 쉼표로 구분한 리스트 형식으로 전달한다.
console.log(getThisBinding.call(thisArg, 1, 2, 3)); //{a: 1}

const person2 = {
    name : 'lee',
    foo2(callback) {
        //bind 메서드로 callback 함수 내부의 this 바인딩을 전달
        setTimeout(callback.bind(this), 100)
    }
};

person2.foo2(function () {
    console.log(`Hi my name is ${this.name}`); //Hi my name is lee
});