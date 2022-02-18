package Baekjoon.Array;

import java.util.Scanner;

/*문제
"OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. 
O는 문제를 맞은 것이고, X는 문제를 틀린 것이다. 
문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다. 
예를 들어, 10번 문제의 점수는 3이 된다.
"OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.
OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.


입력
첫째 줄에 테스트 케이스의 개수가 주어진다. 
각 테스트 케이스는 한 줄로 이루어져 있고, 길이가 0보다 크고 80보다 작은 문자열이 주어진다. 
문자열은 O와 X만으로 이루어져 있다.

출력
각 테스트 케이스마다 점수를 출력한다.

 */

public class OX {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int N = Integer.parseInt(in.nextLine());

    String[] arrLen = new String[N]; //입력 받은 갯수대로 저장하는 배열

    //입력받은 값을 배열에 넣는다.
    for(int i = 0; i < N; i++) {
      arrLen[i] = in.nextLine();
    }

    for (int i = 0; i <arrLen.length; i++) {
      char[] answerList = arrLen[i].toCharArray(); //arrLen에 String으로 저장된 문자열을 Char배열로 만든다.
      int totalSum = 0;
      int point = 1;
      for (int j = 0; j < answerList.length; j++) { 
        if(answerList[j] == 'O') { //answerList의 요소를 꺼내 O라면
          totalSum += point; //totalSum에 point를 더하고
          point++; //연속되면 점수가 추가 되어야 하니까 point에 후위증감연산자를 사용한다.
        } else {//정답이 아니라면
          point = 1;//point를 1로 초기화한다.
        }
      }
      System.out.println(totalSum);
    }
    in.close();
  }
}

/*toCharArray
-> 스트링 문자열을 char 배열로 전환한다. 
리턴 값의 길이는 스트링의 길이이고 스트링이 나타내는 문자 순서를 포함하도록 내용이 초기화된다.
 */
