package Data.Stack.createStack;
//Object.clone()을 오버라이딩 : deep copy test
public class Stack02Test {
  public static void main(String[] args) throws Exception {
    Stack02 stack = new Stack02();
    stack.push("aaa");
    stack.push("bbb");
    stack.push("ccc");
    stack.push("ddd");
    stack.push("eee");
    print(stack);

    System.out.println("--------------");

    Stack02 stack2 = stack.clone();
    stack2.pop();
    stack2.pop();
    print(stack2);
    System.out.println("--------------");

    print(stack);
  }

  static void print(Stack02 stack) {
    for (int i = 0; i < stack.size(); i++) {
      System.out.print(stack.get(i) + ",");
    }
    System.out.println();
  }
}
