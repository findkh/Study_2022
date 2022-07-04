package javaStudy100;

public class java100_variable_Datatype1 {
  public static void main(String args[]) {
    int a;
    int b = 0; 
    int c = 90;
    double d;
    char e;
    a = 10;
    d = 10;
    e = 'A';
    System.out.println( a );
    System.out.println( b );
    System.out.println( c );
    System.out.println( d );
    System.out.println( e );

    int x, y, z = 900; //이렇게 초기화하면 z만 초기화된다.
    //System.out.println(x); //The local variable x may not have been initialized
    //System.out.println(y); //The local variable y may not have been initialized
    System.out.println(z);

    int f, g, h;
    f = 100;
    g = 200;
    h = 300;
    System.out.println(f);
    System.out.println(g);
    System.out.println(h);

    int x1=100, y1=200, z1=300;
    System.out.println(x1);
    System.out.println(y1);
    System.out.println(z1);

    //같은 문자열 변수 한번에 초기화 할 때
    String str1, str2, str3;
    str1 = str2 = str3 = "korea";
    System.out.println(str1);
    System.out.println(str2);
    System.out.println(str3);

    //같은 정수 한번에 초기화 
    int a1, a2, a3;
    a1 = a2 = a3 = 100;
    System.out.printf("a1=%d a2=%d a3=%d \n", a1, a2, a3);

  }
}
