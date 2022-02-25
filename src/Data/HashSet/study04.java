package Data.HashSet;

import java.util.ArrayDeque;
//java.util.HashSet 클래스 사용 - 값 꺼내기2
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

/* Iterator 패턴
 - 컬렉션에서 값을 꺼내는 기능을 객체화시키는 방법
 - 즉 별도의 클래스로 정의하여 사용한다.
 - 이점
   컬렉션의 타입에 상관없이 일관된 방식으로 값을 꺼낼 수 있다.
   ex) Arraylist -> get(), Stack -> pop(), Queue -> poll()
   Iterator를 사용하면 hasNext(), next()만 사용하면 된다. 
 */

public class study04 {
  public static void main(String[] args) {

    HashSet<String> set = new HashSet<>();
    set.add("HashSet1");
    set.add("HashSet2");
    set.add("HashSet3");
    set.add("HashSet4");
    set.add("HashSet5");

    // Iterator - 창고에서 값을 꺼내준다.
    //  - HashSet에서 값을 꺼내주는 일을 하는 도우미 객체를 얻는다.
    Iterator<String> 컬렉션에서값을꺼내주는객체 = set.iterator();

    // 값을 꺼내주는 객체를 통해 값을 꺼낸다.
    while (컬렉션에서값을꺼내주는객체.hasNext()) {
      //꺼낼 데이터가 있다면 값을 꺼내달라고 명령한다.
      System.out.print(컬렉션에서값을꺼내주는객체.next() + " ");
    }
    System.out.println();

    Iterator<String> Hash = set.iterator();
    while (Hash.hasNext()) {
      System.out.print(Hash.next() + " ");
    }
    System.out.println();

    //Iterator를 사용하면 컬렉션의 종류와 상관없이 일관된 방식으로 값을 조회할 수 있다.
    //LinkedList
    LinkedList<String> list = new LinkedList<>();
    list.add("LinkedList1");
    list.add("LinkedList2");
    list.add("LinkedList3");
    list.add("LinkedList4");
    list.add("LinkedList5");

    Iterator<String> Linked = list.iterator();

    while (Linked.hasNext()) {
      System.out.print(Linked.next() + " ");
    }
    System.out.println();

    //Stack
    Stack<String> stack = new Stack<>();
    stack.push("Stack1");
    stack.push("Stack2");
    stack.push("Stack3");
    stack.push("Stack4");
    stack.push("Stack5");

    Iterator<String> Stack = stack.iterator();
    while (Stack.hasNext()) {
      System.out.print(Stack.next() + " ");
    }
    System.out.println();

    //ArrayDaque
    ArrayDeque<String> stack2 = new ArrayDeque<>();
    stack2.push("ArrayDeque1");
    stack2.push("ArrayDeque2");
    stack2.push("ArrayDeque3");
    stack2.push("ArrayDeque4");
    stack2.push("ArrayDeque5");

    Iterator<String> ArrayDeque = stack2.iterator();

    while (ArrayDeque.hasNext()) {
      System.out.print(ArrayDeque.next() + " ");
    }
    System.out.println();

    ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(100);
    queue.offer("ArrayBlocking1");
    queue.offer("ArrayBlocking2");
    queue.offer("ArrayBlocking3");
    queue.offer("ArrayBlocking4");
    queue.offer("ArrayBlocking5");

    Iterator<String> ArrayBlockingQueue = queue.iterator();

    while (ArrayBlockingQueue.hasNext()) {
      System.out.print(ArrayBlockingQueue.next() + " ");
    }
    System.out.println();
  }
}


