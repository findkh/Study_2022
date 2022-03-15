package algorithm.ch1;

import java.util.Scanner;

/* ﻿유클리드 호제법 - 최대공약수(the greatest common denominator = GCD)
﻿두 정수의 최대공약수(모두를 나눌 수 있는 최댓값)을 구하는 알고리즘이다.
1. 두 정수의 큰 쪽에서 작은 쪽을 빼는 것을 양쪽이 같아질 때까지 반복한다.
2. 같아진 값이 최대공약수가 된다.
 */
public class Euclidean {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int a = in.nextInt();
    int b = in.nextInt();
    in.close();

    /* 책에 나온 의사코드 보고 작성
    while (a != b) {
      if (a > b) {
        a = a - b;
      } else {
        b = b -a;
      }
    } 
    System.out.println(a); */

    System.out.println(eucd(a, b));

  }

  //메서드로 구현
  public static int eucd(int a, int b) {
    int result = a % b;
    if (result == 0) { //나머지 값이 0이라면 작은 숫자가 최대공약수
      return b;
    } else {
      return eucd(b, result); 
      //나머지가 0이상이면 재귀형태로 호출한다.
      //호출할 때 파라미터는 작은숫자와 나머지 값을 넣어서 넘겨준다.
    }
  }
}
