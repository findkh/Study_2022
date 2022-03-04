package Data.Stack.createStack;
//Object.clone()을 오버라이딩 : deep copy test
public class Stack03Test {
  public static void main(String[] args) throws Exception {
    Stack03<String> stack = new Stack03<>();
    stack.push("aaa");
    stack.push("bbb");
    stack.push("ccc");
    stack.push("ddd");
    stack.push("eee");
    print(stack);

    System.out.println("--------------");

    Stack03<String> stack2 = stack.clone();
    stack2.pop();
    stack2.pop();
    print(stack2);
    System.out.println("--------------");

    while (!stack2.empty()) {
      System.out.println(stack2.pop());
    }
    System.out.println("--------------");

    print(stack);
    System.out.println("--------------");
  }

  static void print(Stack03<String> stack) {
    for (int i = 0; i < stack.size(); i++) {
      System.out.print(stack.get(i) + ",");
    }
    System.out.println();
  }
}
