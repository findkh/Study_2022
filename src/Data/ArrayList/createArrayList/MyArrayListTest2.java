package Data.ArrayList.createArrayList;

public class MyArrayListTest2 {
  /*
   7) add()할 때 배열의 크기를 넘는 경우, 배열의 크기를 늘린다. 
   8) add(int,Object)로 임의의 위치에 삽입할 때
      - 배열의 크기가 작으면 늘린다.
      - 인덱스가 유효하지 않으면 예외를 발생시킨다. 
   9) get(int)으로 유효하지 않은 인덱스의 값을 꺼낼 때 예외를 발생시킨다. 
   10) remove()를 수행한 다음에 맨 끝에 남아 있는 주소를 null로 설정하여 인스턴스의 레퍼런스 카운트를 한 개 줄인다. 
   11) set()을 호출할 때 인덱스가 유효하지 않으면 예외를 발생시킨다.
   */

  public static void main(String[] args) {
    MyArrayList.add("aaa"); // aaa
    print();
    MyArrayList.add("bbb"); // aaa,bbb
    print();
    MyArrayList.add("ccc"); // aaa,bbb,ccc
    print();
    MyArrayList.add("ddd"); // aaa,bbb,ccc,ddd
    print();
    MyArrayList.add("eee"); // aaa,bbb,ccc,ddd,eee
    print();
    MyArrayList.add("fff"); // aaa,bbb,ccc,ddd,eee,fff
    print();
    MyArrayList.add("ggg"); // aaa,bbb,ccc,ddd,eee,fff,ggg
    print();
    MyArrayList.add("hhh"); // aaa,bbb,ccc,ddd,eee,fff,ggg,hhh
    print();

    MyArrayList.add(8, "iii"); // aaa,bbb,ccc,ddd,eee,fff,ggg,hhh,iii
    print();

    Object old = MyArrayList.remove(5); // aaa,bbb,ccc,ddd,eee,ggg,hhh,iii
    print();
    System.out.println(old);

    MyArrayList.set(7, "xxx");
    print();

    System.out.println(MyArrayList.get(7));

  }

  static void print() {
    for (int i = 0; i < MyArrayList.size; i++) {
      String str = (String) MyArrayList.get(i);
      System.out.print(str + ",");
    }
    System.out.println();
  }
}
