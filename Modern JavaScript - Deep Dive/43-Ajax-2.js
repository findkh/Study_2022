/*
3. XMLHttpRequest
    자바스크립트를 사용하여 HTTP 요청을 전송하려면 XMLHttpRequest 객체를 사용한다.
    Web API인 XMLHttpRequest 객체는 HTTP 요청 전송과 HTTP 응답 수신을 위한 다양한 메서드와 프로퍼티를 제공한다.
3-1. XMLHttpRequest 객체 생성
    XMLHttpRequest 객체는 XMLHttpRequest 생성자 함수를 호출하여 생성한다. XMLHttpRequest 객체는 브라우저에서 제공하는 WebAPI이므로 브라우저 환경에서만 정상적으로 실행된다.
3-2. XMLHttpRequest 객체의 프로퍼티와 메서드
    - MLHttpRequest 객체의 프로퍼티
        readyState : HTTP 요청의 현재 상태를 나타내는 정수 
                        UNSENT : 0
                        OPENED : 1
                        HEADERS_RECEIVED : 2
                        LOADING : 3
                        DONE : 4
        status : HTTP 요청에 대한 응답 상태를 나타내는 정수
        statusText : HTTP 요청에 대한 응답 메세지를 나타내는 문자열
        responseType : HTTP 응답 타입
        response : HTTP 요청에 대한 응답 몸체
        responseText : 서버가 전송한 HTTP 요청에 대한 응답 문자열
    - XMLHttpRequest 객체의 이벤트 핸들러 프로퍼티
        onreadystatechange : readyState 프로퍼티 값이 변경된 경우
        onloadstart : HTTP 요청에 대한 응답을 받기 시작한 경우
        onprogress : HTTP 요청에 대한 응답을 받는 도중 주기적으로 발생
        onaboart : abort 메서드에 의해 HTTP 요청이 중단된 경우
        onerror : HTTP 요청에 에러가 발생한 경우
        onload : HTTP 요청이 성공적으로 완료한 경우
        ontimeout : HTTP 요청 시간이 초과한 경우
        onloadend : HTTP 요청이 완료한 경우. HTTP 요청이 성공 또는 실패하면 발생
    - XMLHttpRequest 객체의 메서드
        open : HTTP 요청 초기화
        send : HTTP 요청 전송
        abort : 이미 전송된 HTTP 요청 중단
        setRequestHeader : 특정 HTTP 요청 헤더의 값을 설정
        getResponseHeader : 특정 HTTP 요청 헤더의 값을 문자열로 반환
    - XMLHttpRequest 객체의 정적 프로퍼티
        UNSENT : 0 : open 메서드 호출 이전
        OPENED : 1 : open 메서드 호출 이후
        HEADERS_RECEIVED : 2 : send 메서드 호출 이후
        LOADING : 3 : 서버 응답 중(응답 데이터 미완성 상태)
        DONE : 4 : 서버 응답 완료
3-3. HTTP 요청 전송
    1) XMLHttpRequest.prototype.open 메서드로 HTTP 요청을 초기화한다.
    2) 필요에 따라 XMLHttpRequest.prototype.setRequestHeader 메서드로 특정 HTTP 요청의 헤더 값을 설정한다.
    3) XMLHttpRequest.prototype.send 메서드로 HTTP 요청을 전송한다.

    XMLHttpRequest.prototype.open
        method : HTTP 요청 메서드
        url : HTTP 요청을 전송할 URL
        async : 비동기 요청 여부, 옵션으로 기본값을 true이며 비동기 방식으로 동작한다.

    XMLHttpRequest.prototype.send
        send 메서드는 open 메서드로 초기화된 HTTP 요청을 서버에 전송한다.
            GET 요청 메서드의 경우 데이터를 URL의 일부분인 쿼리 문자열로 서버에 전송한다.
            POST 요청 메서드의 경우 데이터를 요청 몸체에 담아 전송한다.
        HTTP 요청 메서드가 GET인 경우 send 메서드에 페이로드로 전달한 인수는 무시되고 요청 몸체는 null로 설정된다.

    XMLHttpRequest.prototype.setRequestHeader
        setRequestHeader 메서드는 특정 HTTP 요청의 헤더 값을 설정한다.
        setRequestHeader는 반드시 open 메서드를 호출한 이후에 호출해야 한다.
        HTTP 클라이언트가 서버에 요청할 때 서버가 응답할 데이터의 MIME 타입을 Accept로 지정할 수 있다. 
        만약 Accept 헤더를 설정하지 않으면 send 메서드가 호출될 때 Accept 헤더가 * /*으로 지정된다.
3-4. HTTP 응답 처리
    서버가 전송한 응답을 처리하려면 XMLHttpRequest 객체가 발생시키는 이벤트를 캐치해야 한다.        
*/

//XMLHttpRequest 객체 생성
let xhr = new XMLHttpRequest();

//HTTP 요청 초기화
xhr.open('GET', '/user');

//HTTP 요청 헤더 설정
//클라이언트가 서버로 전송할 데이터를 MIME 타입 지정 : json
xhr.setRequestHeader('content-type', 'application/json');

//HTTP 요청 전송
xhr.send


