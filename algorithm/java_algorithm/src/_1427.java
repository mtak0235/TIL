import java.util.Scanner;

public class _1427 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String str = scanner.next();
    int[] a = new int[str.length()];
    for (int i = 0; i < str.length(); i++) {
      a[i] = Integer.parseInt(str.substring(i, i + 1));
    }
    for (int i = 0; i < str.length(); i++) {
      int max = i;
      for (int j = i + 1; j < str.length(); j++) {
        if (a[max] < a[j]) {
          max = j;
        }
      }
      if (a[max] > a[i]) {
        int tmp = a[i];
        a[i] = a[max];
        a[max] = tmp;
      }
    }
    for (int aa : a) {
      System.out.print(aa);
    }

  }

}
