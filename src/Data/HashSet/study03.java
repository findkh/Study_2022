package Data.HashSet;
//java.util.HashSet 클래스 사용 - 값 꺼내기1

import java.util.HashSet;

public class study03 {
  public static void main(String[] args) {

    HashSet<String> set = new HashSet<>();
    set.add("가가가");
    set.add("나나나");
    set.add("다다다");
    set.add("라라라");
    set.add("마마마");
    set.add("바바바");

    System.out.println(set);
    //저장한 순서대로 꺼낼 수 없기 때문에 index를 이용하여 값을 꺼낼 수 없다.
    // get(0) -> get 메서드도 없다.

    System.out.println("--------------");

    //값을 꺼내는 방법
    //1. HashSet에 들어 있는 값을 배열로 받아 사용한다.
    Object[] values = set.toArray();
    for (Object value : values) {
      System.out.print(value + " ");
    }
    System.out.println();
    System.out.println("--------------");

    //2. 입력한 값의 타입으로 배열을 만들고 싶다면 입력한 값의 타입으로 배열을 만들어 파라미터를 넘긴다.
    String[] arr2 = new String[set.size()];
    set.toArray(arr2);
    for (String value : arr2) {
      System.out.print(value + " ");
    }
    System.out.println();
    System.out.println("--------------");

    //3. 입력한 값의 타입으로 배열을 받으려면,
    // 배열의 크기가 작다면 내부에서 배열을 만들어 리턴해 준다.
    String[] arr3 = set.toArray(new String[0]);

    for (String value : arr3) {
      System.out.print(value + " ");
    }
    System.out.println();
    System.out.println("--------------");

  }
}


