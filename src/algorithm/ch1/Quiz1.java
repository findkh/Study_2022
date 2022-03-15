package algorithm.ch1;
import java.util.Scanner;

/* 최소공배수(the least common multiple = LCM)
최소 공배수를 구하는 알고리즘
-> 정수 2개를 곱해서 최대공약수로 나누면 구할 수 있다.
 */

public class Quiz1 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int a = in.nextInt();
    int b = in.nextInt();
    in.close();

    int gcd = eucd(a, b);
    int result = a * b / gcd;
    System.out.println(result);
  }

  public static int eucd(int a, int b) {
    int result = a % b;
    if (result == 0) { 
      return b;
    } else {
      return eucd(b, result); 
    }
  }
}
