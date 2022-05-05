package Baekjoon.String;

import java.util.Scanner;

/* 11720번 숫자의 합
숫자의 합

문제
N개의 숫자가 공백 없이 쓰여 있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오

입력
첫째 줄에 숫자의 개수 N이 주어진다. 
둘째 줄에 숫자 N개가 공백 없이 주어진다.

출력
입력으로 주어진 숫자 N개의 합을 출력한다. 
 */

public class Sum {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int Nlength = in.nextInt();
    String number = in.next();
    in.close();
    int sum = 0;

    for (int i = 0; i < Nlength; i++) {
      sum += number.charAt(i)-'0';
    }
    System.out.println(sum);
  }
}
