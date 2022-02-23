package Data.Stack;
//Stack과 Deque

import java.util.ArrayDeque;

public class study07 {
  public static void main(String[] args) {
    /* Deque 인터페이스
    Double ended queue의 약자
    앞, 뒤 모두 양방향에서 값을 넣고 꺼낼 수 있다.
    그래서 큐로도 사용할 수 있고 스택으로도 사용할 수 있ㄷ다.
    큐, 스택 둘 다 사용할 수 있도록 queue와 stack 사용법을 모두 정의한 인터페이스이다    
     */

    //Dequeue
    ArrayDeque<String> stack = new ArrayDeque<>();

    //stack으로 사용할 수 있다.
    stack.push("111");
    stack.push("222");
    stack.push("333");

    while(!stack.isEmpty()) {
      System.out.println(stack.pop());
    }
  }
}
