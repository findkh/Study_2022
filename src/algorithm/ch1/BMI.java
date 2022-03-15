package algorithm.ch1;

import java.util.Scanner;

/*BMI를 구하는 프로그램
 * kg단위의 체중을 m 단위의 신장으로 2번 나누면 구할 수 있다. 
 * 22가 표준, 25이상은 비만, 18.5 미만은 마른 것으로 판정난다.
 */

public class BMI {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    double height = in.nextDouble();
    double weight = in.nextDouble();
    double bmi = weight / (height * height / 10000);

    if(bmi < 18.5) {
      System.out.println("마름");
    } else if (bmi <= 24.9) {
      System.out.println("정상");
    } else if (bmi >= 25){
      System.out.println("비만");
    }
    in.close();
  }
}
