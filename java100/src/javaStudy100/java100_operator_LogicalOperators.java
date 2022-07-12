public class java100_operator_LogicalOperators {
  public static void main(String args[]) {
    //논리연산자(&&), 이항연산자(||), 단항연산자(!)

    int a = 10, b=20, c=30;
    boolean rst1, rst2, rst3, rst4;

    rst1 = a < b && c > b;
    System.out.println(rst1);

    rst2 = a < b || c < b;
    System.out.println(rst2);

    rst3 = a > c || b != c;
    System.out.println(rst3);

    rst4 = !rst3;
    System.out.println(rst4);
    System.out.println(!rst4);
  }
}
