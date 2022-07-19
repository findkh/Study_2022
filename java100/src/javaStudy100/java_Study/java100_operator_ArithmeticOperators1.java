package java_Study;
public class java100_operator_ArithmeticOperators1 {
  public static void main(String args[]) {
    //수치 연산자 : +, -, *, /, %
    int a, b, c, d;
    a = 60;
    b = 8;
    c = 300;
    d = 400;

    System.out.printf("a + b = %d\n", a + b);
    //System.out.println("a + b=" + a+b); //괄호 안쳐주면 608 나옴
    System.out.printf("a - b = %d\n", a - b);
    System.out.printf("a * b = %d\n", a * b);
    System.out.printf("a / b = %d\n", a / b);
    System.out.println("a % b = " + (a % b));
    System.out.printf("a  b %d\n", a % b);

    int x = 10;
    int y = 8;
    System.out.printf("%d를 %d로 나누면, %d%n", x, y, x%y);
  }
}
