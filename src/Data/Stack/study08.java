package Data.Stack;
//Stack의 Iterator와 Deque의 Iterator 차이점

import java.util.ArrayDeque;
import java.util.Iterator;

public class study08 {
  public static void main(String[] args) {

    ArrayDeque<String> stack = new ArrayDeque<>();

    stack.push("111");
    stack.push("222");
    stack.push("333");

    /* Stack 클래스와 다르게 Deque 구현체의 Iterator는 LIFO으로 데이터를 꺼낸다.
     Iterator를 통해 데이터를 꺼낼 때 스택의 특성을 그대로 유지하고 싶다면
     Stack 클래스 대신 ArrayDeque 클래스를 사용한다     
     */

    Iterator<String> iterator = stack.iterator();

    while(iterator.hasNext()) {
      System.out.println(iterator.next());
    }

    /* Iterator 설계 기법 목적
       -> 데이터 조회 방식(LIFO, FIFO)에 상관없이 일관된 방법으로 데이터를 조회할 수 있게 도와준다.
          즉 스택처럼 입력 역순으로 꺼내든,
          큐처럼 입력 순으로 꺼내든 상관 없이
          hasNext(), next() 라는 동일한 메서드를 사용하여 데이터를 조회한다.
     */

  }
}
