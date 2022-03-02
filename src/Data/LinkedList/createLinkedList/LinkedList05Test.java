package Data.LinkedList.createLinkedList;
//Test : Object.clone()을 오버라이딩 - deep copy
public class LinkedList05Test {
  public static void main(String[] args) throws Exception{

    LinkedList05<String> list = new LinkedList05<>();

    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    list.add("ddd");

    print(list);
    System.out.println("-------------------------");

    LinkedList05<String> list2 = list.clone();
    list2.remove(1);
    print(list2);
    System.out.println("-------------------------");

    //원본 연결 리스트의 값을 출력하면?
    print(list);
    System.out.println("-------------------------");
  }

  static void print(LinkedList05<String> list) {
    for (int i = 0; i < list.size(); i++) {
      System.out.print(list.get(i) + ",");
    }
    System.out.println();
  }
}
