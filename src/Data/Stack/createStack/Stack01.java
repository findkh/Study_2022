package Data.Stack.createStack;

import java.util.EmptyStackException;
import Data.LinkedList.createLinkedList.LinkedList05;

//1. Stack을 구현하기 위해 기존에 작성된 LinkedList를 상속받는다.
public class Stack01 extends LinkedList05{

  //2. 스택에 값을 추가하는 push() 메서드를 정의한다.
  public Object push(Object item) {
    add(item);
    return item;
  }

  //3. 스택에서 제일 마지막에 추가한 값을 꺼내는 pop() 메서드를 정의한다.
  public Object pop() {
    if (size() == 0) {
      throw new EmptyStackException();
    }
    return remove(size() -1);
  }

  //4. 스택에서 제일 마지막에 입력한 값을 조회하는 peek()을 정의한다.
  public Object peek() {
    if (size() == 0) {
      throw new EmptyStackException();
    }
    return get(size() - 1);
  }

  //5. 스택이 비어있는지 알려주는 empty()를 정의한다.
  public boolean empty() {
    return size() == 0;
  }
}
