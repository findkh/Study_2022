package Data.ArrayList;
//목록 조회 : Iterator 사용

import java.util.ArrayList;
import java.util.Iterator;

public class study07 {
  public static void main(String[] args) {

    Member m1 = new Member("하파", 10);
    Member m2 = new Member("수달", 34);
    Member m3 = new Member("티즈", 30);

    ArrayList<Member> list = new ArrayList<>();
    list.add(m1);
    list.add(m2);
    list.add(m3);

    /*ArrayList의 값을 꺼내주는 일을 할 객체(Iterator)를 생성한다.
    Iterator는 반복할 수 있는 자료형이다. for문이나 while문과 같이 사용한다.
    안에 있는 자료를 하나씩 꺼내오고 모두다 꺼내면 종료한다.
     */
    Iterator<Member> iterator = list.iterator();

    while(iterator.hasNext()) { //hasNext() : 읽어 올 요소가 남아 있는지 확인한다. t/f를 return한다.
      Member m = iterator.next();
      System.out.printf("이름: %s, 나이: %d\n", m.name, m.age);
    }
  }
}
