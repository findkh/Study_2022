/*
클로저
1. 렉시컬 스코프
    렉시컬 스코프는 자바스크립트 엔진은 함수를 어디서 호출했는지가 아니라 함수를 어디에 정의했는지에 따라 상위 스코프를 결정한다.
2. 함수 객체의 내부 슬롯 [[Environment]]
    함수는 자신의 내부 슬롯 [[Environment]]에 자신이 정의된 환경, 즉 상위 스코프의 참조를 저장한다.
    따라서 함수 객체의 내부 슬롯 [[Environment]]에 저장된 현재 실행 중인 실행 컨텍스트의 렉시컬 환경의 참조가 상위 스코프다.
    또한 자신이 호출되었을 때 생성될 함수 렉시컬 환경의 외부 렉시컬 환경에 대한 참조에 저장될 참조값이다.
    함수 객체는 내부 슬롯[[Environment]]에 저장한 렉시컬 환경의 참조, 즉 상위 스코프를 자신이 존재하는 한 기억한다.
3. 클로저와 렉시컬 환경
    외부 함수보다 중첩 함수가 더 오래 유지되는 경우 중첩 함수는 이미 생명 주기가 종료한 외부 함수의 변수를 참조할 수 있다. 이러한 중첩 함수를 클로저라고 부른다.
    클로저는 중첩 함수가 상위 스코프의 식별자를 참조하고 있고 중첩 함수가 외부 함수보다 더 오래 유지되는 경우에 한정하는 것이 일반적이다.
    클로저에 의해 참조되는 사우이 스코프의 변수를 자유변수라 부른다.
4. 클로저의 활용
    클로저는 상태를 안전하게 변경하고 유지하기 위해 사용한다.
    상태가 의도치 않게 변경되지 않도록 상태를 안전하게 은닉하고 특정 함수에게만 상태 변경을 허용하기 위해 사용한다.
    변수 값은 누군가에 의해 언제든지 변경될 수 있어 오류 발생의 근본적 원인이 될 수 있다. 외부 상태 변경이나 가변 데이터를 피하고 불변성을 지향하는 함수형 프로그래밍에서 부수 효과를 최대한 억제하여 오류를 피하고 프로그램의 안정성을 높이기 위해 클로저가 사용된다.
5. 캡슐화(encapsulation)와 정보 은닉(information hiding)
    캡슐화는 객체의 상태를 나타내는 프로퍼티와 프로퍼티를 참조하고 조작할 수 있는 동작인 메서드를 하나로 묶는 것을 말한다.
    캡슐화는 객체의 특정 프로퍼티난 메서드를 감출 목적으로 사용하기도 하는데 이를 정보 은닉이라 한다.
    정보은닉은 외부에 공개할 필요가 없는 구현의 일부를 외부에 공개되지 않도록 감추어 적절치 못한 접근으로부터 객체의 상태가 변경되는 것을 방지해 정보를 보호하고, 객체 간의 상호 의존성(결합도)을 낮추는 효과가 있다.
6. 자주 발생하는 실수

*/

const x = 1;

function outer() {
    const x = 10;
    const inner = function () { console.log(x); };
    return inner;
}

const innerFunc = outer();
innerFunc();

//카운트 상태 변경 함수
const increase = function () {
    let num = 0;
    
    return ++num;
}

console.log(increase()); //1
console.log(increase()); //1
console.log(increase()); //1

//num 상태 유지되게 클로저 적용

const increase2 = (function () {
    let num = 0;

    // 클로저
    return function() {
        return ++num;
    };
}());

console.log(increase2()); //1
console.log(increase2()); //2
console.log(increase2()); //3

const counter = (function () {
    let num = 0;

    //클로저인 메서드를 갖는 객체를 반환한다.
    //객체 리터럴은 스코프를 만들지 않는다.
    //따라서 아래 메서드들의 상위 스코프는 즉시 실행 함수의 렉시컬 환경이다.
    return {
        increase3() {
            return ++num;
        },
        decrease3() {
            return --num;
        }
    };
}());

console.log(counter.increase3());
console.log(counter.increase3());

console.log(counter.decrease3());
console.log(counter.decrease3());


//함수를 인수로 전달받고 함수를 반환하는 고차 함수
//이 함수는 카운트 상태를 유지하기 위한 자유 변수 conter를 기억하는 클로저를 반환한다.
function makeCounter(aux) {
    let counter = 0;

    return function() {
        //인수로 전달 받은 보조 함수에 상태 변경을 위임한다.
        counter = aux(counter);
        return counter;
    };
}

//보조함수
function increase(n) {
    return ++n;
}

function decrease(n) {
    return --n;
}

//함수로 함수를 생성한다.
//makeCounter 함수는 보조 함수를 인수로 전달 받아 함수를 반환한다.
const increaser = makeCounter(increase);
console.log(increaser());
console.log(increaser());

//increaser 함수와는 별개의 독립된 렉시컬 환경을 갖기 때문에 카운터 상태가 연동하지 않는다.
const decreaser = makeCounter(decrease);
console.log(decreaser());
console.log(decreaser());

//증감이 가능한 카운터
const counter2 = (function () {
    let counter = 0;
    return function (aux) {
        counter = aux(counter);
        return counter;
    };
}());

function increase2(n) {
    return ++n;
}

function decrease2(n) {
    return --n;
}

console.log(counter2(increase2));
console.log(counter2(increase2));

console.log(counter2(decrease2));
console.log(counter2(decrease2));

function Person(name, age) {
    this.name = name; //public
    let _age = age;
    this.sayHello = function () {
        console.log(`hi my name is ${this.name}. I am ${_age}`);
    };
}

const me = new Person('Park', 20);
me.sayHello(); //hi my name is Park. I am 20
console.log(me.name); //Park
console.log(me._age); //undefined


var funcs = [];
for (var i = 0; i < 3; i++) {
    funcs[i] = (function (id) {
        return function() {
            return id;
        };
    }(i));
}

for (var j = 0; j < funcs.length; j++) {
    console.log(funcs[j]());
}
