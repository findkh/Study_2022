package Data.LinkedList.createLinkedList;
//Test : Object.clone()을 오버라이딩- shallow copy
public class LinkedList04Test {
  public static void main(String[] args) throws Exception{

    LinkedList04<String> list = new LinkedList04<>();

    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    list.add("ddd");

    print(list);
    System.out.println("-------------------------");

    LinkedList04<String> list2 = list.clone();
    list2.remove(1);
    print(list2);
    System.out.println("-------------------------");

    //원본 연결 리스트의 값을 출력하면?
    //print(list);
    //aaa,ccc,ddd,Exception in thread "main" java.lang.NullPointerException: 
    //Cannot read field "value" because "cursor" is null
  }

  static void print(LinkedList04<String> list) {
    for (int i = 0; i < list.size(); i++) {
      System.out.print(list.get(i) + ",");
    }
    System.out.println();
  }
}
