package Data.Map;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

//java.util.HashMap - key/value 한쌍으로 묶어 꺼내기
public class study08 {
  public static void main(String[] args) {

    HashMap<String,Member> map = new HashMap<>();
    map.put("s01", new Member("하파", 10));
    map.put("s02", new Member("고래", 20));
    map.put("s03", new Member("치타", 30));
    map.put("s04", new Member("수달", 5));
    map.put("s05", new Member("토끼", 40));

    Set<Entry<String,Member>> entrySet = map.entrySet();
    // key, value가 한쌍으로 묶여 있는 객체들이 들어 있다.

    for (Entry<String,Member> entry : entrySet) {
      System.out.printf("%s ===> %s\n",
          entry.getKey(),
          entry.getValue());
    }
  }
}
