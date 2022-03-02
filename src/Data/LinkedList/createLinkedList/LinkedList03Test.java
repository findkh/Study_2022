package Data.LinkedList.createLinkedList;
//12단계 : toArray(E[]) 메서드 test

public class LinkedList03Test {
  public static void main(String[] args) {
    LinkedList03<String> list = new LinkedList03();

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

    //복사할 항목의 개수만큼 배열을 만들어 전달하면
    //ArrayList는 새 배열을 만들지 않고 우리가 준 배열에 값을 담아준다.
    String[] arr = new String[list.size()];
    String[] arr2 = list.toArray(arr);
    System.out.println(arr == arr2);
    print2(arr);

    System.out.println("---------------------");

    //복사할 항목의 개수보다 작은 크기의 배열을 주면
    //ArrayList는 새 배열을 만들어 값을 복사한 다음 리턴한다.
    arr = new String[3];
    arr2 = list.toArray(arr);
    System.out.println(arr == arr2);
    print2(arr2);

    System.out.println("---------------------");
    //복사할 항목의 개수 보다 작은 크기의 배열을 줄 때 보통 다음과 같이 코드를 작성한다.
    arr2 = list.toArray(new String[] {});
    print2(arr2);
  }

  static void print(LinkedList03 list) {
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
