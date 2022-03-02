package Data.Queue.createQueue;



public class Queue01Test {
  public static void main(String[] args) {
    Queue01 queue = new Queue01();
    queue.offer("aaa");
    queue.offer("bbb");
    queue.offer("ccc");
    System.out.println(queue.peek());
    queue.offer("ddd");
    queue.offer("eee");
    print(queue);


    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.peek());
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.size());


  }
  static void print(Queue01 queue) {
    for (int i = 0; i < queue.size(); i++) {
      System.out.print(queue.get(i) + ",");
    }
    System.out.println();
  }
}
