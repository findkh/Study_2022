package Data.Queue.createQueue;

import Data.LinkedList.createLinkedList.LinkedList05;

//1. Queue를 구현하기 위해 기존에 작성한 LinkedList를 상속받는다.
//5. Queue.clone() 오버라이딩 : deep copy
//6. 제네릭 적용
public class Queue03<E> extends LinkedList05<E> {

  //2. Queue에 값을 추가하는 offer(object)를 정의한다.
  public boolean offer(E e) {
    return add(e);
  }

  //3. Queue에서 값을 꺼내는 poll()을 정의한다.
  public E poll() {
    if (size() == 0) {
      return null;
    }
    return remove(0);
  }

  //4. Queue에서 제일 앞에 있는 값을 조회하는 peek()을 정의한다.
  public E peek() {
    if (size() == 0) {
      return null;
    }
    return get(0);
  }

  @SuppressWarnings("unchecked")
  @Override
  public Queue03<E> clone() throws CloneNotSupportedException {
    Queue03<E> newQueue = new Queue03<>();
    Object[] values = this.toArray();
    for(Object value : values) {
      newQueue.offer((E) value);
    }
    return newQueue;
  }
}
