/*
배열
1. 배열이란?
    여러 개의 값을 순차적으로 나열한 자료구조다. 배열이 가지고 있는 값을 요소(element)라고 부른다. 모든 값은 배열의 요소가될 수 있다.
    배열의 요소는 배열에서 자신의 위치를 나타내는 0이상의 정수인 인덱스를 갖는다. 인덱스는 배열의 요소에 접근할 때 사용한다.
    요소에 접근할 때는 대괄호 표기법을 사용한다.
    배열의 길이를 나타내는 length 프로퍼티를 갖는다. 그렇게 때문에 for 문을 통해 순차적으로 요소에 접근할 수 있다.
2. 자바스크립트 배열은 배열이 아니다.
    자료구조에서 말하는 배열은 동일한 크기의 메모리 공간이 빈틈없이 연속적으로 나열된 자료구조를 말한다.
    배열의 요소는 하나의 데이터 타입으로 통일되어 있으며 서로 연속적으로 인접해 있다. 이러한 배열을 밀집배열(dense array)이라 한다.
    자바스크립트의 배열은 자료구조에서 말하는 일반적인 의미의 배열과 다르다.
    배열의 요소를 위한 각각의 메모리 공간은 동일한 크기를 갖지 않아도 되고 연속적으로 이어져 있지 않을 수도 있다. 배열의 요소가 연속적으로 이어져 있지 않은 배열을 희소배열(sparse array)이라 한다.
    자바스크립트의 배열은 일반적인 배열의 동작을 흉내 낸 특수 객체다.
        - 일반적인 배열은 인덱스로 요소에 빠르게 접근할 수 있지만 특정 요소를 검색하거나 요소를 삽입 또는 삭제하는 경우에는 효율적이지 않다.
        - 자바스크립트 배열은 해시 테이블로 구현된 객체이므로 인덱스로 요소에 접근하는 경우 일반적인 배열보다 성능적인 면에서 느릴 수 밖에 없는 구조적 단점이 있다.
          하지만 특정 요소를 검색하거나 요소를 삽입 또는 삭제하는 경우에는 일반적인 배열보다 빠른 성능을 기대할 수 있다.
3. length 프로퍼티와 희소 배열
    length 프로퍼티는 요소의 개수 즉 배열의 길이를 나타내는 0 이상의 정수를 값으로 갖는다.
    length 프로퍼티의 값은 배열에 요소를 추가하거나 삭제하면 자동 갱신된다.
    length 프로퍼티 값보다 큰 숫자 값을 할당하는 경우 length 프로퍼티 값은 변경되지만 실제로 배열의 길이가 늘어나지는 않는다.
    배열의 요소가 연속적으로 위치하지 않고 일부가 비어 있는 배열을 희소 배열이라 한다.
    희소 배열의 length 프로퍼티 값은 요소의 개수와 일치하지 않는다. 희소 배열의 length는 희소 배열의 실제 요소 개수보다 언제나 크다.
4. 배열 생성
4-1. 배열 리터럴
    배열 리터럴은 0개 이상의 요소를 쉼표로 구분하여 대괄호로 묶는다. 배열 리터럴은 객체 리터럴과 달리 프로퍼티 키가 없고 값만 존재한다.
    배열 리터럴에 요소를 하나도 추가하지 않으면 length 프로퍼티 값이 0인 빈 배열이 된다.
    배열 리터럴에 요소를 생략하면 희소 배열이 생성된다.
4-2. Array 생성자 함수
    Array 생성자 함수는 전달된 인수의 개수에 따라 다르게 동작한다.
4-3. Array.of
    Array.of 메서드는 전달된 인수를 요소로 갖는 배열을 생성한다. Array.of는 Array 생성자 함수와 다르게 전달된 인수가 1개이고 숫자이더라도 인수를 요소로 갖는 배열을 생성한다.
4-4. Array.from
    유사배열객체 또는 이터러블 객체를 인수로 전달받아 배열로 변환하여 반환한다.
    Array.from을 사용하면 두번째 인수로 전달한 콜백 함수를 통해 값을 만들면서 요소를 채울 수 있다. 
    Array.from 메서드는 두번쨰 인수로 전달한 콜백 함수에 첫 번쨰 인수에 의해 생성된 배열의 요소 값과 인덱스를 순차적으로 전달하면서 호출하고 콜백 함수의 반환 값으로 구성된 배열을 반환한다.
5. 배열 요소의 참조
    배열의 요소를 참조할 때에는 대괄효 표기법을 사용한다. 대괄호 안에는 인덱스가 와야 한다.
    정수로 평가되는 표현식이라면 인덱스 대신 사용할 수 있다. 인덱스 값은 참조할 수 있다는 의미에서 객체의 프로퍼티 키와 같은 역할을 한다.
    존재하지 않는 요소에 접근하면 undefined가 반환된다.
6. 배열 요소의 추가와 갱신
    배열에도 요소를 동적으로 추가할 수 있다. 존재하지 않는 인덱스를 사용해 값을 할당하면 새로운 요소가 추가된다. 이때 length 프로퍼티 값은 자동으로 갱신된다.
    인덱스로 요소에 접근하여 명시적으로 값을 할당하지 않은 요소는 생성되지 않는다.
    이미 요소가 존재하는 요소에 값을 재할당하면 요소 값이 갱신된다.
    인덱스는 요소의 위치를 나타내므로 반드시 0이상의 정수를 사용해야 한다. 정수 이외의 값을 인덱스처럼 사용하면 요소가 생성되는 것이 아니라 프로퍼티가 생성된다.
    프로퍼티는 length 프로퍼티 값에 영향을 주지 않는다.
7. 배열 요소의 삭제
    배열은 객체이기 때문에 배열의 특정 요소를 삭제하기 위해 delete 연산자를 사용할 수 있다.
    희소 배열을 만들지 않으면서 배열의 특정 요소를 완전히 삭제하려면 Array.prototype.splice 메서드를 사용한다.
8. 배열 메서드
    배열에는 원본 배열을 직접 변경하는 메서드와 원본 배열을 직접 변경하지 않고 새로운 배열을 생성하여 반환하는 메서드가 있다.
8-1. Array.isArray
    Array.isArray는 Array 생성자 함수의 정적 메서드다.
    Array.isArray는 전달된 인수가 배열이면 true, 배열이 아니면 false를 반환한다.
8-2. Array.prototype.indexOf
    indexOf 메서드는 원본 배열에서 인수로 전달된 요소를 검색하여 인덱스를 반환한다.
    원본 배열에 인수로 전달한 요소와 중복되는 요소가 여러 개 있다면 첫 번쨰로 검색된 요소의 인덱스를 반환한다.
    원본 배열에 인수로 전달한 요소가 존재하지 않으면 -1을 반환한다.
    indexOf 메서드는 배열에 특정 요소가 존재하는지 확인할 때 유용하다.
    ES7에서 도입된 Arrays.prototype.include 메서드를 사용하면 가독성이 더 좋다.
8-3. Array.prototype.push
    push 메서드는 인수로 전달받은 모든 값을 원본 배열의 마지막 요소로 추가하고 변경된 length 프로퍼티 값을 반환한다. push 메서드는 원본 배열을 직접 변경한다.
    마지막 요소로 추가할 요소가 하나뿐이라면 push 메서드를 사용하지 않고 length 프로퍼티를 사용하여 배열의 마지막에 요소를 직접 추가할 수 있다.
    스프레드 문법을 사용하면 함수 호출 없이 표현식으로 마지막 요소를 추가할 수 있으며 부수효과도 없다.
8-4. Array.prototype.pop
    pop 메서드는 원본 배열에서 마지막 요소를 제거하고 제거한 요소를 반환한다.
    원본 배열이 빈 배열이면 undefined를 반환한다. pop 메서드는 원본 배열을 직접 변경한다.
    pop 메서드와 push 메서드를 사용하면 스택을 구현할 수 있다.
    스택은 데이터를 마지막에 밀어넣고 마지막에 밀어 넣은 데이터를 먼저 꺼내는 후입선출(LIFO) 방식의 자료구조다.
8-5. Array.prototype.unshift
    unshift 메서드는 인수로 전달받은 모든 값을 원본 배열의 선두에 요소로 추가하고 변경된 length 프로퍼티 값을 반환한다. unshift 메서드는 원본 배열을 직접 변경한다.
8-6. Array.prototype.shift
    shift 메서드는 원본 배열에서 첫번쨰 요소를 제거하고 제거한 요소를 반환한다. 원본 배열이 빈 배열이면 undefined를 반환한다.
    shift 메서드는 원본 배열을 직접 변경한다.
    shift 메서드와 push 메서드를 사용하면 큐를 구현할 수 있다.
    큐는 데이터를 마지막에 밀어 넣고, 가장 먼저 밀어 넣은 데이터를 먼저 꺼내는 선입 선출(FIFO) 방식의 자료구조다.
8-7. Array.prototype.concat
    concat 메서드는 인수로 전달된 값들을 원본 배열의 마지막 요소로 추가한 새로운 배열을 반환한다. 
    인수로 전달한 값이 배열인 경우 배열을 해체하여 새로운 배열의 요소로 추가한다.
    원본 배열은 변경되지 않는다.
    push와 unshift 메서드는 concat 메서드로 대체할 수 있다. push와 unshift 메서드는 concat 메서드와 유사하게 동작하지만 차이가 있다.
    push와 unshift 메서드는 원본 배열을 직접 변경하지만 concat 메서드는 원본 배열을 변경하지 않고 새로운 배열을 반환한다. 
    따라서 push와 unshift 메서드를 사용할 경우 원본 배열을 반드시 변수에 저장해 두어야 하며 concat 메서드를 사용할 경우 반환값을 반드시 변수에 할당 받아야 한다.
    인수로 전달 받은 값이 배열인 경우 push와 unshift 메서드는 배열을 그대로 원본 배열의 마지막/첫 번쨰 요소로 추가하지만 concat 메서드는 인수로 전달 받은 배열을 해체하여 새로운 배열의 마지막 요소로 추가한다.
8-8. Array.prototype.splice
    원본 배열의 중간에 요소를 추가하거나 중간에 있는 요소를 제거하는 경우 splice 메서드를 사용한다. 
    splice 메서드는 3개의 매개변수가 있으며 원본 배열을 직접 변경한다.
    배열.splice(start, deleteCount, items)
    start : 원본 배열의 요소를 제거하기 시작할 인덱스, start만 지정하면 원본 배열의 start부터 모든 요소를 제거한다. 음수일 경우 배열의 끝에서의 인덱스를 나타낸다.
    deleteCount : 원본 배열의 요소를 제거하기 시작할 인덱스인 start부터 제거할 요소의 개수다. deleteCount가 0인 경우 아무런 요소도 제거되지 않는다.
    item : 제거한 위치에 삽입할 요소들의 목록이다. 생략할 경우 요소들이 제거하기만 한다.
8-9. Array.prototype.slice
    splice 메서드는 인수로 전달된 범위의 요소들을 복사하여 배열로 반환한다. 원본 배열은 변경되지 않는다.
    배열.slice(start, end)
    start : 복사를 시작할 인덱스다. 음수인 경우 배열의 끝에서의 인덱스를 나타낸다.
    end : 복사를 종료할 인덱스다. 이 인덱스에 해당하는 요소는 복사되지 않는다. end는 생략 가능하며 생략시 기본 값은 length 프로퍼티의 값이다.
8-10. Array.prototype.join
    join 메서드는 원본 배열의 모든 요소를 문자열로 변환한 후, 인수로 전달 받은 문자열, 즉 구분자로 연결한 문자열을 반환한다. 구분자는 생략 가능하며 기본 구분자는 콤마다.
8-11. Array.prototype.reverse
    reverse 메서드는 원본 배열의 순서를 반대로 뒤집는다. 이때 원본 배열이 변경된다. 반환 값은 변경된 배열이다.
8-12. Array.prototype.fill
    fill 메서드는 인수로 전달 받은 값을 배열의 처음부터 끝까지 요소로 채운다. 원본 배열이 변경된다.
8-13. Array.prototype.include
    include 메서드는 배열 내에 특정 요소가 포함되어 있는지 확인하여 true 또는 false를 반환한다. 첫번쨰 인수로 검색할 대상을 지정한다.
    두번째 인수로 검색을 시작할 인덱스를 전달 할 수 있고 생략할 경우 기본 값은 0이 설정된다. 음수를 전달하면 length 프로퍼티 값과 음수 인덱스를 합산하여 검색 시작 인덱스를 설정한다.
8-14. Array.prototype.flat
    인수로 전달한 깊이만큼 재귀적으로 배열을 평탄화한다.
    중첩 배열을 평탄화할 깊이를 인수로 전달할 수 있다. 인수를 생략할 경우 기본값은 1이다. 인수로 Infinity를 전달하면 중첩 배열 모두를 평탄화한다.
9. 배열 고차 함수
    고차 함수는 함수를 인수로 전달받거나 함수를 반환하는 함수를 말한다.
    고차 함수는 외부 상태의 변경이나 가변 데이터를 피하고 불변성을 지향하는 함수형 프로그래밍에 기반을 두고 있다.
    함수형 프로그래밍은 순수함수와 보조 함수의 조합을 통해 로직 내에 존재하는 조건문과 반복문을 제거하여 복잡성을 해결하고 변수의 사용을 억제하여 상태 변경을 피하려는 프로그래밍 패러다임이다.
9-1. Array.prototype.sort
    sort 메서드는 배열의 요소를 정렬한다. 원본 배열을 직접 변경하며 정렬된 배열을 반환한다. 기본적으로 오름차순으로 요소를 정렬한다.
    sort 메서드의 기본 정렬 순서는 유니코드 코드 포인트의 순서를 따른다.
    따라서 숫자 요소를 정렬할 때는 sort 메서드에 정렬 순서를 정의하는 비교함수를 인수로 전달해야 한다.
9-2. Array.prototype.forEach
    for문을 대체할 수 있는 고차 함수다. forEach 메서드는 자신의 내부에서 반복문을 실행한다.
    forEach 메서드는 반복문을 추상화한 고차 함수로서 내부에서 반복문을 통해 자신을 호출한 배열을 순회하면서 수행해야 할 처리를 콜백 함수로 전달받아 반복 호출한다.
    희소 배열의 경우 존재하지 않는 요소는 순회 대상에서 제외된다.
9-3. Array.prototype.map
    map 메서드는 자신을 호출한 배열의 모든 요소를 순회하면서 인수로 전달받은 콜백 함수를 반복 호출한다. 그리고 콜백 함수의 반환값들로 구성된 새로운 배열을 반환한다. 원본 배열은 변경되지 않는다.
    map 메서드가 생성하여 반환하는 새로운 배열의 length 프로퍼티 값은 map 메서드를 호출한 배열의 length 프로퍼티 값과 반드시 일치한다. 즉 map 메서드를 호출한 배열과 map 메서드가 생성하여 반환한 배열은 1:1 매핑한다.
9-4. Array.prototype.filter
    filter 메서드는 자신을 호출한 배열의 모든 요소를 순회하면서 인수로 전달받은 콜백함수를 반복 호출한다.  원본 배열은 변경되지 않는다.
9-5. Array.prototype.reduce
    reduce 메서드는 자신을 호출한 배열의 모든 요소를 순회하며 인수로 전달받은 콜백 함수를 반복 호출한다. 
    그리고 콜백 함수의 반환값을 다음 순회 시에 콜백 함수의 첫 번쨰 인수로 전달하면서 콜백 함수를 호출하여 하나의 결과값을 만들어 반환한다.
    원본 배열은 변경되지 않는다.
9-6. Array.prototype.some
    some 메서드는 자신을 호출한 배열의 요소를 순회하면서 인수로 전달된 콜백 함수를 호출한다. 이때 some 메서드는 콜백 함수의 반환값이 단 한 번이라도 참이면 true, 모두 거짓이면 false를 반환한다.
    호출한 배열이 빈 배열인 경우 언제나 false를 반환한다.
9-7. Array.prototype.every
    every 메서드는 콜백 함수의 반환 값이 모두 참이면 true 단 한번이라도 거짓이면 false를 반환한다.
9-8. Array.prototype.find
    자신을 호출한 배열의 요소를 순회하면서 인수로 전달된 콜백 함수를 호출하여 반환값이 true인 첫 번쨰 요소를 반환한다.
    콜백 함수의 반환값이 true인 요소가 존재하지 않는다면 undefined를 반환한다.
9-9. Array.prototype.findIndex
    자신을 호출한 배열의 요소를 순회하면서 인수로 전달된 콜백 함수를 호출하여 반환값이 true인 첫 번쨰 요소의 인덱스를 반환한다. 콜백 함수의 반환값이 true인 요소가 존재하지 않는다면 -1을 반환한다.
9-10. Array.prototype.flatMap
    map 메서드를 통해 생성된 새로운 배열을 평탄화한다.
    map 메서드와 flat 메서드를 순차적으로 실행하는 효과가 있다. 
*/

const arr = [1,2,3,4,5];
arr.length = 3;
//배열의 길이가 줄어든다.
console.log(arr); //[1, 2, 3]

const arr2 = [1];
arr2.length = 3;
console.log(arr2); //[ 1, <2 empty items> ]

const sparse = [,2, ,4];
console.log(sparse.length); //4
console.log(sparse); //[ <1 empty item>, 2, <1 empty item>, 4 ]

console.log(Array.of(1)); //[ 1 ]
console.log(Array.of(1,2,3)); //[ 1, 2, 3 ]
console.log(Array.of('string')); //[ 'string' ]

//유사 배열 객체를 변환하여 배열을 생성한다.
console.log(Array.from({length:2, 0: 'a', 1: 'b'})); //[ 'a', 'b' ]
//이터러블을 변환하여 배열을 생성한다.
console.log(Array.from('hello')); //[ 'h', 'e', 'l', 'l', 'o' ]
//Array.from에 length만 존재하는 유사 배열 객체를 전달하면 undefined를 요소로 채운다.
console.log(Array.from({length : 3})); //[ undefined, undefined, undefined ]
console.log(Array.from({length: 3}, (_, i) => i)); //[ 0, 1, 2 ]

const arr3 = [1,2,3];
delete arr3[1];
console.log(arr3); //[ 1, <1 empty item>, 3 ]
console.log(arr3.length) //3
//length프로퍼티에 영향을 주지 않는다 -> 희소배열이 된다.

const arr4 = [1,2,3];
arr4.splice(1,1); //Array.prototype.splice(삭제를 시작할 인덱스, 삭제할 요소 수)
console.log(arr4); //[ 1, 3 ]
console.log(arr4.length); //2

const arr5 = [1];
arr5.push(2); //[ 1, 2 ]
console.log(arr5); //원본 배열 직접 변경
const result = arr5.concat(3); //concat 메서드는 원본 배열을 직접 변경하지 않고 새로운 배열을 생성하여 반환한다.
console.log(arr5); //[ 1, 2 ]
console.log(result); //[ 1, 2, 3 ]

const arr6 = [1,2];
let result2 = arr6.push(3, 4);
console.log(result2);//4 //인수로 전달받은 모든 값을 원본 배열 마지막 요소로 추가하고 변경된 length 값을 반환한다. 
console.log(arr6); //[ 1, 2, 3, 4 ]

const arr7 = [1,2];
arr7[arr7.length] = 3; //push와 동일한 처리를 하지만 push 메서드보다 빠르다.
console.log(arr7); //[ 1, 2, 3 ]


const arr8 = [1,2];
const newArr = [...arr8, 3]; //스프레드 문법
console.log(newArr);  //[ 1, 2, 3 ]

//스택 구현
const Stack = (function () {
    function Stack(array = []) {
      if (!Array.isArray(array)) {
        throw new TypeError(`${array} is not an array.`);
      }
      this.array = array;
    }
  
    Stack.prototype = {
      constructor: Stack,
      push(value) {
        return this.array.push(value);
      },
      pop() {
        return this.array.pop();
      },
      entries() {
        return [...this.array];
      }
    };
    return Stack;
}());
  
const stack = new Stack([1, 2]);
console.log(stack.entries()); //[1, 2]

stack.push(3);
console.log(stack.entries()); //[1, 2, 3]

stack.pop();
console.log(stack.entries()); //[1, 2]

const arr9 = [1, 2];
let result3 = arr9.unshift(3, 4);
console.log(result3) //4
console.log(arr9) //[ 3, 4, 1, 2 ]
//스프레드 문법
const newArr2 = [5, ...arr9];
console.log(newArr2); //[ 5, 3, 4, 1, 2 ]

//큐 구현
const Queue = (function () {
    function Queue(array = []) {
      if (!Array.isArray(array)) {
        throw new TypeError(`${array} is not an array.`);
      }
      this.array = array;
    }
  
    Queue.prototype = {
      constructor: Queue,
      enqueue(value) {
        return this.array.push(value);
      },
      dequeue() {
        return this.array.shift();
      },
      entries() {
        return [...this.array];
      }
    };
  
    return Queue;
}());
  
const queue = new Queue([1, 2]);
console.log(queue.entries()); // [1, 2]

queue.enqueue(3);
console.log(queue.entries()); // [1, 2, 3]

queue.dequeue();
console.log(queue.entries()); // [2, 3]

const points = [40, 100, 1, 5, 2, 25, 10];
// 숫자 배열의 오름차순 정렬. 비교 함수의 반환값이 0보다 작으면 a를 우선하여 정렬한다.
points.sort((a, b) => a - b);
console.log(points); // [1, 2, 5, 10, 25, 40, 100]

// 숫자 배열에서 최소/최대값 취득
console.log(points[0], points[points.length]); // 1

// 숫자 배열의 내림차순 정렬. 비교 함수의 반환값이 0보다 작으면 b를 우선하여 정렬한다.
points.sort((a, b) => b - a);
console.log(points); // [100, 40, 25, 10, 5, 2, 1]

// 숫자 배열에서 최대값 취득
console.log(points[0]); // 100

// forEach 메서드는 콜백 함수를 호출하면서 3개(요소값, 인덱스, this)의 인수를 전달한다.
[1, 2, 3].forEach((item, index, arr) => {
    console.log(`요소값: ${item}, 인덱스: ${index}, this: ${JSON.stringify(arr)}`);
  });
//요소값: 1, 인덱스: 0, this: [1,2,3]
//요소값: 2, 인덱스: 1, this: [1,2,3]
//요소값: 3, 인덱스: 2, this: [1,2,3]

// map 메서드는 콜백 함수를 호출하면서 3개(요소값, 인덱스, this)의 인수를 전달한다.
[1, 2, 3].map((item, index, arr) => {
    console.log(`요소값: ${item}, 인덱스: ${index}, this: ${JSON.stringify(arr)}`); 
    return item;
});
//요소값: 1, 인덱스: 0, this: [1,2,3]
//요소값: 2, 인덱스: 1, this: [1,2,3]
//요소값: 3, 인덱스: 2, this: [1,2,3]

class Prefixer {
    constructor(prefix) {
      this.prefix = prefix;
    }
  
    add(arr) {
      return arr.map(function (item) {
        // 외부에서 this를 전달하지 않으면 this는 undefined를 가리킨다.
        return this.prefix + item;
      }, this); // map 메서드의 콜백 함수 내부에서 this로 사용할 객체를 전달
    }
  }
  
  const prefixer = new Prefixer('-webkit-');
  console.log(prefixer.add(['transition', 'user-select']));
console.log()
console.log()
console.log()
console.log()
console.log()
console.log()
