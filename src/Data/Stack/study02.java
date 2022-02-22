package Data.Stack;
//Stack 클래스 - empty()

import java.util.Stack;

public class study02 {
  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();

    stack.push("111");
    stack.push("222");
    stack.push("333");

    System.out.println(stack.size());

    while (!stack.empty()) {
      System.out.println(stack.pop());
      //stack 마지막에 입력된 값 먼저 출력되므로 333->222->111 출력됨
    }
  }
}
