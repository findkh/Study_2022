package java_Study;
public class java100_if_Basic003 {
  public static void main(String[] args) {
    // 변수 선언
    int kor=70, eng=70, math=70;
    int total_score;
    total_score = kor + eng + math;

    if (total_score >= 270) {
      System.out.println("total 점수는 " + total_score + "점 입니다.");
      System.out.println("잘했네1");
    } else if (total_score >= 240) {
      System.out.println("total 점수는 " + total_score + "점 입니다.");
      System.out.println("잘했네2");
    } else if (total_score >= 210) {
      System.out.println("total 점수는 " + total_score + "점 입니다.");
      System.out.println("잘했네3");
    } else {
      System.out.println("total 점수는 " + total_score + "점 입니다.");
      System.out.println("잘했네4");
    }
  }
}
