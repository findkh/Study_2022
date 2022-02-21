package Data.ArrayList;
//목록 조회 : toArray() , toArray(E[])

public class study11 {
  public static void main(String[] args) {
    Member m1 = new Member("하파", 10);
    Member m2 = new Member("수달", 34);
    Member m3 = new Member("티즈", 30);

    //toArray() 사용
    MyListGeneric<Member> list = new MyListGeneric<>();
    list.add(m1);
    list.add(m2);
    list.add(m3);

    Object[] arr = list.toArray();

    for (Object obj : arr) {
      Member m = (Member) obj;
      System.out.printf("이름: %s, 나이: %d\n", m.name, m.age);
    }

    System.out.println("------------------------");

    //toArray(E[])

    MyListGeneric<Member> list2 = new MyListGeneric<>();
    list2.add(m1);
    list2.add(m2);
    list2.add(m3);

    Member[] arr2 = list2.toArray(new Member[list2.size()]);

    for (Member m : arr2) {
      System.out.printf("이름: %s, 나이: %d\n", m.name, m.age);
    }

  }
}
