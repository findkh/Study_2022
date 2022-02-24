package Data.HashSet;

//java.util.HashSet 클래스 사용 - 값 꺼내기2
import java.util.HashSet;
import java.util.Iterator;

public class study04 {
  public static void main(String[] args) {

    HashSet<String> set = new HashSet<>();
    set.add("가가가");
    set.add("나나나");
    set.add("다다다");
    set.add("라라라");
    set.add("마마마");

    // Iterator - 창고에서 값을 꺼내준다.
    //  - HashSet에서 값을 꺼내주는 일을 하는 도우미 객체를 얻는다.
    Iterator<String> 컬렉션에서값을꺼내주는객체 = set.iterator();
  }
}
