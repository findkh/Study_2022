package Data.HashSet;

import java.util.HashSet;

public class study05 {
  public static void main(String[] args) {
    HashSet<String> set = new HashSet<>();
    set.add("111");
    set.add("222");
    set.add("333");
    set.add("444");
    set.add("555");

    //Iterable 구현체라면 for( : )를 사용하여 값을 조회할 수 있다.
    for (String s : set) {
      System.out.print(s + " ");
    }
    System.out.println();
  }
}
