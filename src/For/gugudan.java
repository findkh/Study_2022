package For;
/* BAEKJOON 2739
문제
N을 입력받은 뒤, 구구단 N단을 출력하는 프로그램을 작성하시오. 출력 형식에 맞춰서 출력하면 된다.

입력
첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 9보다 작거나 같다.

출력
출력형식과 같게 N*1부터 N*9까지 출력한다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class gugudan {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(in.readLine());
    in.close();

    for (int j = 1; j <= 9; j++) {
      System.out.println(N + " " + "*" + " " + j + " " + "=" + " " + + (N * j));
    }
  }
}
