package Baekjoon.Array;
/* BAEKJOON 10818
문제
N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다. 
둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다. 
모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.

출력
첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MaxMin {

  public static void main(String[] args) throws Exception {
    /*
    Scanner in = new Scanner(System.in);

    int N = in.nextInt();
    int[] arr = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = in.nextInt();
    }

    in.close();
    Arrays.sort(arr);
    System.out.println(arr[0] + " " + arr[N-1]);
     */

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(in.readLine());
    StringTokenizer st = new StringTokenizer(in.readLine(), " ");

    int[] arr = new int[N];

    for(int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);
    System.out.println(arr[0] + " " + arr[N-1]);

    in.close();
  }
}

//Arrays.sort()
//배열에 저장된 원소 값을 오름차순으로 정렬해주는 메소드이다.
//최소값은 배열의 0번째에 최댓값은 arr-1번지에 있다.