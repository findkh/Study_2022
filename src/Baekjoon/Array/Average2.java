package Baekjoon.Array;

/*BAEKJOON 4344
문제
대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다. 당신은 그들에게 슬픈 진실을 알려줘야 한다.

입력
첫째 줄에는 테스트 케이스의 개수 C가 주어진다.
둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고, 이어서 N명의 점수가 주어진다. 
점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.

출력
각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.
 */

import java.util.Scanner;

public class Average2 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int c = in.nextInt(); //testcase의 숫자
    int[] arr;

    for(int i = 0; i < c; i++) {
      int student = in.nextInt();   //학생 수 
      arr = new int[student]; //학생의 수만큼 배열을 생성한다.

      double sum = 0; // 성적 합계

      // 성적 입력부분 
      for(int j = 0; j < student; j++) {
        int score = in.nextInt(); // 성적 입력 받는다.
        arr[j] = score;
        sum += score; // 성적 더한다.
      }

      double avg = (sum / student) ;
      double count = 0; // 평균 넘는 학생 수 카운트

      // 평균 넘는 학생 찾기
      for(int k = 0 ; k < student ; k++) {
        if(arr[k] > avg) {
          count++;
        }
      }

      System.out.printf("%.3f%%\n",(count/student)*100);
    }
    in.close();
  }
}
