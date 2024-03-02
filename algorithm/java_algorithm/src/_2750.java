import java.util.Scanner;

public class _2750 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = scanner.nextInt();
    }
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - 1 - i; j++) {
        if (a[j] > a[j + 1]) {
          int tmp = a[j];
          a[j] = a[j + 1];
          a[j + 1] = tmp;
        }
      }
    }
    for (int aa : a) {
      System.out.println(aa);
    }
  }

}
