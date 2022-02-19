package Data.ArrayList;
// 목록 조회: 반복문과 인덱스를 이용한 목록 조회

public class study09 {
  public static void main(String[] args) {
    Member m1 = new Member("하파", 10);
    Member m2 = new Member("수달", 34);
    Member m3 = new Member("티즈", 30);

    MyList list = new MyList();
    list.add(m1);
    list.add(m2);
    list.add(m3);


    for (int i = 0; i <list.size(); i++) {
      Member m = (Member) list.get(i);
      System.out.printf("이름: %s, 나이: %d\n", m.name, m.age);
    }
  }
}
