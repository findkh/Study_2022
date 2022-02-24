package Data.HashSet;
//HashSet vs ArrayList

import java.util.ArrayList;

public class study02 {
  public static void main(String[] args) {

    ArrayList<String> list = new ArrayList<>();

    list.add("111");
    list.add("222");
    list.add("333");

    // ArrayList는 값을 중복해서 넣을 수 있다.
    list.add("111"); // 위에서 입력한 같은 인스턴스라도 중복 저장된다.
    list.add("222");

    list.add(null); //null을 여러번 넣을 수 있다.
    list.add(null);

    System.out.println(list);

  }
}
