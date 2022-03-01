package Data.Map;
//java.util.HashMap - value 목록만 꺼내기
import java.util.Collection;
import java.util.HashMap;

public class study07 {
  public static void main(String[] args) {

    HashMap<String,Member> map = new HashMap<>();
    map.put("s01", new Member("하파", 10));
    map.put("s02", new Member("고래", 20));
    map.put("s03", new Member("치타", 30));
    map.put("s04", new Member("수달", 5));
    map.put("s05", new Member("토끼", 40));

    /* key 객체는 중복되어서는 안되기 때문에
     key 객체 목록은 Set에 담아서 리턴한다.
     value 객체는 중복 저장될 수 있기 때문에
     value 객체 목록은 Collection에 담아서 리턴한다.
     */

    Collection<Member>values = map.values();
    for (Member value : values) {
      System.out.println(value);
    }
  }
}
