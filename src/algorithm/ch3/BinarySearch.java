package algorithm.ch3;

import java.util.Scanner;

/* 이진검색
정렬된 배열에서 원하는 데이터를 찾는 것이 이진 ㅌ검색이다.
전제 조건이 오름차순 또는 내림 차순 되어 있는 배열이 있어야 한다.

오름차순으로 정렬 되어 있을 때.
1. 배열의 중앙 요소를 확인한다.
    - 배열의 중앙 요소 값이 찾는 값과 같다면 인덱스를 표시하고 종료한다.
    - 찾는 값보다 크다면 검색 대상으로 앞쪽으로 좁힌다.
    - 찾는 값보다 작다면 검색 대상을 뒤쪽으로 좁힌다.
2. 검색 대상이 없어 질 때까지 처리를 반복한다.

이진검색의 반복문은 조건만 지정하므로 while문 사용한다.
 */

public class BinarySearch {
  public static void main(String[] args) {
    int [] a = {39, 41, 53, 55, 68, 72, 84, 88, 92, 97};
    Scanner in = new Scanner(System.in);

    int pos = -1;
    int left = 0;
    int right = a.length -1;
    int x = in.nextInt();

    while (pos == -1 && left <= right){
      int mid = (left + right) / 2;

      if(a[mid] == x) {
        pos = mid;
      } else if (a[mid] > x) {
        right = mid - 1;
      } else
        left = mid + 1;
    }
    System.out.println(pos);
    in.close();
  }
}
