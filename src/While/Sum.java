package While;
/*BAEKJUN 10952
문제
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

입력
입력은 여러 개의 테스트 케이스로 이루어져 있다.
각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
입력의 마지막에는 0 두 개가 들어온다.

출력
각 테스트 케이스마다 A+B를 출력한다.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Sum {
  public static void main(String[] args) throws Exception {
    /*    Scanner in = new Scanner(System.in);

    while(true) {
      int A = in.nextInt();
      int B = in.nextInt();
      if(A==0 & B==0) {
        break;
      }
      System.out.println(A+B);
    }
    in.close();*/

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    while(true) {
      StringTokenizer st = new StringTokenizer(in.readLine(), " ");
      int A = Integer.valueOf(st.nextToken());
      int B = Integer.valueOf(st.nextToken());
      if(A==0 & B==0) {
        break;
      }
      out.write((A + B) + "\n");
    }
    in.close();
    out.flush();
    out.close();
  }
}
