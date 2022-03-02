package Data.LinkedList.createLinkedList;
//11단계 : 제네릭을 적용한다.

public class LinkedList02Test {
  public static void main(String[] args) {
    LinkedList02<String> list = new LinkedList02();

    list.add("000");
    list.add("111");
    list.add("222");
    list.add("333");

    System.out.println(list.get(0));
    System.out.println(list.get(1));
    System.out.println(list.get(2));
    System.out.println(list.get(3));
    //    System.out.println(list.get(-1)); //IndexOutOfBoundsException
    //    System.out.println(list.get(4)); //IndexOutOfBoundsException

    print(list); //000,111,222,333,

    System.out.println("---------------------");

    list.add(2,"aaa"); //000,111,aaa,222,333,
    list.add(0,"bbb"); //bbb,000,111,aaa,222,333,
    list.add(5,"ccc"); //bbb,000,111,aaa,222,ccc,333,
    list.add("ddd"); //bbb,000,111,aaa,222,ccc,333,ddd
    print(list);

    System.out.println("---------------------");

    System.out.println(list.remove(0));
    print(list);

    System.out.println(list.remove(2));
    print(list);

    System.out.println(list.remove(3));
    print(list);

    System.out.println(list.remove(4));
    print(list);

    System.out.println("---------------------");

    System.out.println(list.set(0, "xxx"));
    print(list);

    System.out.println(list.set(2, "yyy"));
    print(list);

    System.out.println("---------------------");

    print2(list.toArray());
  }

  static void print(LinkedList02 list) {
    for (int i = 0; i < list.size(); i++) {
      System.out.print(list.get(i) + ",");
    }
    System.out.println();
  }

  static void print2(Object[] arr) {
    for (Object obj : arr) {
      System.out.print(obj + ",");
    }
    System.out.println();
  }
}
