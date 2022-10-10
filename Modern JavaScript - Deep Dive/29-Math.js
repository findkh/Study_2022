/*
Math
1. Math 프로퍼티
1-1. Math.PI
    원주율 PI 값을 반환한다.
2. Math 메서드
2-1. Math.abs
    인수로 전달된 숫자의 절대값을 반환한다. 절대값은 반드시 0 또는 양수여야 한다.
2-2. Math.round
    인수로 전달된 숫자의 소수점 이하를 반올림한 정수를 반환한다.
2-3. Math.ceil
    인수로 전달된 숫자의 소숫점 이하를 올림한 정수로 반환한다.
2-4. Math.floor
    인수로 전달된 숫자의 소수점 이하를 내림한 정수를 반환한다.
2-5. Math.sqrt
    인수로 전달된 숫자의 제곱근을 반환한다.
2-6. Math.random
    임의의 난수를 반환한다. 반환한 난수는 0에서 1미만의 실수다.
2-7. Math.pow
    첫번째 인수를 미틍로 두번째 인수를 지수로 거듭 제곱한 결과를 반환한다.
2-8. Math.max
    전달받은 인수 중에서 가장 큰 수를 반환한다. 인수가 전달되지 않으면 -Infinity를 반환한다.
2-9. math.min
    전달받은 인수 중에서 가장 작은 수를 반환한다. 인수가 전달되지 않으면 Inifinity를 반환한다.
 */
console.log(Math.random());
console.log(Math.floor(Math.random()*10+1))

let arr = [1,2,3,4,5,6];

console.log(Math.max.apply(null, arr)); //6
//ES6 스프레드 문법
console.log(Math.max(... arr))

console.log(Math.min.apply(null, arr));
console.log(Math.min(... arr));