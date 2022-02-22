package Data.Stack;
//Stack 클래스 사용

import java.util.Stack;

public class study01 {
  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();

    //값을 추가한다
    stack.push("111");
    stack.push("222");
    stack.push("333");
    //stack.push(new Date());
    //The method push(String) in the type Stack<String> is not applicable for the arguments (Date)
    //타입 파라미터에 전달한 타입과 일치하지 않으면 오류

    //값을 꺼낸다 - 스택의 맨 마지막에 입력된 값부터 꺼낸다.
    //LIFO(List In First Out)
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());

    //값이 없는데 꺼내려 하면 예외 발생
    System.out.println(stack.pop()); //java.util.EmptyStackException
  }
}
