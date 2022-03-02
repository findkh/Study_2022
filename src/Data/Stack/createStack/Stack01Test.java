package Data.Stack.createStack;

public class Stack01Test {
  public static void main(String[] args) {
    Stack01 stack = new Stack01();
    stack.push("aaa");
    stack.push("bbb");
    stack.push("ccc");
    System.out.println(stack.peek());
    stack.push("ddd");
    stack.push("eee");
    print(stack);

    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.peek());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
  }

  static void print(Stack01 stack) {
    for (int i = 0; i < stack.size(); i++) {
      System.out.println(stack.get(i) + ",");
    }
    System.out.println();
  }
}
