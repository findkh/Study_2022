package java_Study;

public class java100_switch_Basic001 {
  public static void main(String args[]) {
    int age = 30;

    //switch 조건문
    //변수 조건은 정수형이어야 한다. byte, short, int 
    //long타입은 안된다.
    //chart 타입은 가능

    switch(age) {
      case 10 : 
        System.out.println(age + "대입니다");
        break;
      case 20 :
        System.out.println(age + "대입니다.");
        break;
      case 30 :
        System.out.println(age + "대입니다.");
        break;
      case 40 :
        System.out.println(age + "대입니다.");
        break;

    }
  }
}
