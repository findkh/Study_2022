package Data.ArrayList;
//java.util.ArrayList 사용법 - 추가, 변경, 삭제

import java.util.ArrayList;

public class study02 {
  public static void main(String[] args) {

    //1. 특정 타입의 목록을 다루고 싶으면, 타입 파라미터로 지정하면 된다.
    ArrayList<String> list = new ArrayList<>();
    list.add("hafa1");
    list.add("hafa2");
    list.add("hafa3");
    System.out.println(list);

    //2. ArrayList는 null을 추가하는 것을 허용한다.
    list.add(null);
    list.add("hafa4");
    System.out.println(list);

    //3. ArrayList는 같은 인스턴스를 중복해서 추가 할 수 있다.
    list.add("null");
    list.add("hafa1");
    list.add("hafa2");
    System.out.println(list);

    //4. remove(index)
    //-> 목록에서 해당 인덱스의 값을 삭제 한다.
    //   리턴 값은 삭제된 값이다.
    String s = list.remove(2);
    System.out.println(s);
    System.out.println(list);

    //5. add(index, value)
    //-> 해당 위치에 값을 삽입한다.
    list.add(2, "*inserthafa*");
    System.out.println(list);

    //6. set(index, value)
    //-> 해당 위치에 값을 변경한다.
    list.set(5, "*changehafa*");
    System.out.println(list);

    //7. get(index) 
    //-> 해당 위치의 값을 리턴한다.
    System.out.println(list.get(0));

    //8. 인덱스가 유효하지 않으면 
    //-> Exception in thread "main" java.lang.IndexOutOfBoundsException
    System.out.println(list.get(10));
  }
}
