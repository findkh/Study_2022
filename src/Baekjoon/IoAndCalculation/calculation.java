package Baekjoon.IoAndCalculation;
//BAEKJOON 1000 1001 10998 1008

import java.util.Scanner;
public class calculation {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    double a = in.nextDouble();
    double b = in.nextDouble();
    double result;

    if(a > 0 && b < 10) {
      result = a / b;
      System.out.println(result);
    }
    in.close();
  }
}
