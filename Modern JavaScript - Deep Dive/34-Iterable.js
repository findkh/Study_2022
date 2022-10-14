/*
1. 이터레이션 프로토콜
    ES6에서 도입된 이터레이션 프로토콜은 순회 가능한 데이터 컬렉션을 만들기 위해 ECMAScript 사양에 정의하여 미리 약속한 규칙이다.
    이터레이션 프로토콜에는 이터러블 프로토콜과 이터레이터 프로토콜이 있다.
1-1. 이터러블
    이터러블은 Symbol.iterator를 프로퍼티 키로 사용한 메서드를 직접 구현하거나 프로토타입 체인을 통해 상속받은 객체를 말한다.
    이터러블은 for...of문으로 순회할 수 있으며, 스프레드 문법과 배열 디스트럭처링 할당의 대상으로 사용할 수 있다.
1-2. 이터레이터
    이터러블의 Symbol.iterator 메서드를 호출하면 이터레이터 프로토콜을 준수한 이터레이터를 반환한다. 이터러블의 Symbol.iterator 메서드가 반환한 이터레이터는 next 메서드를 갖는다.
    next 메서드는 이터러블의 각 요소를 순회하기 위한 포인터 역할을 한다.
    next 메서드를 호출하면 이터러블을 순차적으로 한 단계씩 순회하며 순회 결과를 나타내는 이터레이터 리절트 객체를 반환한다.
    이터레이터의 next 메서드가 반환하는 이터레이터 리절트 객체의 value 프로퍼티는 현재 순회중인 이터러블의 값을 나타내며 done 프로퍼티는 이터러블의 순회 완료 여부를 나타낸다.
2. 빌트인 이터러블
    자바스크립트는 이터레이션 프로토콜을 준수한 객체인 빌트인 이터러블을 제공한다.
    Array, String, Map, Set, TypedArray, arguments, Dom컬렉션
3. for...of문
    for...of문은 이터러블을 순회하면서 이터러블의 요소를 변수에 할당한다.
    for(변수선언문 of 이터러블) { ... }
    for...in문과 유사하다.
    for...in문은 객체의 프로토타입 체인 상에 존재하는 모든 프로토타입의 프로퍼티 중에서 프로퍼티 어트리뷰트 [[Enumberable]]의 값이 true인 프로퍼티를 순회하며 열거한다. 이 때 프로퍼티 키가 심벌인 프로퍼티는 열거하지 않는다.
    for...of문은 내부적으로 이터레이터의 next 메서드를 호출하여 이터러블을 순회하며 next 메서드가 반환한 이터레이터 리절트 객체의 value 프로퍼티 값을 for...of 문의 변수에 할당한다.
    이터레이터 리절트 객체의 done 프로퍼티 값이 false이며 이터러블의 순회를 계속하고 true이면 이터러블의 순회를 중단한다.
4. 이터러블과 유사배열 객체
    유사 배열 객체는 배열처럼 인덱스로 프로퍼티 값에 접근할 수 있고 length 프로퍼티를 갖는 객체를 말한다.
    length 프로퍼티를 갖기 때문에 for 문으로 순회할 수 있고, 인덱스를 나타내는 숫자형식의 문자열을 프로퍼티키로 가지므로 배열처럼 인덱스로 프로퍼티 값에 접근할 수 있다.
    유사 배열 객체에는 Symbol.iterator 메서드가 없기 때문에 for...of 문으로 순회할 수 없다.
    단, arguments, NodeList, HTMLCollection은 유사 배열 객체이면서 이터러블이다.
    Array.from을 통하여 유사 배열 객체 또는 이터러블의 인수를 전달 받아 배열로 전환 할 수 있다.
5. 이터레이션 프로토콜의 필요성
    이터러블은 for...of문, 스프레드 문법, 배열 디스트럭처링 할당과 같은 데이터 소비자에 의해 사용되므로 데이터 공급자의 역할을 한다고 할 수 있다.
    만약 다양한 데이ㅣ터 공급자가 각자의 순회 방식을 갖는다면 데이터 소비자는 다양한 데이터 공급자의 순회방식을 모두 지원해야 한다. 이는 효율적이지 않다.
    하지만 다양한 데이터 공급자가 이터레이션 프로토콜을 준수하도록 규정하면 데이터 소비자는 이터레이션 프로토콜만 지원하도록 구현하면 된다.
    이터레이션 프로토콜은 다양한 데이터 공급자가 하나의 순회 방식을 갖도록 규정하여 데이터 소비자가 효율적으로 다양한 데이터 공급자를 사용할 수 있도록 데이터 소비자와 데이터 공급자를 연결하는 인터페이스의 역할을 한다.
6. 사용자 정의 이터러블
6-1. 사용자 정의 이터러블 구현
    이터레이션 프로토콜을 준수하지 않은 일반 객체도 이터레이션 프로토콜을 준수하도록 구현하면 사용자 정의 이터러블이된다.
6-2. 이터러블을 생성하는 함수
6-3. 이터러블이면서 이터레이터인 객체를 생성하는 함수
6-4. 무한 이터러블과 지연 평가

*/

const array = [1,2,3];
// 배열은 Array.prototype의 Symbol.iterator 메서드를 상속받은 이터러블이다.
console.log(Symbol.iterator in array); //true

//이터러블 배열은 for of 사용 가능
for(const item of array) {
    console.log(item);
}

//이터러블인 배열은 스프레드 문법의 대상으로 사용할 수 있다.
console.log([... array]); //[ 1, 2, 3 ]

//이터러블인 배열은 배열 디스트럭처링 할당의 대상으로 사용할 수 있다.
const [a, ...rest] = array;
console.log(a, rest); //1 [ 2, 3 ]

//Symbol.iterator 메서드는 이터레이터를 반환한다.
const iterator = array[Symbol.iterator]();
//Symbol.iterator 메서드가 반환한 이터레이터는 next 메서드를 갖는다.
console.log('next' in iterator); //true

console.log(iterator.next()); //{ value: 1, done: false }
console.log(iterator.next()); //{ value: 2, done: false }
console.log(iterator.next()); //{ value: 3, done: false }
console.log(iterator.next()); //{ value: undefined, done: true }

const arrayLike = {
    0: 1,
    1: 2,
    2: 3,
    length: 3
};

for(let i = 0; i < arrayLike.length; i++) {
    console.log(arrayLike[i]) //1,2,3
}

// for(let item of arrayLike) {
//     console.log(item); //TypeError: arrayLike is not iterable
// }

const arr = Array.from(arrayLike);
for(let item of arr) {
    console.log(item); //1,2,3
}

//사용자 정의 이터러블 - 피보나치 수열
const fibonacci = {
    [Symbol.iterator]() {
        let [pre, cur] = [0, 1];
        const max = 10; //수열의 최댓값
    
        return {
            next() {
                [pre, cur] = [cur, pre+cur];
                return { value : cur, done: cur >= max};
            }
        };
    }
}

for(let num of fibonacci) {
    console.log(num); //1,2,3,5,8
}

//피보나치 수열을 구현한 사용자 정의 이터러블을 반환하는 함수
const fibonacciFunc = function(max) {
    let [pre, cur] = [0,1];

    return {
        [Symbol.iterator]() {
            return {
                next() {
                    [pre, cur] = [cur, pre + cur];
                    return { value : cur, done: cur >= max};
                }
            }
        }
    }
}
//이터러블을 반환하는 함수에 수열의 최대값을 인수로 전달하면서 호출한다.
for(let num of fibonacciFunc(10)) {
    console.log(num); //1,2,3,5,8
}