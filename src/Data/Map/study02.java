package Data.Map;

import java.util.HashMap;

public class study02 {
  public static void main(String[] args) {
    // 값을 저장할 때 String을 key로 많이 사용하지만,
    // 다른 어떤 객체라도 key로 사용할 수 있다.
    HashMap<Integer, Member> map = new HashMap<>();

    map.put(100, new Member("하파", 20));
    //100은 객체가 아니다. 그러나 auto-boxing을 통해 Integer 객체로 전환된다.

    map.put(200, new Member("고래", 30));
    map.put(300, new Member("사자", 14));
    map.put(400, new Member("토끼", 10));

    System.out.println(map.get(100));
    System.out.println(map.get(200));
    System.out.println(map.get(300));
    System.out.println(map.get(400));
  }

}
