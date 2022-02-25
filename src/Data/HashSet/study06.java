package Data.HashSet;
//HashSet과 사용자 정의 데이터 타입
import java.util.HashSet;

public class study06 {

  static class Member {
    String name;
    int age;

    public Member(String name, int age) {
      this.name = name;
      this.age = age;
    }

    @Override
    public String toString() {
      return "Member [name=" + name + ", age=" + age + "]";
    }
  }

  public static void main(String[] args) {
    Member m1 = new Member("하파", 10);
    Member m2 = new Member("수달", 34);
    Member m3 = new Member("달구", 35);
    Member m4 = new Member("티즈", 30);
    Member m5 = new Member("하파", 10); //중복데이터

    HashSet<Member> set = new HashSet<>();
    set.add(m1);
    set.add(m2);
    set.add(m3);
    set.add(m4);

    set.add(m5); //중복 데이터는 겹치지 않아야 한다.

    /* 하지만 출력해보면 중복 저장되어 있다.
     HashSet이 중복여부를 검사할 때 hashCode()와 equals()의 리턴값으로 판단한다.
     Member클래스에서 HashCode와 equals()를 오버라이딩 하지 않았기 때문에
     Object로부터 상속 받은 hashCode()와 equals()를 그대로 사용하였고,
     Object의 hashCode()는 인스턴스가 다르면 무조건 다른 해시값을 리턴한다.
     Object의 equals()는 인스턴스의 주소가 같은 지 검사한다.
     그래서 데이터가 같아도 인스턴스가 다르기 때문에 중복 데이터가 들어갔다.
     */

    System.out.println(set);
    System.out.println();
    System.out.println("m1 == m5 ? " + (m1 == m5));
    System.out.println("equals(): " + (m1.equals(m5)));
    System.out.println("hashCode() : " + m1.hashCode() +" " + m5.hashCode());
  }

}
