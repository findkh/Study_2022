package Baekjoon.IoAndCalculation;
/*BAEKJOON 2588
문제
(세 자리 수) × (세 자리 수)는 다음과 같은 과정을 통하여 이루어진다.
               4 7 2 ---> (1)
               3 8 5 ---> (2)
       -------------
             2 3 6 0 ---> (3)
           3 7 7 6   ---> (4)
         1 4 1 6     ---> (5)
       -------------
         1 8 1 7 2 0 ---> (6)
(1)과 (2)위치에 들어갈 세 자리 자연수가 주어질 때
(3), (4), (5), (6)위치에 들어갈 값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 (1)의 위치에 들어갈 세 자리 자연수가, 둘째 줄에 (2)의 위치에 들어갈 세자리 자연수가 주어진다.

출력
첫째 줄부터 넷째 줄까지 차례대로 (3), (4), (5), (6)에 들어갈 값을 출력한다.
 */

// 1. charAt을 사용하기
//   -> charAt은 문자열의 인덱스 위치에 있는 문자 값을 반환한다.
//   -> charAt 사용 후 - '0'을 해주는 이유는 문자로 저장된 숫자가 아닌 숫자로 변환하기 위해 쓰인다.
//import java.util.Scanner;
//public class Multiple {
//  public static void main(String[] args) {
//    Scanner in = new Scanner(System.in);
//    int num = in.nextInt();
//    String num2 = in.next();
//    in.close();
//    System.out.println(num * (num2.charAt(2) - '0'));
//    System.out.println(num * (num2.charAt(1) - '0'));
//    System.out.println(num * (num2.charAt(0) - '0'));
//    System.out.println(num * Integer.parseInt(num2));
//  }
//}

import java.util.Scanner;
public class Multiple {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int num1 = in.nextInt();
    int num2 = in.nextInt();
    in.close();

    System.out.println(num1 * (num2 % 10));
    System.out.println(num1 * (num2 % 100 / 10));
    System.out.println(num1 * (num2 / 100));
    System.out.println(num1 * num2);
  }
}
