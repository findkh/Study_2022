package Baekjoon.Function;

/* BAEKJOON 1065
문제
어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다. 
등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다. 
N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오. 

입력
첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.

출력
첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.
 */
import java.util.Scanner;

public class Sequence {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println(arithmetic_sequence(in.nextInt()));

    in.close();
  }

  public static int arithmetic_sequence(int num) {
    int cnt = 0; //한수 카운트

    if (num < 100) { // 1~9까지는 비교할 숫자가 없으므로 한수, 10~99까지도 공차는 존재하지만 비교할 숫자가 없으므로 한수!
      return num; //입력값을 그대로 리턴한다.
    } else {
      cnt = 99;
      if (num == 1000) { //예외처리
        num = 999;
      }

      for (int i = 100; i <= num; i++) {
        String[] numStr = Integer.toString(i).split("");
        if ((Integer.parseInt(numStr[1]) - Integer.parseInt(numStr[0])) == (Integer.parseInt(numStr[2])- Integer.parseInt(numStr[1]))) {
          cnt++;
        }
      }
    }
    return cnt;
  }
}
