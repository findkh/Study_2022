public class java100_if_Basic004 {
  public static void main(String[] args) {
    // 변수 선언
    int kor=30, eng=30, math=90;
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
    }

    //else 없어도 실행됨

    else 
      if( total_score >= 180 ) 
        System.out.println( "매우 노력하세요. 재수강 대상자는 아닙니다." );
      else 
        System.out.println( "매우 노력하세요. 재수강 대상자입니다." );
  }
}
