package algorithm.ch2;

import java.util.Scanner;

/* 선형 검색(linear search) : 임의의 배열에서 원하는 데이터를 찾는 알고리즘
반복을 도중에 종료하는 방법
원하는 값이 발견되지 않았음을 나타내는 방법
 */


public class SequentialSearch {
  public static void main(String[] args) {
    int[] a = {72, 68, 92, 88, 41, 53, 97, 84, 39, 55};
    int pos = -1;

    Scanner in = new Scanner(System.in);
    System.out.println("X는?");
    int x = in.nextInt();
    in.close();

    for (int i = 0; i < a.length && pos == -1; i++) {
      if (a[i] == x) {
        pos = i;
      }
    }
    System.out.printf("pos = %d\n", pos);
  }
}
