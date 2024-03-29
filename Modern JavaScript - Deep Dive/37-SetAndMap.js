/*
1. Set
    Set 객체는 중복되지 않는 유일한 값들의 집합이다.
    배열은 동일한 값을 중복하여 포함할 수 있고, 요소 순서에 의미가 있으며, 인덱스로 요소에 접근할 수 있지만, Set은 그렇지 않다.
    Set은 수학적 집합을 구현하기 우히나 자료구조로, 교집합, 합집합, 차집합, 여집합 등을 구현할 수 있다.
1-1. Set 객체의 생성
    Set 객체는 Set 생성자 함수로 생성한다. Set 생성자 함수에 인수를 전달하지 않으면 빈 Set 객체가 생성된다.
    Set 생성자 함수는 이터러블을 인수로 전달받아 Set 객체를 생성한다. 이때 이터러블의 중복된 값은 Set 객체에 요소로 저장되지 않는다.
1-2. 요소 개수 확인
    Set.prototype.size 프로퍼티를 사용한다.
    size 프로퍼티는 getter 함수만 존재하는 접근자 프로퍼티로 숫자를 할당하여 요소 개수를 변경할 수 없다.
1-3. 요소 추가
    Set 객체에 요소를 추가할 때는 add 메서드를 사용한다.
    add 메서드는 새로운 요소가 추가된 Set 객체를 반환한다. add 메서드를 호출한 후에 add 메서드를 연속적으로 호출할 수 있다.
    중복된 요소는 무시된다.
    NaN은 다르다고 평가하지만, +0, -0은 같다고 평가하여 중복 추가를 허용하지 않는다.
    객체나 배열과 같이 자바스크립트의 모든 값을 요소로 저장할 수 있다.
1-4. 요소 존재 여부 확인
    Set 객체에 특정 요소가 존재하는지 확인하려면 Set.prototype.has 메서드를 사용한다.
    has 메서드는 특정 요소의 존재 여보를 나타내는 불리언 값을 반환한다.
1-5. 요소 삭제
    특정 요소를 삭제하려면 Set.prototype.delete 메서드를 사용한다. delete 메서드는 삭제 성공 여부를 나타내는 불리언값을 반환한다.
    Set 객체는 순서에 의미가 없고, 인덱스도 없으므로 삭제하려는 요소값을 인수로 전달해야한다.
    존재하지 않는 요소를 삭제하려면 에러 없이 무시된다.
    add 메서드와 달리 연속적으로 호출할 수 없다.
1-6. 요소 일괄 삭제
    Set 객체의 모든 요소를 일괄 삭제하려면 Set.prototype.clear 메서드를 사용한다.
    clear 메서드는 언제나 undefined를 반환한다.
1-7. 요소 순회
    Set 객체의 요소를 순회하려면 Set.prototype.forEach 메서드를 사용한다. forEach 메서드의 콜백 함수 내부에서 this로 사용될 객체를 인수로 전달한다.
        첫번째 인수 : 현재 순회 중인 요소 값
        두번째 인수 : 현재 순회 중인 요소 값
        세번째 인수 : 현재 순회 중인 Set 객체 자체
    첫번째, 두번째 인수 값이 같은 이유는 Array.prototype.forEach 인터페이스와 통일하기 위함이며 다른 의미는 없다.
    Set 객체는 이터러블이다. for...of 문으로 순회할 수 있으며 스프레드 문법과 배열 디스트럭처링의 대상이 될 수도 있다.
    Set 객체는 요소의 순서에 의미를 갖지 않지만 Set 객체를 순회하는 순서는 요소가 추가된 순서를 따른다.
1-8. 집합 연산
    - 교집합
        집합 A와 집합 B의 공통 요소를 구성된다.
    - 합집합
        집합 A와 집합 B의 중복 없는 모든 요소로 구성된다.
    - 차집합
        집합 A에는 존재하지만 집합 B에는 존재하지 않는 요소로 구성된다.
    - 부분집합과 상위집합
        집합 A가 집합 B에 포함되는 경우 집합 A는 집합 B의 부분집합이며 집합 B는 집합 A의 상위집합이다.
2. Map
    Map 객체는 키와 값의 쌍으로 이루어진 컬렉션이다. Map 객체는 객체와 유사하지만,
    객체는 키로 문자열 또는 심벌 값을 사용할 수 있지만 Map 객체는 객체를 포함한 모든 값을 키로 사용할 수 있다.
    객체는 이터러블이 아니지만 Map 객체는 이터러블이다.
    요소의 개수를 확인할 때도 객체는 length 메서드를 사용하지만 Map 객체는 size를 사용한다.
2-1. Map 객체의 생성
    Map 객체는 Map 생성자 함수로 생성한다. Map 생성자 함수에 인수를 전달하지 않으면 빈 Map 객체가 생성된다.
    Map 생성자 함수는 이터러블을 인수로 전달받아 Map 객체를 생성한다. 이때 인수로 전달되는 이터러블은 키와 값의 쌍으로 이루어진 요소로 구성되어야 한다.
    Map 생성자 함수의 인수로 전달한 이터러블에 중복된 키를 갖는 요소가 존재하면 값이 덮어써진다. 중복된 키를 갖는 요소가 존재할 수 없다.
2-2. 요소 개수 확인
    Map.prototype.size 프로퍼티를 사용한다.
2-3. 요소 추가
    요소를 추가할 때는 Map.prototype.set 메서드를 사용한다.
    set 메서드를 호출한 후에 set 메서드를 연속적으로 호출할 수 있다.
    Map 객체에는 중복된 키를 갖는 요소가 존재할 수 없기 때문에 중복된 키를 갖는 요소를 추가하면 값이 덮어써진다. 이때 에러가 발생하지 않는다.
    일치 비교 연산자를 사용하면 NaN과 NaN은 다르다고 평가하지만 Map 객체는 NaN과 NaN을 같다고 평가하여 중복 추가를 허용하지 않는다.
    +0과 -0도같다고 평가하여 중복 추가를 허용하지 않는다.
    Map 객체는 키 타입에 자힌이 없다. 따라서 객체를 포함한 모든 값을 키로 사용할 수 있다.
2-4. 요소 취득
    Map 객체에서 특정 요소를 취득하려면 Map.prototype.get 메서드를 사용한다. get 메서드의 인수로 키를 전달하면 Map 객체에서 인수로 전달한 키를 갖는 값을 반환한다.
    인수로 전달한 키를 갖는 요소가 존재하지 않으면 undefined를 반환한다.
2-5. 요소 존재 여부 확인
    Map 객체에 특정 요소가 존재하는지 확인하려면 Map.prototype.has 메서드를 사용한다. has 메서드는 특정 요소의 존재 여부를 나타내는 불리언 값을 반환한다.
2-6. 요소 삭제
    Map 객체의 요소를 삭제하려면 Map.prototype.delete 메서드를 사용한다. delete 메서드는 삭제 성공 여부를 나타내는 불리언 값을 반환한다.
    존재하지 않는 키로 Map 객체의 요소를 삭제하려 하면 에러 없이 무시된다.
2-7. 요소 일괄 삭제
    Map 객체의 요소를 일괄 삭제하려면 Map.prototype.clear 메서드를 사용한다. clear 메서드는 언제나 undefined를 반환한다.
2-8. 요소 순회
    Map 객체의 요소를 순회하려면 Map.prototype.forEach 메서드를 사용한다. 
    Map.prototype.forEach 메서드는 콜백 함수와 forEach 메서드의 콜백 함수 내부에서 this로 사용될 객체를 인수로 전달한다. 이때 콜백 함수는 3개의 인수를 전달 받는다.
        첫번째 인수 : 현재 순회중인 요소 값
        두번째 인수 : 현재 순회 중인 요소 키
        세번째 인수 : 현재 순회 중인 Map 객체 자체
    Map 객체는 이터러블이기 때문에  for...of 문으로 순회할 수 있으며 스프레드 문법과 배열 디스트럭처링 할당의 대상이 될 수 있다.
    Map 객체는 이터러블이면서 동시에 이터레이터인 객체를 반환하는 메서드를 제공한다.
        Map.prototype.keys : Map 객체에서 요소키를 값으로 갖는 이터러블이면서 동시에 이터레이터인 객체를 반환한다.
        Map.prototype.values : Map 객체에서 요소값을 값으로 갖는 이터러블이면서 동시에 이터레이터인 객체를 반환한다.
        Map.prototype.entries : Map 객체에서 요소키와 요소값을 값으로 갖는 이터러블이면서 동시에 이터레이터인 객체를 반환한다.
    Map 객체는 요소의 순서에 의미를 갖지 않지만 Map 객체를 순회하는 순서는 요소가 추가된 순서를 따른다.
*/

let set = new Set();
console.log(set); //Set(0) {}

let set1 = new Set([1,2,3,4]); //Set(4) { 1, 2, 3, 4 }
console.log(set1)
let set2 = new Set('hello'); //Set(4) { 'h', 'e', 'l', 'o' }
console.log(set2);

//배열에서 중복 값 제거
let uniqu = array => array.filter((v, i, self) => self.indexOf(v) === i);
console.log(uniqu([2,1,3,2,1,3,4])); //[ 2, 1, 3, 4 ]

let uniqu2 = array => [...new Set(array)];
console.log(uniqu2([2,1,3,2,1,3,4])); //[ 2, 1, 3, 4 ]

let { size } = new Set([1,2,3,4]);
console.log(size); //4

set.add(1);
console.log(set); //Set(1) { 1 }
set.add(2).add(4);
console.log(set); //Set(3) { 1, 2, 4 }

console.log(set.has(3)); //false
console.log(set.has(4)); //true

set.delete(2);
console.log(set); //Set(2) { 1, 4 }
set.delete(6);
console.log(set); //Set(2) { 1, 4 }

set.clear();
console.log(set); //Set(0) {}

let set3 = new Set([1,2,3]);
set3.forEach((v, v2, set) => console.log(v, v2, set));
/*
1 1 Set(3) { 1, 2, 3 }
2 2 Set(3) { 1, 2, 3 }
3 3 Set(3) { 1, 2, 3 }
*/

//Set 객체는 Set.prototype의 Symbol.iterator 메서드를 상속받는 이터러블이다.
console.log(Symbol.iterator in set3); //true

//for...of문
for(let val of set3) {
    console.log(val);//1, 2, 3
}

//스프레드 문법
console.log([... set3]); //[ 1, 2, 3 ]

let[a, ...rest] = set3;
console.log(a, rest); //1 [ 2, 3 ]


let setA = new Set([1,2,3,4]);
let setB = new Set([2,4]);

//교집합 방법1
Set.prototype.intersection = function(set) {
    let result = new Set();

    for (let val of set) {
        if(this.has(val)){
            result.add(val)
        }
    }

    return result
}
console.log(setA.intersection(setB)); //Set(2) { 2, 4 }
console.log(setB.intersection(setA)); //Set(2) { 2, 4 }

//교집합 방법2
Set.prototype.intersection2 = function(set) {
    return new Set([...this].filter(v => set.has(v)));
};
console.log(setA.intersection2(setB)); //Set(2) { 2, 4 }
console.log(setB.intersection2(setA)); //Set(2) { 2, 4 }

//합집합 방법1
Set.prototype.union = function(set) {
    let result = new Set(this);

    for(let val of set) {
        result.add(val);
    }

    return result
};
console.log(setA.union(setB)); //Set(4) { 1, 2, 3, 4 }
console.log(setB.union(setA)); //Set(4) { 2, 4, 1, 3 }

//합집합 방법2
Set.prototype.union2 = function(set) {
    return new Set([...this, ...set])
};
console.log(setA.union2(setB)); //Set(4) { 1, 2, 3, 4 }
console.log(setB.union2(setA)); //Set(4) { 2, 4, 1, 3 }

//차집합 방법1
Set.prototype.difference = function(set) {
    let result = new Set(this);
    
    for(let val of set) {
        result.delete(val);
    }
    return result;
}
console.log(setA.difference(setB)); //Set(2) { 1, 3 }
console.log(setB.difference(setA)); //Set(0) {}

//차집합 방법2
Set.prototype.difference2 = function(set) {
    return new Set([...this].filter(v=>!set.has(v)));
};
console.log(setA.difference2(setB)); //Set(2) { 1, 3 }
console.log(setB.difference2(setA)); //Set(0) {}

//상위집합 확인1
Set.prototype.isSuperset = function(subset) {
    for(let val of subset) {
        if(!this.has(val)) {
            return false;
        }
    }

    return true;
}
console.log(setA.isSuperset(setB)); //true
console.log(setB.isSuperset(setA)); //false

//상위집합 확인2
Set.prototype.isSuperset2 = function(subset) {
    const supersetArr = [... this];
    return [... subset].every(v => supersetArr.includes(v));
};
console.log(setA.isSuperset2(setB)); //true
console.log(setB.isSuperset2(setA)); //false

let map = new Map();
console.log(map); //Map(0) {}

let map1 = new Map([['key1', 'value1'], ['key2', 'value2']]);
console.log(map1); //Map(2) { 'key1' => 'value1', 'key2' => 'value2' }

//let map2 = new Map([1,2]); //TypeError: Iterator value 1 is not an entry object

let map2 = new Map([['key', 'value1'], ['key2', 'value2']]);
console.log(map2.size); //2

let map3 = new Map();
map3.set('key1', 'value1')
.set('key2', 'value2')
console.log(map3); //Map(2) { 'key1' => 'value1', 'key2' => 'value2' }

let map4 = new Map();
let park = {name: 'park'};
let sudal = {name: 'sudal'};
//객체도 키로 사용될 수 있다.
map4.set(park, 'developer')
    .set(sudal, 'Seoul');
console.log(map4);
/*
Map(2) {
  { name: 'park' } => 'developer',
  { name: 'sudal' } => 'Seoul'
}
*/

console.log(map4.get(park)); //developer
console.log(map4.get('key')); //undefined

console.log(map4.has(park)); //true
console.log(map4.has('key')); //false

map4.delete(sudal);
console.log(map4); //Map(1) { { name: 'park' } => 'developer' }

let person = {name: 'kh'};
let cat = {name: 'hafa'};
let map5 = new Map([[person, 'developer'], [cat, 'animal']]);
map5.forEach((v, k, map) => console.log(v, k, map));
/*
developer { name: 'kh' } Map(2) { { name: 'kh' } => 'developer', { name: 'hafa' } => 'animal' }
animal { name: 'hafa' } Map(2) { { name: 'kh' } => 'developer', { name: 'hafa' } => 'animal' }
*/
console.log(Symbol.iterator in map5); //true

for(let entry of map5) {
    console.log(entry);
    /*
    [ { name: 'kh' }, 'developer' ]
    [ { name: 'hafa' }, 'animal' ]
    */
}

console.log([...map5]); //[ [ { name: 'kh' }, 'developer' ], [ { name: 'hafa' }, 'animal' ] ]

let[c,d] = map5;
console.log(c,d); //[ { name: 'kh' }, 'developer' ] [ { name: 'hafa' }, 'animal' ]

for(let key of map5.keys()) {
    console.log(key);
    /*
    { name: 'kh' }
    { name: 'hafa' }
    */
}

for (let value of map5.values()) {
    console.log(value);
    /*
    developer
    animal
    */
}

for(let entry of map5.entries()) {
    console.log(entry);
    /*
    [ { name: 'kh' }, 'developer' ]
    
    
    [ { name: 'hafa' }, 'animal' ]
    */
}