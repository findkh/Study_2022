package Baekjoon.Array;
/*BAEKJOON 2462
문제
9개의 서로 다른 자연수가 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 번째 수인지를 구하는 프로그램을 작성하시오.
예를 들어, 서로 다른 9개의 자연수
3, 29, 38, 12, 57, 74, 40, 85, 61
이 주어지면, 이들 중 최댓값은 85이고, 이 값은 8번째 수이다.

입력
첫째 줄부터 아홉 번째 줄까지 한 줄에 하나의 자연수가 주어진다. 주어지는 자연수는 100 보다 작다.

출력
첫째 줄에 최댓값을 출력하고, 둘째 줄에 최댓값이 몇 번째 수인지를 출력한다.
 */

import java.util.Scanner;

public class Max {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int[] arr = new int[9];
    int Max = 0;
    int index = 0;

    for(int i = 0; i < arr.length; i++) {
      arr[i] = in.nextInt();
    }
    in.close();

    for(int i = 0; i < arr.length; i++) {
      if(arr[i] > Max) {
        Max = arr[i];
        index = i+1;
      }
    }
    System.out.println(Max);
    System.out.println(index);
    // 처음 Max를 초기화할 때 arr[0]을 하고 두번 째 for문에서 i를 1부터 시작했더니 계속 틀렸다고 나왔다.
    // 결과는 동일한데... 이유를 모르겠다....
  }
}
