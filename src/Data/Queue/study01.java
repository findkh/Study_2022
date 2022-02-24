package Data.Queue;
import java.util.concurrent.ArrayBlockingQueue;
/*Queue 구현과 사용
ArrayBlockingQueue는 Array로 구현되어 있다.
Queue의 크기가 정해져 있기 때문에 무한히 아이템을 추가할 수 없다.
추가되는 아이템은 순서가 있으며, FIFO 순서를 따른다.

 BlockingQueue는 Queue에서 아이템을 가져올 때 비어있으면 null을 리턴하지 않고 아이템이 추가될때까지 기다린다.
 반대로 아이템을 추가할 때 Queue가 가득차 있으면 공간이 생길 때까지 기다린다.

 ArrayBlockingQueue는 멀티 스레드 환경에서 사용하기 위해 구현되어 있으며 내부적으로 동시성에 안전하기 때문에 
 synchronized 구문 없이 사용해도 된다.

 정리
   - ArrayBlockingQueue는 BlockingQueue 인터페이스를 구현
   - Queue를 생성할 때 크기를 설정하며 내부적으로 배열을 사용하여 아이템을 저장
   - 동시성에 안전하여 멀티 쓰레드에서 synchronized 없이 사용 가능
   - 아이템을 꺼낼 때 비어 있으며 추가될 때까지 기다림.
   - 아이템을 추가할 때 Queue가 가득차 있으면 Exception이 발생하거나 일정 시간 기다릴 수 있음.

 */


public class study01 {
  public static void main(String[] args) {
    String s1 = new String("111");
    String s2 = new String("222");
    String s3 = new String("333");
    String s4 = new String("444");
    String s5 = new String("555");
    String s6 = new String("666");

    ArrayBlockingQueue queue = new ArrayBlockingQueue(10);

    /* offer()
     Queue가 full인 상태에서는 add()는 Exception을 발생시킨다.
     Exception을 발생시키고 싶지 않다면 offer()를 사용한다.
     */
    queue.offer(s1);
    queue.offer(s2);
    queue.offer(s3);
    System.out.println(queue.offer(s6)); //아이템이 추가 되면 true를 리턴한다. 추가 하지 못하면 false를 리턴한다.
    print(queue);

    //Queue : FIFO 방식으로 데이터를 꺼낸다. 111, 222, 333 이렇게 출력된다.
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.size()); // 데이터를 꺼내면 queue에 남지 않는다.
    print(queue);

    queue.offer(s4);
    queue.offer(s5);
    print(queue);

    System.out.println("--------------------");

    //queue에 남은 것들 모두 꺼냄
    String value;
    while ((value = (String) queue.poll()) != null) {
      System.out.println(value);
    }
    System.out.println(queue.size());
  }

  static void print(ArrayBlockingQueue queue) {
    Object[] arr = queue.toArray();
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + ", ");
    }
    System.out.println();
  }
}
