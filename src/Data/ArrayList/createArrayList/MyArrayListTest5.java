package Data.ArrayList.createArrayList;

public class MyArrayListTest5 {

  public static void main(String[] args) {

    //22) 제네릭을 적용한다. 
    //23) 파라미터로 받은 배열에 값을 채워주는 toArray(E[]) 메서드를 추가한다.

    MyArrayList<String> list1 = new MyArrayList<>();
    list1.add("aaa"); // aaa
    list1.add("bbb"); // aaa,bbb
    list1.add("ccc"); // aaa,bbb,ccc
    list1.add("ddd"); // aaa,bbb,ccc,ddd
    list1.add("eee"); // aaa,bbb,ccc,ddd,eee
    list1.add(1, "fff"); // aaa,fff,bbb,ccc,ddd,eee
    list1.set(3, "ggg"); // aaa,fff,bbb,ggg,ddd,eee
    System.out.println("==> " + list1.remove(2)); // // aaa,fff,ggg,ddd,eee
    print(list1);
  }

  static void print(MyArrayList<String> list) {
    for (int i = 0; i < list.size(); i++) {
      String str = list.get(i);
      System.out.print(str + ",");
    }
    System.out.println();
  }
}
