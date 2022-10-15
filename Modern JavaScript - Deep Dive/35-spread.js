/*
1. 스프레드 문법
    스프레드문법(전개문법) ...은 하나로 뭉쳐 있는 여러 값들의 집합을 펼쳐서 개별적인 값들의 목록으로 만든다.
    스프레드 문법을 사용할 수 있는 대상은 Array, String, Map, Set, DOM 컬렉션, arguments와 같이 for... of 문으로 순회할 수 있는 이터러블에 한정된다.
    스프레드 문법의 결과는 값이 아니다. 
    ...이 피연산자를 연산하여 값을 생성하는 연산자가 아니기 때문에 변수에 할당할 수 없다.
    쉼표로 구분한 값의 목록을 사용하는 문맥에서만 사용할 수 있다.
        - 함수 호출문의 인수 목록
        - 배열 리터럴의 요소 목록
        - 객체 리터럴의 프로퍼티 목록
1-1. 함수 호출문의 인수 목록에서 사용하는 경우
    요소들의 집합인 배열을 펼쳐서 개별적인 값들의 목록으로 만든 후 이를 함수의 인수 목록으로 전달해야 하는 경우가 있다.
    Math.max 메서드에 숫자가 아닌 배열을 인수로 전달하면 최댓값을 구할 수 없으므로 NaN을 반환한다.
    이 문제를 해결하기 위해 배열을 펼쳐서 요소들을 개별적인 값들의 목록으로 만든 후, Math.max 메서드의 인수로 전달해야 한다.
    스프레드 문법이 제공되기 이전에는 배열을 펼쳐서 요소들의 목록을 함수의 인수로 전달하고 싶은 경우 Function.prototype.apply 를 사용했다.
    스프레드 문법을 사용하면 더 간결하고 가독성이 좋다.
2. 배열 리터럴 내부에서 사용하는 경우
2-1. concat
    ES5에서 2개의 배열을 1개의 배열로 결합하고 싶은 경우 사용
    스프레드 문법을 사용하면 별도의 메서드를 사용하지 않고 배열 리터럴만으로 2개의 배열을 1개의 배열로 결합할 수 있다.
2-2. splice
    어떤 배열의 중간에 다른 배열의 요소들을 추가하거나 제거하려면 splice 메서드를 사용한다. splice 메서드의 세번째 인수로 배열을 전달하면 배열 자체가 추가된다.
    세번 째 인수를 배열을 해체하여 전달해야 한다. 그렇지 않으면 배열 자체가 추가된다.
2-3. 배열 복사
    배열을 복사하려면 slice 메서드를 사용한다.
2-4. 이터러블을 배열로 변환
    ES5에서 이터러블을 배열로 변환하려면 Function.prototype.apply 또는 Function.prototype.call 메서드를 사용하여 splice 메서드를 호출해야 한다.
    이터러블이 아닌 유사 배열 객체는 스프레드 문법의 대상이 될 수 없다.
    이터러블이 아닌 유사 배열 객체를 배열로 변경하려면 Array.from 메서드를 사용한다.
2-5. 객체 리터럴 내부에서 사용하는 경우
    Rest 프로퍼티와 함께 스프레드 프로퍼티를 사용하면 객체 리터럴의 프로퍼티 목록에서도 스프레드 문법을 사용할 수 있다. 
    스프레드 문법의 대상은 이터러블이어야 하지만 스프레드 프로퍼티 제안은 일반 객체를 대상으로 스프레드 문법의 사용을 허용한다.
    스프레드 프로퍼티가 제안되기 이전에는 Object.assign 메서드를 사용하여 여러 개의 객체를 병합하거나 특정 프로퍼티를 변경 또는 추가 했다.
*/

console.log(...[1,2,3]); //1 2 3
console.log(... 'Hello'); //H e l l o
console.log(... new Map([['a','1'],['b','2'],['c','3']])); //[ 'a', '1' ] [ 'b', '2' ] [ 'c', '3' ]
console.log(... new Set([1,2,3]));//1 2 3

//이터러블이 아닌 일반 객체는 스프레드 문법의 대상이 될 수 없다.
//console.log(... {a:1, b:2}); //TypeError: Found non-callable @@iterator

let arr = [1,2,3];
console.log(Math.max.apply(null, arr));
console.log(Math.max(...arr));

//Rest 파라미터는 인수들의 목록을 배열로 받는다.
function rest(... rest) {
    console.log(rest);
};
rest(... [1,2,3]); //[ 1, 2, 3 ]

console.log([1,2].concat([3,4])); //[ 1, 2, 3, 4 ]
let arr2 = [...[1,2], ...[3,4]]; //[ 1, 2, 3, 4 ]
console.log(arr2);

let arr3 = [1,4];
let arr4 = [2,3];
//arr3.splice(1,0,arr4);
//console.log(arr3); //[ 1, [ 2, 3 ], 4 ]

//Array.prototype.splice.apply(arr3, [1,0].concat(arr4));
//console.log(arr3); //[ 1, 2, 3, 4 ]
arr3.splice(1, 0, ...arr4)
console.log(arr3); //[ 1, 2, 3, 4 ]

let origin = [1,2];
let copy = origin.slice();
console.log(copy); //[ 1, 2 ]
console.log(copy === origin); //false

let copy2 = [... origin];
console.log(copy2); //[ 1, 2 ]
console.log(copy2 === origin); //false

function sum() {
    //이터러블이면서 유사 배열 객체인 arguments를 배열로 변환
    let args = Array.prototype.slice.call(arguments);

    return args.reduce(function (pre, cur) {
        return pre+cur;
    }, 0);
}
console.log(sum(1,2,3)); //6

//이터러블이 아닌 유사 배열 객체
const arrLike = {
    0: 1,
    1: 2,
    2: 3,
    length: 3
};

let arr5 = Array.prototype.slice.call(arrLike);
console.log(Array.isArray(arr5)); //true

//스프레드 문법 사용
function sum2() {
    //이터러블이면서 유사 배열 객체인 arguments를 배열로 변환
    return [...arguments].reduce((pre, cur) => pre + cur, 0);
}
console.log(sum2(1,2,3)); //6

//Rest 파라미터 사용
let sum3 = (...args) => args.reduce((pre, cur) => pre + cur, 0);
console.log(sum3(1,2,3)); //6

console.log(Array.from(arrLike)); //[ 1, 2, 3 ]

//스프레드 프로퍼티
//객체 복사
let obj = {x:1, y:2};
let copy3 = {... obj};
console.log(copy3); //{ x: 1, y: 2 }
console.log(obj === copy3); //false
//객체 병합
let merged = {x:1, y:2, ...{a:3, b:4}};
console.log(merged); //{ x: 1, y: 2, a: 3, b: 4 }

//객체 병합. 프로퍼티가 중복되는 경우 뒤에 위치한 프로퍼티가 우선권을 갖는다.
let merged2 = Object.assign({}, {x:1, y:2}, {y:10, z:3});
console.log(merged2); //{ x: 1, y: 10, z: 3 }
//특정 프로퍼티 변경
let changed = Object.assign({}, {x:1, y:2}, {y:100});
console.log(changed); //{ x: 1, y: 100 }
//프로퍼티 추가
let added = Object.assign({}, {x:1, y:2}, {z:0});
console.log(added); //{ x: 1, y: 2, z: 0 }

//스프레드 프로퍼티 사용
//객체 병합
let merged3 = {...{x:1, y:2}, ...{y:10, z:3}};
console.log(merged3); //{ x: 1, y: 10, z: 3 }
//특정 프로퍼티 변경
let changed2 = {...{x:1, y:2}, y:100}; //{ x: 1, y: 100 }
console.log(changed2);
//프로퍼티 추가
const added2 = {...{x:1, y:2}, z:0};
console.log(added2); //{ x: 1, y: 2, z: 0 }