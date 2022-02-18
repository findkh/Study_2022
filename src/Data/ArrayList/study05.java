package Data.ArrayList;
//목록 조회 : 반목문과 인덱스를 이용하여 목록을 조회한다.

import java.util.ArrayList;

public class study05 {
  public static void main(String[] args) {
    Member m1 = new Member("하파", 10);
    Member m2 = new Member("수달", 34);
    Member m3 = new Member("티즈", 30);

    ArrayList<Member> list = new ArrayList<>();
    list.add(m1);
    list.add(m2);
    list.add(m3);

    for (int i = 0; i < list.size(); i++) {
      Member m = list.get(i);
      System.out.printf("이름: %s, 나이: %d\n", m.name, m.age);
    }
  }
}
