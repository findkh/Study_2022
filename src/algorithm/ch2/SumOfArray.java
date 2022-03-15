package algorithm.ch2;
/*선형검색
-> 임의의 배열에서 원하는 데이터를 찾는다.
반복문으로 배열을 처리하는 것이 기본!
 */

public class SumOfArray {
  public static void main(String[] args) {
    int[] a = {72, 68, 92, 88, 41, 53, 97, 84, 39, 55};
    int sum = 0;
    for(int i = 0; i < a.length; i++) {
      sum += a[i];
    }
    System.out.println(sum);
  }
}
