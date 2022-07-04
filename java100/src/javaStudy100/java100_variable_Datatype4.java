package javaStudy100;

public class java100_variable_Datatype4 {
  public static void main(String args[]) {
    //기본형 타입 변수 선언과 동시에 값 입력
    byte b = 127;
    short s = 32767;
    int i = 2100000000;
    long l = 7000000000l;
    float f = 9.8f;
    double d = 3.14;
    char c = 'A';
    boolean bl = true;

    System.out.print("하파");
    System.out.println("헬로우"); //개행
    System.out.printf("%.2f \n", f); //.2 -> 소수점 2자리 나오게 출력
    System.out.printf("%.2f \n", d);

    //printf -> 지시자를 사용
    //10진수 10에 대해서 8진수, 16진수로 각각 출력해보시오. 
    /*
     %d : 정수(10진수)
     %o : 8진수
     %x : 16진수 
     %f : 소숫점
     %c : 문자
     %s : 문자열
     %b : boolean 형식
     %n or \n : 줄바꿈
     */
    int i2 = 10;
    System.out.printf("8진수는? %o \n", i2);
    System.out.printf("16진수는? %x \n", i2);

  }
}
