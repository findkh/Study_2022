package Data.ArrayList;
//목록 조회: java.util.Collection의 forEach() 사용법
import java.util.ArrayList;
import java.util.function.Consumer;

public class study08 {
  public static void main(String[] args) {
    Member m1 = new Member("하파", 10);
    Member m2 = new Member("수달", 34);
    Member m3 = new Member("티즈", 30);

    ArrayList<Member> list = new ArrayList<>();
    list.add(m1);
    list.add(m2);
    list.add(m3);

    //forEach() 메서드에게 넘길 객체는 Consumer 규칙에 따라 만들어야 한다.
    //List 보관된 객체를 반복문을 통해 꺼낼 때 마다 Consumer 규칙에 따라 accept()를 호출한다.
    class MyConsumer implements Consumer<Member> {

      @Override
      public void accept(Member m) {
        //forEach()에서 반복문을 돌릴 때 Consumer 규칙에 따라
        //각 항목에 대해 이 메서드를 호출한다.
        System.out.printf("이름: %s, 나이: %d\n", m.name, m.age);
      }
    }

    list.forEach(new MyConsumer());
    //list가 갖고 있는 목록에서 값을 꺼낼 때 마다 
    //파라미터로 넘겨주는 객체(MyConsumer)의 accept()를 호출하라는 뜻

    System.out.println("---------------------");

    Consumer<Member> action = new Consumer<>() {
      @Override
      public void accept(Member m) {
        System.out.printf("action 변수 사용 - 이름: %s, 나이: %d\n", m.name, m.age);
      }
    };

    list.forEach(action);

    System.out.println("---------------------");

    list.forEach(new Consumer<>() {
      @Override
      public void accept(Member m) {
        System.out.printf("forEach 파라미터로 바로 넘기기 - 이름: %s, 나이: %d\n", m.name, m.age);
      } 
    });

    System.out.println("---------------------");
    list.forEach(m -> System.out.printf("lamda 문법으로 Consumer 구현체 생성- 이름: %s, 나이: %d\n", m.name, m.age));


    System.out.println("---------------------");
    list.forEach(study08::printMember);
  }

  static void printMember(Member m) {
    System.out.printf("메서드 레퍼런스로 인터페이스 구현체 전달 - 이름: %s, 나이: %d\n", m.name, m.age);
  }
}
