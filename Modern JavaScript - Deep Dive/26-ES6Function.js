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
3. 화살표 함수
3-1. 화살표 함수 정의
    - 함수 정의
        화살표 함수는 함수 선언문으로 정의할 수 없고 함수 표현식으로 정의해야 한다. 호출 방식은 기본 함수와 동일하다.
    - 매개변수 선언
        매개변수가 여러 개인 경우 소괄호 () 안에 매개변수를 선언한다. 매개변수가 한 개인 경우 소괄호를 생략할 수 있다. 매개 변수가 없는 경우 소괄호를 생략할 수 없다.
    - 함수 몸체 정의
        함수 몸체가 하나의 문으로 구성된다면 함수 몸체를 감싸는 중괄호를 생략할 수 있다.
        이때 함수 몸체 내부의 문이 값으로 평가될 수 있는 표현식인 문이라면 암묵적으로 반환된다.
        함수 몸체를 감싸는 중괄호를 생략한 경우 함수 몸체 내부의 문이 표현식이 아닌 문이라면 에러가 발생한다.
        객체 리터럴을 반환하는 경우 객체 리터럴은 소괄호로 감싸주어야 한다.
        객체 리터럴을 소괄호로 감싸지 않으면 객체 리터럴의 중괄호를 함수 몸체에 감싸는 중괄호로 잘못해석한다.
        함수 몸체가 여러 개의 문으로 구성된다면 중괄호를 생략할 수 없고, 반환값이 있다면 명시적으로 반환해야 한다.
        화살표 함수도 즉시 실행 함수로 사용할 수 있다.
        화살표 함수도 일급 객체이므로 map, filter, reduce 같은 고차 함수에 인수로 전달 할 수 있다.
3-2. 화살표 함수와 일반 함수의 차이
    - 화살표 함수는 인스턴스를 생성할 수 없는 non-constructor다.
        인스턴스를 생성할 수 없으므로 prototype 프로퍼티가 없고 프로토타입도 생성하지 않는다.
    - 중복된 매개변수 이름을 선언할 수 없다.
        일반 함수는 중복된 매개변수 이름을 선언해도 에러가 발생하지 않는다.
    - 화살표 함수는 함수 자체의 this, arguments, super, new.target 바인딩을 갖지 않는다.
        화살표 함수 내부에서 this, arguments, super, new.target을 참조하면 스코프 체인을 통해 상위 스코프의 this, arguemnts, super, new.target을 참조한다.
        화살표 함수와 화살표 함수가 중첩되어 있다면 스코프 체인 상에서 가장 가까운 상위 함수 중에서 화살표 함수가 아닌 함수를 참조한다.
3-3. this
    화살표 함수는 함수 자체의 this 바인딩을 갖지 않는다. 따라서 화살표 함수 내부에서 this를 참조하면 상위 스코프의 this를 그대로 참조한다. 이를 lexical this라 한다.
    렉시컬 스코프와 같이 화살표 함수의 this가 함수가 정의된 위치에 의해 결정된다.
3-4. super
    함수 자체의 super 바인딩을 갖지 않는다. 화살표 내부에서 super를 참조하면 this와 마찬가지로 상위 스코프의 super를 참조한다.
3-5. arguments
    함수 자체의 arguments 바인딩을 갖지 않는다. this와 마찬가지로 상위 스코프의 arguments를 참조한다.
4. Rest 파라미터
4-1. 기본 문법
    Rest 파라미터(나머지 매개변수)는 매개변수 이름 앞에 세개의 점을 붙여서 정의한 매개변수를 의미한다.
    Rest 파라미터는 함수에 전달된 인수들의 목록을 배열로 전달 받는다.
    일반 매개변수와 Rest 파라미터는 함께 사용할 수 있다. 함수에 전달된 인수들은 매개변수와 Rest 파라미터에 순차적으로 할당된다.
    Rest 파라미터는 반드시 마지막 파라미터여야 하고 단 하나만 선언할 수 있다.
    length 프로퍼티에 영향을 주지 않는다.
4-2. Rest 파라미터와 arguments 객체
    함수와 ES6 메서드는 Rest 파라미터와 arguments 객체를 모두 사용할 수 있다. 하지만 화살표 함수는 함수 자체의 arguments 객체를 갖지 않는다. 따라서 화살표 함수로 가변 인자 함수를 구현해야 할 때 반드시 Rest 파라미터를 사용해야한다.
5. 매개변수 기본값
    자바스크립트 엔진은 매개변수만큼 인수를 전달하지 않아도 매개변수의 개수와 인수의 개수를 체크하지 않기 떄문에 에러가 발생하지 않는다.
    인수가 전달되지 않은 매개변수의 값은 undefined다.
    매개변수에 인수가 전달되었는지 확인하여 인수가 전달되지 않은 경우 매개변수에 기본값을 할당할 필요가 있다(방어코드)
    ES6에서 도입된 매개변수 기본값을 사용하면 함수 내에서 수행하던 인수 체크 및 초기화를 간소화할 수 있다.
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

// const derived = {
//     __proto__: base,

//     sayHi() {
//         return `${super.sayHi()}. how are you doing?`;
//     }
// };

// console.log(derived.sayHi());

//화살표함수
const multiply = (x, y) => x * y;
console.log(multiply(2, 3)); //6

const power = x => x **2;
console.log(power(2));
// const power = x => { return x ** 2; };
// console.log(power2(2));

//객체 리터럴을 반환하는 경우 소괄호로 감싸주어야 한다.
const create = (id, content) => ({ id, content });
console.log(create(1, 'javaScript')); //{ id: 1, content: 'javaScript' }
// const create = (id, content) => { return {id, content}; };
// console.log(create(1, 'javaScript'));

//화살표함수 즉시 실행함수
const person = (name => ({
    sayHi() { return `Hi? My name is ${name}.`; }
}))('Park');
console.log(person.sayHi()); //Hi? My name is Park.

//화살표 함수 고차 함수
//ES5
[1,2,3].map(function(v) {
    return v * 2;
});

//ES6
console.log([1,2,3].map(v => v * 2)); //[ 2, 4, 6 ]

//콜백 함수 내부의 this 문제 해결
class Prefixer {
    constructor(prefix) {
        this.prefix = prefix;
    }

    add(arr) {
        return arr.map(item => this.prefix + item);
    }
}

const prefixer = new Prefixer('-webkit-');
console.log(prefixer.add(['transition', 'user-select'])); //[ '-webkit-transition', '-webkit-user-select' ]

//super
class Base {
    constructor(name) {
        this.name = name;
    }

    sayHi() {
        return `Hi! ${this.name}`;
    }
}

class Derived extends Base {
    //화살표 함수의 super는 상위 스코프인 constructor의 super를 가리킨다.
    sayHi = () => `${super.sayHi()} how ard you doing?`;
}

const derived = new Derived('hafa');
console.log(derived.sayHi()); //Hi! hafa how ard you doing?

(function() {
    const foo2 = () => console.log(arguments);
    foo2(3,4);
}(1, 2));

const foo2 = () => console.log(arguments);
foo2(1, 2);

//Rest 파라미터
function foo3(...rest) {
    console.log(rest); //[1, 2, 3, 4, 5, 6, 7]
}
foo3(1,2,3,4,5,6,7);

function foo4(param, ...rest) {
    console.log(param); //1
    console.log(rest); //[ 2, 3, 4 ]
}
foo4(1,2,3,4);

function sum(x, y) {
    //인수가 전달되지 않아 매개변수의 값이 undefined인 경우 기본값을 할당한다.
    x = x || 0;
    y = y || 0;

    return x + y;
}
console.log(sum(1, 2)); //3
console.log(sum(2)); //2

//ES6 -> 매개변수 기본값은 매개변수에 인수를 전달하지 않은 경우와 undefined를 전달한 경우에만 유효하다.
function sum2(x = 0, y = 0) {
    return x + y;
}
console.log(sum2(1,2)); //3
console.log(sum2(2)); //2