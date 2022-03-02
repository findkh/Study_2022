package Data.Queue.createQueue;


public class Queue03Test {
  public static void main(String[] args) throws Exception {
    Queue03<String> queue = new Queue03<>();
    queue.offer("aaa");
    queue.offer("bbb");
    queue.offer("ccc");
    queue.offer("ddd");
    queue.offer("eee");
    print(queue);
    System.out.println("-------------");

    Queue03<String> queue2 = queue.clone();
    queue2.poll();
    queue2.poll();
    print(queue2);
    System.out.println("-------------");

    print(queue);

  }

  static void print(Queue03<String> queue) {
    for (int i = 0; i < queue.size(); i++) {
      System.out.print(queue.get(i) + ",");
    }
    System.out.println();
  }
}
