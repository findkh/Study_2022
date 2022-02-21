package Data.LinkedList;

import java.util.LinkedList;

public class study01 {
  public static void main(String[] args) {
    String s1 = new String("1.하파");
    String s2 = new String("2.하파");
    String s3 = new String("3.하파");
    String s4 = new String("4.하파");
    String s5 = new String("5.하파");

    LinkedList list = new LinkedList();
    list.add(s1);
    list.add(s2);
    list.add(s3);

    System.out.println(list.get(0));
    System.out.println(list.get(1));
    System.out.println(list.get(2));

    System.out.println("size : " + list.size());

    list.remove(1);
    print(list);

    list.add(s4);
    list.add(1, s5);
    print(list);

    list.add(0, s2);
    print(list);

    list.add(5, "6.하파");
    print(list);
  }


  static void print(LinkedList list) {
    for (int i = 0; i < list.size(); i++) {
      System.out.print(list.get(i) + ", ");
    }
    System.out.println();
  }
}
/*
ArrayList vs LinkedList
1. 메모리
ArrayList
-> 고정 크기를 갖는다.
크기를 초과하면 새로 배열을 만들어야 하기 때문에 메모리 낭비가 심하다.
기존 배열은 가비지가 되기 때문에 가비지가 과다 생상된다.

LinkedList
-> 값을 넣을 때마다 새 메모리가 추가되는 가변 크기를 가진다.
ArrayList보다 메모리 낭비가 적고 가비지를 덜 생상한다.

2. 속도
ArrayList
-> 배열의 특징 상 인덱스를 이용하여 특정 항목을 찾을 때 속도가 빠르다.
삭제할 때 이전 항목을 당겨와야 하기 때문에 속도가 느리다.
삽입할 떄 현제 항목을 다음 항목으로 이동해야 하기 때문에 속도가 느리다.

LinkedList
->인덱스를 이용하여 특정 항목을 찾을 떄 리스트의 처음부터 찾아야 하기 때문에 속도가 느리다.
삭제할 때 이전 항목과 다음 항목을 바로 연결하면 되기 때문에 속도가 빠르다.
삽입할 때 현재 항목과 다음 항목을 새 항목과 연결하면 되기 때문에 속도가 빠르다.
 */