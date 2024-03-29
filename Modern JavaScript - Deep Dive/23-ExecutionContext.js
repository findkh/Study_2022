/*
실행 컨텍스트(execution context)
1. 소스코드의 타입
    - 전역 코드(global code) : 전역에 존재하는 소스코드, 전역에 정의된 함수, 클래스 등의 내부 코드는 포함되지 않는다.
    - 함수 코드(function code) : 함수 내부에 존재하는 소스코드를 말한다. 함수 내부에 중첩된 함수, 클래스 등의 내부 코드는 포함되지 않는다.
    - eval 코드(eval code) : 빌트인 전역 함수인 eval 함수에 인수로 전달되어 실행되는 소스코드를 말한다.
    - 모듈 코드(module code) : 모듈 내부에 존재하는 소스코드를 말한다. 모듈 내부의 함수, 클래스 등의 내부 코드는 포함되지 않는다.
2. 소스코드의 평가와 실행
    ㅁ자바스크립트 엔진은 소스코드를 2개의 과정 소스코드의 평가와 소스코드의 실행 과정으로 나누어 처리한다.
    소스코드 평가 과정에서는 실행 컨텍스트를 생성하고 변수, 함수 등의 선언문만 먼저 실행하여 생성된 변수나 함수 식별자를 키로 실행 컨텍스트가 관리하는 스코프에 등록한다.
    소스코드 평가 과정이 끝나면 선언문을 제외한 소스코드가 순차적으로 실행되기 시작한다.
    그리고 변수 값의 변경 등 소스코드의 실행 결과는 다시 실행 컨텍스트가 관리하는 스코프에 등록된다.
3. 실행 컨텍스트의 역할
    코드가 실행되려면 스코프, 식별자, 코드 실행 순서 등의 관리가 필요하다.
        - 선언에 의해 생성된 모든 식별자를 스코프를 구분하여 등록하고 상태 변화를 지속적으로 관리할 수 있어야 한다.
        - 스코프는 중첩 관계에 의해 스코프 체인을 형성해야 한다. 즉 스코프 체인을 통해 상위 스코프로 이동하며 식별자를 검색할 수 있어야 한다.
        - 현재 실행 중인 코드의 실행 순서를 변경할 수 있어야 하며 다시 되돌아갈 수도 있어야 한다.
    이 것들을 관리하는 것이 실행 컨텍스트다. 
    실행 컨텍스트는 소슼 ㅗ드를 실행하는데 필요한 환경을 제공하고 코드의 실행 결과를 실제로 관리하는 영역이다.
    식별자(변수, 함수, 클래스 등의 이름)를 등록하고 관리하는 스코프와 코드 실행 순서 관리를 구현한 내부 메커니즘으로 모든 코드는 실행 컨텍스트를 통해 실행되고 관리된다.
4. 실행 컨텍스트 스택
    실행 컨텍스트는 스택 자료 구조로 관리된다. 이를 실행 컨텍스트 스택이라고 부른다. 
    실행 컨텍스트 스택은 코드의 실행 순서를 관리한다. 소스 코드가 평가되면 실행 컨텍스트가 생성되고 실행 컨텍스트 스택의 최사우이에 쌓인다.
    실행 컨텍스트 스택의 최상위에 존재하는 실행 컨텍스트는 언제나 현재 실행중인 코드의 실행 컨텍스트다.
5. 렉시컬 환경
    식별자와 식별자에 바인딩된 값, 그리고 상위 스코프에 대한 참조를 기록하는 자료구조로 실행 컨텍스트를 구성하는 컴포넌트다.
    실행 컨텍스트 스택이 코드의 실행 순서를 관리한다면 렉시컬 환경은 스코프와 식별자를 관리한다.
    렉시컬 환경은 스코프를 구분하여 식별자를 등록하고 관리하는 저장소 역할을 하는 렉시컬 스코프의 실체다.

*/
var x = 1;
const y = 2;
function foo(a) {
    var x = 3;
    const y = 4;

    function bar (b) {
        const z = 5;
        console.log(a + b + x + y + z);
    }
    bar(10);
}

foo(20);