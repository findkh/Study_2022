package Data.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

//HashMap과 Iterator
public class study10 {
  public static void main(String[] args) {
    HashMap<String,Member> map = new HashMap<>();
    map.put("s01", new Member("하파", 10));
    map.put("s02", new Member("고래", 20));
    map.put("s03", new Member("치타", 30));
    map.put("s04", new Member("수달", 5));
    map.put("s05", new Member("토끼", 40));

    Set<String> keys = map.keySet();
    //Set 객체를 통해 key를 꺼낼 때,
    //즉 keySet()을 호출할 때 모든 key를 미리 목록을 만들어 리턴하지 않는다.
    //그 순간의 HashSet에 있는 key를 꺼낸다.

    Iterator<String> 키를꺼내주는객체 = keys.iterator();

    //Iterator를 얻은 후에 새 값을 넣기
    map.put("s06", new Member("표범", 22));

    //Iterator 객체를 생성할 때,
    //현재 목록 객체(keys)를 바탕으로 생성한다.
    //따라서 Iterator를 생성한 후에 목록을 변경하면,
    //기존 목록에서 뽑은 Iterator는 무효한 객체가 된다.

    map.put("s06", new Member("표범", 22));
    map.remove("s01");

    //무효한 Iterator를 사용하면 실행오류가 발생한다.
    //    while(키를꺼내주는객체.hasNext()) {
    //      System.out.println(키를꺼내주는객체.next());
    //    }
    //Exception in thread "main" java.util.ConcurrentModificationException

    //해결책
    // - 값을 변경하면 다시 Iterator를 얻어야한다.
    // 키를 꺼내주는 객체 = keys.iterator();

    Iterator<String> 키를꺼내주는새객체 = keys.iterator();
    while(키를꺼내주는새객체.hasNext()) {
      System.out.println(키를꺼내주는새객체.next());
    }
  }
}
