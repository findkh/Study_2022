package Data.Stack;
//Stack 클래스 사용법 - peek()
import java.util.Stack;

public class study03 {
  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();

    stack.push("111");
    stack.push("222");
    stack.push("333");

    // peek() 맨 위의 값을 꺼낸다. pop()은 제거하지만 peep은 제거하지 않는다
    System.out.println(stack.peek());
    System.out.println(stack.peek());
    System.out.println(stack.peek());

    System.out.println();

    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
  }
}
