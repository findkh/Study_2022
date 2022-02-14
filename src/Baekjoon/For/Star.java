package Baekjoon.For;
/*
BAEKJOON 2438
문제
첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제

입력
첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.

출력
첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Star {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    int num = Integer.parseInt(in.readLine());

    for(int i = 1; i <= num; i++) {
      for(int j = 1; j <= i; j++) {
        out.write("*");
      }out.write("\n");
    }

    in.close();
    out.flush();
    out.close();
  }
}
