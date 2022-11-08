/*
1. 동기 처리와 비동기 처리
    자바스크립트 엔진은 한 번에 하나의 태스크만 실행할 수 있는 싱글 스레드 방식으로 동작한다. 싱글 스레드 방식은 한 번에 하나의 태스크만 실행할 수 있기 때문에 처리에 시간이 걸리는 태스크를 실행하는 경우 블로킹이 발생한다.
    현재 실행 중인 태스크가 종료할 때까지 다음에 실행될 태스크가 대기하는 방식을 동기처리라고 한다.
    동기 처리 방식은 태스크를 순서대로 하나씩 처리하므로 실행 순서가 보장된다는 장점이 있지만 앞선 태스크가 종료할 때까지 이후 태스크들이 블로킹되는 단점이 있다.
    현재 실행 중인 태스크가 종료되지 않은 상태라 해도 다음 태스크를 곧바로 실행하는 방식을 비동기처리라고 한다.
    비동기 처리 방식은 현재 실행 중인 태스크가 종료되지 않은 상태라 해도 다음 태스크를 곧바로 실행하므로 블로킹이 발생하지 않는다는 장점이 있지만, 태스크의 실행 순서가 보장되지 않는 단점이 있다.
    타이머 함수인 setTimeout과 setInterval, HTTp 요청, 이벤트 핸들러는 비동기 처리 방식으로 동작한다.
2. 이벤트 루프와 태스크 큐
    자바스크립트의 동시성을 지원하는 것이 이벤트 루프다.
    이벤트 루프는 브라우저에 내장되어 있는 기능 중 하나다.
    - 태스크 큐 : setTimeout이나 setInterval과 같은 비동기 함수의 콜백 함수 또는 이벤트 핸들러가 일시적으로 보관되는 영역이다. 태스크 큐와는 별도로 프로미스의 후속 처리 메서드의 콜백 함수가 일시적으로 ㅂ관되는 마이크로태스크 큐도 존재한다.
    - 이벤트 루프 : 콜 스택에 현재 실행 중인 실행 컨텍스트가 있는지, 그리고 태스크 큐에 대기중인 함수가 있는지 반복해서 확인한다.
                    만약 콜 스택이 비어 있고 태스트 큐에 대기중인 함수가 있다면 이벤트 루프는 순차적으로 태스크 큐에 대기 중인 함수를 콜 스택으로 이동시킨다. 이때 콜스 택으로 이동한 함수는 실행된다.
                    즉 태스크 큐에 일시 보관된 함수들은 비동기 처리 방식으로 동작한다.
    자바스크립트는 싱글 스레드 방식으로 동작한다.
    이때 싱글 스레드 방식으로 동작하는 것은 브라우저가 아니라 브라우저에 내장된 자바스크립트 엔진이다. 만약 모든 자바스크립트 코드가 자바스크립트 엔진에서 싱글 스레드 방식으로 동작한다면 자바스크립트는 비동기로 동작할 수 없다.
    즉 자바스크립트 엔진은 싱글 스레드로 동작하지만 브라우저는 멀티 스레드로 동작한다.
    
*/