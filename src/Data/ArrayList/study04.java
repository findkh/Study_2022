package Data.ArrayList;
//java.util.ArrayList의 indexOf()

import java.util.ArrayList;

public class study04 {

  public static void main(String[] args) {

    Member m1 = new Member("고양이", 9);
    Member m2 = new Member("코냥이", 10);
    Member m3 = new Member("하파", 10);

    ArrayList<Member> list = new ArrayList<>();
    list.add(m1);
    list.add(m2);
    list.add(m3);
    System.out.println(list);

    Member m4 = new Member("하파", 10);
    System.out.println(list.indexOf(m4));
    /*indexOf(값)
    목록에 같은 값을 가진 객체의 인덱스를 알아낸다.
    값을 비교할때는 contains()와 마찬가지로 equals()의 리턴 값이 true인 경우 같은 값으로 간주한다.
     */

    System.out.println(m2 == m4);
    System.out.println(m2.equals(m4));
    System.out.println(m2.hashCode() == m4.hashCode());

  }

}
