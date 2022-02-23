package Data.Stack;
// stack 클래스 사용법 - size()
import java.util.Stack;

public class study05 {
  public static void main(String[] args) {
    Stack<String> stack = new Stack<>(); 

    stack.push("111");
    stack.push("222");
    stack.push("333");

    for (int i = 0; i < stack.size(); i++) {
      System.out.println(stack.get(i));
    }

    System.out.println("stack 사이즈 " +stack.size());
  }
}
