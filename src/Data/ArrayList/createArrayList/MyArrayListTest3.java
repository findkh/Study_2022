package Data.ArrayList.createArrayList;

public class MyArrayListTest3 {

  /*
   12) 여러 개의 목록을 동시에 관리할 수 있도록 MyArrayList에 선언된 레퍼런스 배열을 스태틱 대신 인스턴스로 전환한다.
        - 개별적으로 관리해야 할 데이터는 인스턴스 변수를 사용해야 한다. 
   13) 캡슐화 적용하여 공개할 멤버와 공개하지 말아야 할 멤버를 구분한다. 
   14) ArrayList 인스턴스를 생성할 때 배열의 초기 크기를 설정할 수 있도록 생성자를 추가한다. 
   15) ArrayList 인스턴스를 생성할 때 초기 크기를 지정하지 않고 생성할 수 있도록 기본 생성자를 추가한다. 
   16) 배열 크기를 지정할 때 기본 크기 보다 큰 값이 되도록 생성자를 변경한다. 
   17) 배열의 기본 크기를 직접 숫자로 지정하지 말고 상수를 사용하여 지정한다. 
   18) 배열의 크기를 늘릴 때 자바에서 제공하는 Arrays를 사용하여 처리한다. 
   19) 배열의 특정 항목을 삭제할 때 배열 복사 기능을 이용하여 처리한다. 
   20) ArrayList에 보관되어 있는 인스턴스 목록을 배열로 리턴하는 toArray() 메서드를 추가한다. 
   21) toArray()에서 배열을 복사할 때 Arrays.copyOf() 메서드를 활용한다.
   */

  public static void main(String[] args) {
    // aaa,bbb,ccc,ddd,eee
    MyArrayList list1 = new MyArrayList();
    list1.add("aaa");
    list1.add("bbb");
    list1.add("ccc");
    list1.add("ddd");
    list1.add("eee");
    list1.add("fff");
    list1.add("ggg");
    list1.remove(2); // aaa, bbb, ddd, eee, fff, ggg
    list1.remove(0); // bbb, ddd, eee, fff, ggg
    list1.remove(4); // bbb, ddd, eee, fff
    print2(list1);

    System.out.println("------------------------");

    // fff,ggg,hhh,iii
    MyArrayList list2 = new MyArrayList(1);
    list2.add("fff");
    list2.add("ggg");
    list2.add("hhh");
    list2.add("iii");
    list2.add("jjj");
    list2.add("kkk");
    list2.add("lll");
    print2(list2);




  }

  static void print(MyArrayList list) {
    for (int i = 0; i < list.size(); i++) {
      String str = (String) list.get(i);
      System.out.print(str + ",");
    }
    System.out.println();
  }

  static void print2(MyArrayList list) {
    Object[] arr;
    arr = list.toArray();
    for (Object obj : arr) {
      String str = (String) obj;
      System.out.print(str + ",");
    }
    System.out.println();
  }
}
