package Baekjoon.While;
/*BAEKJUN 10951
문제
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

입력
입력은 여러 개의 테스트 케이스로 이루어져 있다.
각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)

출력
각 테스트 케이스마다 A+B를 출력한다.
 */

import java.util.Scanner;

public class Sum2_Scanner {

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);

    while(in.hasNext()) {
      /*Returns true if this scanner has another token in its input.
This method may block while waiting for input to scan.
The scanner does not advance past any input.
-> 입력에 다른 토큰이 있으면 true를 반환한다. 이 메서드는 입력을 기다리는 동안 차단될 수 있다.
       */
      int A = in.nextInt();
      int B = in.nextInt();
      System.out.println(A+B);
    }
    in.close();
  }
}
