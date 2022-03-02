package Data.Queue.createQueue;


public class Queue02Test {
  public static void main(String[] args) throws Exception {
    Queue02 queue = new Queue02();
    queue.offer("aaa");
    queue.offer("bbb");
    queue.offer("ccc");
    queue.offer("ddd");
    queue.offer("eee");
    print(queue);
    System.out.println("-------------");

    Queue02 queue2 = queue.clone();
    queue2.poll();
    queue2.poll();
    print(queue2);
    System.out.println("-------------");

    print(queue);
    System.out.println("-------------");
  }
  static void print(Queue02 queue) {
    for (int i = 0; i < queue.size(); i++) {
      System.out.print(queue.get(i) + ",");
    }
    System.out.println();
  }
}
