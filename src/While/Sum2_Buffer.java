package While;
/*BAEKJUN 10951
문제
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

입력
입력은 여러 개의 테스트 케이스로 이루어져 있다.
각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)

출력
각 테스트 케이스마다 A+B를 출력한다.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Sum2_Buffer {

  public static void main(String[] args) throws Exception {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    String str;

    while((str = in.readLine()) != null) {

      st = new StringTokenizer(str, " ");
      int A = Integer.valueOf(st.nextToken());
      int B = Integer.valueOf(st.nextToken());
      out.write((A + B) + "\n");
    }
    in.close();
    out.flush();
    out.close();
  }
}
