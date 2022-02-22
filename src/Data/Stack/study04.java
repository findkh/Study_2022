package Data.Stack;

import java.util.Stack;

//Stack 클래스 사용법 - search()
public class study04 {
  public static void main(String[] args) {

    Stack<String> stack = new Stack<>();

    stack.push("111");
    stack.push("222");
    stack.push("333");

    //search() - 스택의 맨 위에서부터 해당 값을 찾는다. 맨 위가 1이고 값이 없으면 -1을 리턴한다
    System.out.println(stack.search(new String("111")));
    System.out.println(stack.search(new String("222")));
    System.out.println(stack.search(new String("333")));
    System.out.println(stack.search(new String("하파")));

    /*
     Returns the 1-based position where an object is on this stack.
     If the object o occurs as an item in this stack, thismethod returns the distance from the top of the stack of theoccurrence nearest the top of the stack; 
     the topmost item on thestack is considered to be at distance 1. The equalsmethod is used to compare o to theitems in this stack.
     Parameters:o the desired object.
     Returns:the 1-based position from the top of the stack wherethe object is located; 
     the return value -1indicates that the object is not on the stack.
     */
  }
}
