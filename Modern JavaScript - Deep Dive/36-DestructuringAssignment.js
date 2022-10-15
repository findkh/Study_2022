/*
디스트럭처링 할당
    디스트럭처링 할당(구조 분해 할당)은 구조화된 배열과 같은 이터러블 또는 객체를 destructuring(비구조화, 구조 파괴)하여 1개 이상의 변수에 개별적으로 할당하는 것을 말한다.
    배열과 같은 이터러블 또는 객체 리터럴에서 필요한 값만 추출하여 변수에 할당 할 때 유용하다.
1. 배열 디스트럭처링 할당
    ES6의 배열 디스트럭처링 할당은 배열의 각 요소를 배열로부터 추출하여 1개 이상의 변수에 할당한다. 
    이때 배열 디스트럭처링 할당의 대상은 이터러블이어야 하며, 할당 기준은 배열의 인덱스다.
    즉 순서대로 할당된다. 이때 변수의 개수와 이터러블의 요소 개수가 반드시 일치할 필요는 없다.
    배열 디스트럭처링 할당을 위한 변수에 Rest 파라미터와 유사하게 Rest 요소 ...을 사용할 수 있다.
    Rest 요소는 마지막에 위치해야 한다.
2. 객체 디스트럭처링 할당
    ES5에서 객체의 각 프로퍼티를 객체로부터 디스트럭처링하여 변수에 할당하기 위해서는 프로퍼티 키를 사용해야 한다.
    ES6의 객체 디스트럭처링 할당은 객체의 각 프로퍼티를 객체로부터 추출하여 1개 이상의 변수에 할당한다.
    이떄 객체 디스트럭처링 할당의 대상은 객체여야 하며, 할당 기중는 프로퍼티 키다.
    순서는 의미가 없으며 선언된 변수 이름과 프로퍼티 키가 일치하면 할당된다.
    객체에서 프로퍼티 키로 필요한 프로퍼티 값만 추출하여 변수에 할당하고 싶을 때 유용하다.
    배열의 요소가 객체인 경우 배열 디스트럭처링 할당과 객체 디스트럭처링 할당을 혼용할 수 있다.
*/

let arr = [1, 2, 3];
let [one, two, three] = arr;
console.log(one, two, three); //1 2 3

let [a, b] = [1];
console.log(a, b); //1 undefined

//배열 디스트럭처링 할당을 위한 변수에 기본값을 설정할 수 있다.
let [c, d, e = 3] = [1, 2];
console.log(c,d,e); //1 2 3
//기본값보다 할당된 값이 우선한다.
let[f, g =10, h =3] = [1,2];
console.log(f,g,h); //1 2 3

// url을 파싱하여 protocol, host, path 프로퍼티를 갖는 객체를 생성해 반환한다.
function parseURL(url = '') {
    // '://' 앞의 문자열(protocol)과 '/' 이전의 '/'으로 시작하지 않는 문자열(host)과 '/' 이후의 문자열(path)을 검색한다.
    const parsedURL = url.match(/^(\w+):\/\/([^/]+)\/(.*)$/);
    console.log(parsedURL);
    /*
    [
      'https://developer.mozilla.org/ko/docs/Web/JavaScript',
      'https',
      'developer.mozilla.org',
      'ko/docs/Web/JavaScript',
      index: 0,
      input: 'https://developer.mozilla.org/ko/docs/Web/JavaScript',
      groups: undefined
    ]
    */
  
    if (!parsedURL) return {};
  
    // 배열 디스트럭처링 할당을 사용하여 이터러블에서 필요한 요소만 추출한다.
    const [, protocol, host, path] = parsedURL;
    return { protocol, host, path };
  }
  
  const parsedURL = parseURL('https://developer.mozilla.org/ko/docs/Web/JavaScript');
  console.log(parsedURL);
  /*
  {
    protocol: 'https',
    host: 'developer.mozilla.org',
    path: 'ko/docs/Web/JavaScript'
  }
  */

  let [x, ...y] = [1,2,3];
  console.log(x, y); //1 [ 2, 3 ]

  
  let user = {name:'sudal', age:20};
  //ES5
  let userName = user.name;
  let userAge = user.age;
  console.log(userName, userAge); //sudal 20

  //ES6
  let {age, name} = user;
  console.log(name, age); ////sudal 20

  let{name:haha, age:hoho} = user;
  console.log(haha, hoho); //sudal 20

  let {firstname = 'Park', lastName} = {lastName:'KH'};
  console.log(firstname, lastName); //Park KH

  let str = 'Hello';
  let {length} = str;
  console.log(length);//5

//   let todo = {id:1, content:'HTML', completed:'false'};
//   let {id} = todo;
//   console.log(id);//1

  let todos = [
    {id:1, content: 'HTML', completed: true},
    {id:2, content: 'CSS', completed: true},
    {id:3, content: 'JS', completed: true}
  ];

  //todos 배열의 세 번째 요소인 객체로부터 id 프로퍼티만 추출한다.
  let[, , {id}] = todos;
  console.log(id);//3

  //중첩 객체
  let user2 = {
    name : 'park',
    address : {
        city : 'Seoul',
        gu : 'guro'
    }
  };

  //address 프로퍼티 키로 객체를 추출하고 이 객체의 city 프로퍼티 키로 값을 추출한다.
  let { address: {city}} = user2;
  console.log(city); //Seoul

  //Rest 프로퍼티 사용
  let {x2, ...rest} = {x2:1, y:2, z:3};
  console.log(x2, rest); //1 { y: 2, z: 3 }