package algorithm.ch2;

import java.util.Scanner;

public class SequentialSearchTrace {
  public static void main(String[] args) {
    int[] a = {72, 68, 92, 88, 41, 53, 97, 84, 39, 55};
    int pos = -1;
    int i;

    Scanner in = new Scanner(System.in);
    System.out.println("X는?");
    int x = in.nextInt();
    System.out.println("반복실행전 x는?" + x);
    System.out.println("반복 실행 전: pos = " + pos);

    in.close();

    for (i = 0; i < a.length && pos == -1; i++) {
      if (a[i] == x) {
        pos = i;
      }
      System.out.printf("반복실행 중: pos = %d, i = %d\n", pos, i);
    }
    System.out.printf("pos = %d\n", pos);
    System.out.printf("반복 실행 후: pos = %d, i = %d\n", pos, i);
  }
}
