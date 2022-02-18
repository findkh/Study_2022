package Data.ArrayList;
//목록 조회 : toArray(), toArray(E()) 사용
/* 
API 해석(의역함)
Returns an array containing all of the elements in this listin proper sequence (from first to last element). 
이 목록의 처음부터 마지막 요소까지 모든 요소를 포함한 배열을 리턴한다.

The returned array will be "safe" in that no references to it aremaintained by this list. 
(In other words, this method must allocatea new array). 
The caller is thus free to modify the returned array.
반환된 배열은 이 목록에서 해당 배열에 대한 참조를 유지 하지 않는다는 점에서 안전하다.
다른말로 이 메서드는 반드시 새로운 배열로 재할당 해야 한다.
사용자는 그러므로 반환된 배열을 자유롭게 수정할 수 있다.

This method acts as bridge between array-based and collection-basedAPIs.
이 메서드는 배열기반 API와 컬렉션기반 API 사이의 다리 역할을 한다.*/

import java.util.ArrayList;

public class study06 {
  public static void main(String[] args) {

    Member m1 = new Member("하파", 10);
    Member m2 = new Member("수달", 34);
    Member m3 = new Member("티즈", 30);

    ArrayList<Member> list = new ArrayList<>();
    list.add(m1);
    list.add(m2);
    list.add(m3);

    Object[] arr = list.toArray(); //ArrayList를 배열로 변환 하는 것.
    for (Object obj : arr) {
      Member m = (Member) obj;
      System.out.printf("이름: %s, 나이: %d\n", m.name, m.age);
    }

    System.out.println();

    Member[] arr2 = list.toArray(new Member[list.size()]); //파라미터로 받은 배열
    for (Member m : arr2) {
      System.out.printf("이름: %s, 나이: %d\n", m.name, m.age);
    }

    System.out.println();

    Member[] arr3 = list.toArray(new Member[0]); //새로 배열을 만들어 리턴
    for (Member m : arr3) {
      System.out.printf("이름: %s, 나이: %d\n", m.name, m.age);
    }
  }
}
