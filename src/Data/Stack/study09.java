package Data.Stack;

import java.util.ArrayDeque;

public class study09 {
  public static void main(String[] args) {

    ArrayDeque<String> stack = new ArrayDeque<>();

    stack.push("1111");
    stack.push("2222");
    stack.push("3333");

    // Iterator를 통해 데이터를 조회하려면,
    // for ( : ) 문을 사용하는 것이 더 낫다

    for (String s : stack) {
      System.out.println(s);
    }
  }
}
