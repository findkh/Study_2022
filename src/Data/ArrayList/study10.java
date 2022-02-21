package Data.ArrayList;
//목록 조회: 제네릭 적용

public class study10 {

  public static void main(String[] args) {
    Member m1 = new Member("하파", 10);
    Member m2 = new Member("수달", 34);
    Member m3 = new Member("티즈", 30);

    MyListGeneric<Member> list = new MyListGeneric<>();
    list.add(m1);
    list.add(m2);
    list.add(m3);
    //list.add(new String("안 돼!")); //컴파일 오류 
    //The method add(study10.Member) in the type study10.MyList<study10.Member> is not applicable for the arguments (String)
    //Member 클래스에 맞게 작성되어야된다.

    for (int i = 0; i < list.size(); i++) {
      Member m = list.get(i);
      System.out.printf("이름: %s, 나이: %d\n", m.name, m.age);
    }
  }
}
