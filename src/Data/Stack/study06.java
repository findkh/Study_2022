package Data.Stack;
//Stack 클래스 사용법 - Iterator 사용
import java.util.Iterator;
import java.util.Stack;

public class study06 {
  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();

    stack.push("111");
    stack.push("222");
    stack.push("333");

    Iterator<String> iterator = stack.iterator();

    while(iterator.hasNext()) {
      System.out.println(iterator.next());
    }

    System.out.println();

    Stack<String> stack2 = new Stack<>();
    /*
    Stack도 Iterable 구현체이기 때문에 for ( : )문을 사용할 수 있다.
    내부적으로는 iterator()를 호출하여 Iterator를 얻은 후에 이 Iterator를 통해서 값을 꺼낸다.

    위와 같이 직접 Iterator를 사용할 것인지,
    아니면 밑에와 같이 for( : ) 문을 통해 간접적으로 처리할 것인지 선택해서 사용한다.

     */

    stack2.push("하파");
    stack2.push("수달");
    stack2.push("티즈");

    for (String s : stack2) {
      System.out.println(s);
    }
  }

}
