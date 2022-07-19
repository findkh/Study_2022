package java_Study;

public class java100_ {
  public static void main(String args[]) {
    //삼항 연산자를 이용하여 12시 보다 작으면 오전, 크면 오후를 출력
    int hour = 13;

    String time = hour < 12 ? "오전" : "오후";
    System.out.println(time);
  }
}
