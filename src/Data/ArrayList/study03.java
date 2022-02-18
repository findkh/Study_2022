package Data.ArrayList;
//java.util.ArrayList 사용법 - contains() 와 equals()의 관계
import java.util.ArrayList;

public class study03 {
  public static void main(String[] args) {
    Member m1 = new Member("하파", 20);
    Member m2 = new Member("수달", 34);
    Member m3 = new Member("티즈", 30);

    ArrayList<Member> list = new ArrayList<>();
    list.add(m1);
    list.add(m2);
    list.add(m3);
    System.out.println(list);

    // contains()
    //-> 해당 인스턴스와 같은 객체가 있는지 알아낸다.
    //   단, 인스턴스 주소를 비교하는 것이 아니라
    //   equals()의 결과가 true인지 비교한다.
    //   hashCode()의 리턴 값이 같을 필요는 없다.

    Member m4 = new Member("티즈", 30);
    System.out.println("contains? "+ list.contains(m4));

    System.out.println("==? "+ (m3 == m4));
    System.out.println("equals? " + m3.equals(m4));
    System.out.println("hashCode==? " + (m3.hashCode() == m4.hashCode()));

  }
}
