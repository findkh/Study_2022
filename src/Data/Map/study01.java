package Data.Map;

import java.util.HashMap;
/*java.util.Map 구현체
 *  HashMap, Hashtable이 있다.
 *  key를 가지고 value를 저장하고 꺼낸다.
 */

public class study01 {
  public static void main(String[] args) {
    HashMap<String,Member> map = new HashMap<>();

    //put(key, value) : 맵에 값 저장하기
    //  key 객체에 대해 hashCode()를 호출하여 정수 값을 얻는다.
    //  이 해시값을 가지고 저장할 위치를 결정한다.

    map.put("m01", new Member("하파", 20));
    /* 1. m01 String 객체에 대해 hashCode()를 호출하여 해시 값을 얻는다.
       2. 그 해시 값을 사용하여 저장할 위치를 결정한다.
       3. 해당 위치에 Member 객체의 주소를 저장한다.*/
    map.put("m02", new Member("수달", 30));
    map.put("m03", new Member("고래", 10));
    map.put("m04", new Member("사자", 50));

    map.put("m03", new Member("호랑이", 15));

    System.out.println(map.get("m01"));
    /*1. key 객체에 대해 hashCode()를 호출한다.
      2. hashCode()의 리턴 값을 가지고 데이터를 찾을 위치를 결정한다.
      3. 해당 위치에 있는 key 객체에 대해 equals()를 호출하여 리턴 값을 확인한다.
      4. equals()의 리턴 값이 true라면 같은 key로 간주하여 해당 위치의 값을 꺼낸다.*/
    System.out.println(map.get("m02"));
    System.out.println(map.get("m03"));
    System.out.println(map.get("m04"));


    System.out.println(map.get("m05"));
    //존재하지 않는 key를 지정하면 null을 리턴한다.

  }
}
