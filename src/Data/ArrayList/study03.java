package Data.ArrayList;

import java.util.ArrayList;

public class study03 {
  public static void main(String[] args) {

    class Member {
      String name;
      int age;

      public Member(String name, int age) {
        this.name = name;
        this.age = age;
      }

      //toString()을 오버라이딩 하지 않으면 해시코드 값이 출력된다
      @Override
      public String toString() {
        return "Member [name=" + name + ", age=" + age + "]";
      }

      @Override
      public boolean equals(Object obj) {
        if (this == obj)
          return true;
        if (obj == null)
          return false;
        if (getClass() != obj.getClass())
          return false;
        Member other = (Member) obj;
        if (age != other.age)
          return false;
        if (name == null) {
          if (other.name != null)
            return false;
        } else if (!name.equals(other.name))
          return false;
        return true;
      }
    }

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
