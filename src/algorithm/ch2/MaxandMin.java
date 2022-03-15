package algorithm.ch2;

public class MaxandMin {
  public static void main(String[] args) {
    int[] a = {72, 68, 92, 88, 41, 53, 97, 84, 39, 55};
    int max = a[0];
    int min = a[0];

    //최대값
    for (int i = 1; i < a.length; i++) {
      if(max < a[i]) {
        max = a[i];
      }
    }

    //최소값
    for (int i = 1; i < a.length; i++) {
      if(min > a[i]) {
        min = a[i];
      }
    }
    System.out.printf("max는? %d, min은? %d\n", max, min);
  }
}
