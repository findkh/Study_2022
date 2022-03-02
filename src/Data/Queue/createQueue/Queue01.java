package Data.Queue.createQueue;

import Data.LinkedList.createLinkedList.LinkedList05;

//1. Queue를 구현하기 위해 기존에 작성한 LinkedList를 상속받는다.
public class Queue01 extends LinkedList05 {

  //2. Queue에 값을 추가하는 offer(object)를 정의한다.
  public boolean offer(Object e) {
    return add(e);
  }

  //3. Queue에서 값을 꺼내는 poll()을 정의한다.
  public Object poll() {
    if (size() == 0) {
      return null;
    }
    return remove(0);
  }

  //4. Queue에서 제일 앞에 있는 값을 조회하는 peek()을 정의한다.
  public Object peek() {
    if (size() == 0) {
      return null;
    }
    return get(0);
  }
}
