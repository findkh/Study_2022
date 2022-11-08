/*
1. Ajax란?
    자바스크립트를 사용하여 브라우저가 서버에게 비동기 방식으로 데이터를 요청하고, 서버가 응답한 데이터를 수신하여 웹페이지를 동적으로 갱신하는 프로그래밍 방식을 말한다.
    이전의 웹페이지는 html 태그로 시작해서 html 태그로 끝나는 완전한 HTMl을 서버로부터 전송받아 웹페이지 전체를 처음부터 다시 렌더링하는 방식으로 동작했다.
    따라서 화면이 전환되면 서버로부터 새로운 HTML을 전송받아 웹페이지 전체를 처음부터 다시 렌더링했다.
    이러한 방식의 단점은,
        - 이전 웹페이지와 차이가 없어서 변경할 필요가 없는 부분까지 포함된 완전한 HTML을 서버로부터 매번 다시 전송받기 때문에 불필요한 데이터 통신이 발생한다.
        - 변경할 필요가 없는 부분까지 처음부터 다시 렌더링한다. 이로 인해 화면 전환이 일어나면 화면이 순간적으로 깜박이는 현상이 발생한다.
        - 클라이언트와 서버와의 통신이 동기 방식으로 동작하기 때문에 서버로부터 응답이 있을 때까지 다음 처리는 블로킹된다.
    Ajax의 장점
        - 변경할 부분을 갱신하는 데 필요한 데이터만 서버로부터 전송받기 때문에 불필요한 데이터 통신이 발생하지 않는다.
        - 변경할 필요가 없는 부분은 다시 렌더링하지 않는다. 따라서 화면이 순간적으로 깜박이는 현상이 발생하지 않는다.
        - 클라이언트와 서버와의 통신이 비동기 방식으로 동작하기 때문에 서버에게 요청을 보낸 이후 블로킹이 발생하지 않는다.
2. JSON
    JSON은 클라이언트와 서버 간의 HTTP 통신을 위한 텍스트 데이터 포맷이다.
    자바스크립트에 종속되지 않는 언어 독립형 데이터 포맷으로 대부분의 프로그래밍 언어에서 사용할 수 있다.
2-1. JSON 표기 방식
    JSON은 자바스크립트의 객체 리터럴과 유사하게 키와 값으로 구성된 순수한 텍스트다.
2-2. JSON.stringify
    JSON.stringify 메서드는 객체를 JSON 포맷의 문자열로 변환한다. 클라이언트가 서버로 객체를 전송하려면 객체를 문자열화해야 하는데 이를 직렬화라 한다.
2-3. JSON.parse
    JSON.parse 메서드는 JSON 포맷의 문자열을 객체로 변환한다. 서버로부터 클라이언트에게 전송된 JSOn 데이터는 문자열이다.
    이 문자열을 객체로서 사용하려면 JSON 포맷의 문자열을 객체화해야 하는데 이를 역직렬화라한다.
*/
let obj = {
    name : 'park',
    age : '34',
    alive: true,
    hobby: ['lego', 'coding']
};

//객체를 JSOn 포맷의 문자열로 변환한다.
let json = JSON.stringify(obj);
console.log(typeof json, json); //string {"name":"park","age":"34","alive":true,"hobby":["lego","coding"]}

//객체를 JSON 포맷의 문자열로 변환하면서 들여쓰기 한다.
let prettyJson = JSON.stringify(obj, null, 2);
console.log(typeof prettyJson, prettyJson);
/*
string {
  "name": "park",
  "age": "34",
  "alive": true,
  "hobby": [
    "lego",
    "coding"
  ]
}
*/

//JSON 포맷의 문자열을 객체로 변환한다.
let parsed = JSON.parse(json);
console.log(typeof parsed, parsed); //object { name: 'park', age: '34', alive: true, hobby: [ 'lego', 'coding' ] }