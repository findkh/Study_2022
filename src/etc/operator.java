package etc;

public class operator {
  //문자열 비교
  public static void main(String[] args) {
    String str1 = "abc";
    String str2 = new String("abc");
    String[] strArr = {"abc", "ABC"};
    System.out.println(strArr[0] == str2);
    System.out.println(strArr[0].equals(str1));
    System.out.println(strArr[1].equals(str1));
    System.out.println(strArr[1].equalsIgnoreCase(str1));
    System.out.println(strArr[0] == "ABC");
  }
}
