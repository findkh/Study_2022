package java_Study;
public class java100_variable_003 {
  public static void main(String[] args) {
    //자바의 Primitive Data Type의 크기를 출력하는 코드를 구현하시오
    //정수형 타입과 문자형 타입에 대해서만 구현
    //각 타입의 최댓값과 최소값도 같이 구하여 출력하라

    //byte, short, int, long, char
    System.out.printf("byte의 byte는? %d byte\n", Byte.BYTES);
    System.out.printf("byte의 사이즈는? %d bit\n", Byte.SIZE);
    System.out.printf("byte의 최댓값은? %d \n", Byte.MAX_VALUE);
    System.out.printf("byte의 최솟값은? %d \n", Byte.MIN_VALUE);
    System.out.println("-------------------------------------------");
    System.out.printf("short의 byte는? %d byte\n", Short.BYTES);
    System.out.printf("short의 사이즈는? %d bit\n", Short.SIZE);
    System.out.printf("short의 최댓값은? %d \n", Short.MAX_VALUE);
    System.out.printf("short의 최솟값은? %d \n", Short.MIN_VALUE);
    System.out.println("-------------------------------------------");
    System.out.printf("int의 byte는? %d byte\n", Integer.BYTES);
    System.out.printf("int의 사이즈는? %d bit\n", Integer.SIZE);
    System.out.printf("int의 최댓값은? %d \n", Integer.MAX_VALUE);
    System.out.printf("int의 최솟값은? %d \n", Integer.MIN_VALUE);
    System.out.println("-------------------------------------------");
    System.out.printf("long의 byte는? %d byte\n", Long.BYTES);
    System.out.printf("long의 사이즈는? %d bit\n", Long.SIZE);
    System.out.printf("long의 최댓값은? %d \n", Long.MAX_VALUE);
    System.out.printf("long의 최솟값은? %d \n", Long.MIN_VALUE);
    System.out.println("-------------------------------------------");
    System.out.printf("char의 byte는? %d byte\n", Character.BYTES);
    System.out.printf("char의 사이즈는? %d bit\n", Character.SIZE);
    System.out.printf("char의 최댓값은? %d \n", (int)Character.MAX_VALUE);
    System.out.printf("char의 최솟값은? %d \n", (int)Character.MIN_VALUE);
  }
}
