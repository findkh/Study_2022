package algorithm.ch3;

import java.util.Scanner;

public class BinarySearchTrace {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int[] a = {39, 41, 53, 55, 68, 72, 84, 88, 92, 97};
    int x, pos, left, right, middle;

    System.out.printf("x = ");
    x = in.nextInt();
    pos = -1;
    left = 0;
    right = a.length -1;
    System.out.printf("반복 실행 전 : x = %d\n", x);
    System.out.printf("반복 실행 전 : pos = %d, left = %d, middle = ?, right = %d\n", pos, left, right);
    in.close();

    while (pos == -1 && left <= right) {
      middle = (left + right) / 2;

      if (a[middle] == x) {
        pos = middle;
      } else if (a[middle] > x) {
        right = middle -1;
      } else {
        left = middle + 1;
      }

      System.out.printf("반복 실행 중 : pos = %d, left = %d, middle = %d, right = %d\n", pos, left, middle, right);
    }
    System.out.printf("pos = %d\n", pos);
  }
}
