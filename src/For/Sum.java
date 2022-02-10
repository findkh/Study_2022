package For;
/*BAEKJUN 8393
문제 
n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.
(for 안써도 됨)

입력
첫째 줄에 n (1 ≤ n ≤ 10,000)이 주어진다.

출력
1부터 n까지 합을 출력한다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sum {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(in.readLine());
    int sum = 0;
    in.close();

    for(int i = 0; i <= num; i++) {
      sum += i;
    }
    System.out.println(sum);

    //System.out.println(factorial(num));
  }

  /*
  public static int factorial(int num) {
    if(num == 1) {
      return num;
    } else {
      return factorial(num - 1) * num;
    }
  }
   */
}