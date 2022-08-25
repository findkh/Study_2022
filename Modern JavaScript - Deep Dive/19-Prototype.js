/*
자바스크립트는 명령형, 함수형, 프로토타입 기반 객체지향 프로그래밍을 지원하는 멀티 패러다임 프로그래밍 언어다.
1. 객체지향 프로그래밍
    다양한 속성 중에서 프로그램에 필요한 속성만 간추려 표현하는 것을 추상화(abstract)라 한다.
    속성을 통해 여러 개의 값을 하나의 단위로 구성한 복합적인 자료구조를 객체라하며, 
    객체지향 프로그래밍은 독립적인 객체의 집합으로 프로그램을 표현하려는 프로그래밍 패러다임이다.
    또한 객체는 상태 데이터와 동작을 하나의 논리적인 단위로 묶은 복합적인 자료구조라고 할 수 있다.
    이때 객체의 상태 데이터를 프로퍼티, 동작을 메서드라 부른다.
2. 상속(inheritance)과 프로토타입
    상속은 어떤 객체의 프로퍼티 또는 메서드를 다른 객체가 상속받아 그대로 사용할 수 있는 것을 말한다.
    프로토타입을 기반으로 상속을 구현하며 기존의 코드를 재사용하여 불필요한 중복을 제거한다.
    자바스크립트는 프로토타입을 기반으로 상속을 구현한다.
3. 프로토타입 객체
    객체지향 프로그래밍의 근간을 이루는 객체 간 상속을 구현하기 위해 사용된다. 
    프로토타입은 어떤 객체의 상위 객체의 역할을 하는 객체로서 다른 객체에 공유 프로퍼티를 제공한다.
    프로토타입을 상속받은 하위 객체는 상위 객체의 프로퍼티를 자신의 프로퍼티처럼 자유롭게 사용할 수 있다.
    객체가 생성될 때 객체 생성 방식에 따라 프로토타입이 결정되고 [[Prototype]]에 저장된다.
3-1. __proto__ 접근자 프로퍼티
    - __proto__는 접근자 프로터피다.
        모든 객체는 __proto__ 접근자 프로퍼티를 통해 자신의 프로토타입 [[Prototype]] 내부 슬롯에 간접적으로 접근할 수 있다.
    - __proto__ 접근자 프로퍼티는 상속을 통해 사용된다.
        객체가 직접 소유하는 프로퍼티가 아니라 Object.prototype의 프로퍼티다. 모든 객체는 상속을 통해 Object.prototype.__proto__ 접근자 프로퍼티를 사용할 수 있다.
    - __proto__ 접근자 프로퍼티를 통해 프로토타입에 접근하는 이유
        상호 참조에 의해 프로토타입 체인이 생성되는 것을 방지하기 위해서다.
        순환 참조하는 프로토타입 체인이 만들어지면 프로토타입 체인 종점이 존재하지 않기 때문에 무한루프에 빠진다.
    - __proto__ 접근자 프로퍼티를 코드 내에서 직접 사용하는 것은 권장하지 않는다.
        ES6에서 표준으로 채택되었지만 코드내에서 __proto__접근자 프로퍼티를 직접 사용하는 것은 권장하지 않는다.
        모든 객체가 사용할 수 있는 것은 아니기 때문이다.
3-2. 함수 객체의 prototype 프로퍼티
    함수 객체만이 소유하는 prototype 프로퍼티는 생성자 함수가 생성할 인스턴스의 프로토타입을 가리킨다.
    생성자 함수로서 호출할 수 없는 함수(non-constructor)인 화살표 함수와 ES6 메서드 축약 표현으로 정의한 메서드는 prototype 프로퍼티를 소유하지 않으며 프로토타입도 생성하지 않는다.
    생성자 함수로 호출하기 위해 정의하지 않은 일반함수도 prototype 프로퍼티를 소유하지만 객체를 생성하지 않는 일반 함수의 prototype 프로퍼티는 아무런 의미가 없다.
    모든 객체가 가지고 있는 __proto__ 접근자 프로퍼티와 함수 객체만이 가지고 있는 prototype 프로퍼티는 결국 동일한 프로토타입을 가리킨다.
    프로퍼티를 사용하는 주체가 다르다.
3-3 프로토타입의 constructor 프로퍼티와 생성자 함수
    모든 프로토타입은 constructor 프로퍼티를 갖는다. 이 consrtructor 프로퍼티는 prototype 프로퍼티로 자신을 참조하고 있는 생성자 함수를 가리킨다.
    이 연결은 생성자 함수가 생성될 때, 즉 함수 객체가 생성될 때 이루어진다.

*/

//---------------------상속 구현-----------------------------
//생성자 함수
function Circle(radius) {
    this.radius = radius;
};

//Circle 생성자 함수가 생성한 모든 인스턴스가 getArea 메서드를 공유해서 사용할 수 있도록 프로토타입 추가
//프로토타입은 Circle 생성자 함수의 prototype 프로퍼티에 바인딩 되어 있다.
Circle.prototype.getArea = function() {
    return Math.PI * this.radius ** 2;
};

//인스턴스 생성
const circle1 = new Circle(1);
const circle2 = new Circle(2);

console.log(circle1.getArea === circle2.getArea); //true

console.log(circle1.getArea()); //3.141592653589793
console.log(circle2.getArea()); //12.566370614359172
//---------------------상속 구현-----------------------------

//---------------------함수 객체의 prototype 프로퍼티-----------------------------
//생성자 함수
function Person(name) {
    this.name = name;
}

const me = new Person('Park');

console.log(Person.prototype === me.__proto__); //true
//-> 동일한 객체다.
//---------------------함수 객체의 prototype 프로퍼티-----------------------------

//---------------------프로토타입의 constructor 프로퍼티와 생성자 함수-----------------------------
console.log(me.constructor === Person); //true
//me 객체의 생성자 함수는 Person이다.
//---------------------프로토타입의 constructor 프로퍼티와 생성자 함수-----------------------------