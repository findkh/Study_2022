package javaStudy100;

public class java100_variable_Datatype5 {
  public static void main(String args[]) {
    //정수형(int)을 문자열(String)로 변환하여 정수의 자릿수를 구하는 코드를 구현해보시오.  
    //정수 12345를 입력하면"자릿수가 "5"로 출력되도록 한다.

    int i = 12345;
    String str = Integer.toString(i); //문자열로 변환
    System.out.println(str.length());

    //정수형끼리 연산이 아닌 경우 문자가 합쳐지는 결과가 나올 수 있다.

    String str2 = "123";
    System.out.println(Integer.parseInt(str2) + Integer.parseInt(str2));

    int a = 12345;
    String str3 = String.valueOf(a); //문자열로 변환
    System.out.println(str3.length());
    System.out.println(str3 + str3);

    int a2 = Integer.valueOf(str3); //숫자로 변환
    System.out.println(a2 + a2);

    //    문자열 + 정수형
    System.out.println(12345 + "1");
  }
}
