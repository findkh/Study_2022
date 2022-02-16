package Data.ArrayList;

import java.util.ArrayList;
import java.util.Date;

/*
자바 컬렉션 API(collection API)
-> 자바에서 데이터 목록을 다루는 클래스를 말한다.
java.util.Collection 인터페이스를 구현한 객체이다.

ArrayList
배열을 이용하여 객체 목록을 다룬다.
단점
-> 배열의 크기가 고정되기 때문에 배열을 초과하여 값을 넣으려면,
더 큰 새 배열의 크기가 늘 때마다 가비지(garbage)가 생기는 문제가 있다.
새 배열에 기존 배열의 값을 복사하기 때문에 속도가 느린 문제도 있다.
 */

public class study01 {
  public static void main(String[] args) {
    ArrayList list = new ArrayList();
    list.add("Hafa");
    list.add(10);
    list.add(Integer.valueOf(10));
    list.add(new Date());

    /*
    ArrayList는 제네릭이 적용되기 때문에 저장할 객체의 타입을 명확히 지정해야 한다.
    모든 종류의 인스턴스를 저장하고 싶으면 타입 파라미터에 Object를 지정한다.
     */

    ArrayList<Object> list2 = new ArrayList<>();
    list2.add("Hafa");
    list2.add(10);
    list2.add(Integer.valueOf(10));
    list2.add(new Date());
  }
}
