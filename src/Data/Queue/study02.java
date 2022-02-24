package Data.Queue;
//Queue 구현과 사용 : for( : ) 사용
import java.util.concurrent.ArrayBlockingQueue;

public class study02 {
  public static void main(String[] args) {
    String s1 = new String("111");
    String s2 = new String("222");
    String s3 = new String("333");
    String s4 = new String("444");
    String s5 = new String("555");
    String s6 = new String("666");

    ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);
    queue.offer(s1);
    queue.offer(s2);
    queue.offer(s3);
    queue.offer(s4);
    queue.offer(s5);

    for (String s : queue) {
      System.out.println(s);
    }
  }
}
