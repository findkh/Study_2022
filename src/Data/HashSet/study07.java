package Data.HashSet;

import java.util.HashSet;
import java.util.Objects;

//HashSet과 사용자 정의 데이터 타입 - hashCode()와 equals() 오버라이딩
public class study07 {

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

    @Override
    public int hashCode() {
      return Objects.hash(age, name);
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (obj == null) {
        return false;
      }
      if (getClass() != obj.getClass()) {
        return false;
      }
      Member other = (Member) obj;
      return age == other.age && Objects.equals(name, other.name);
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

    System.out.println(set);
    System.out.println();
    System.out.println("m1 == m5 ? " + (m1 == m5));
    System.out.println("equals(): " + (m1.equals(m5)));
    System.out.println("hashCode() : " + m1.hashCode() +" " + m5.hashCode());
  }
}
