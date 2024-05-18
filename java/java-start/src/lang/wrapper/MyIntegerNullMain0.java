package lang.wrapper;

public class MyIntegerNullMain0 {

  public static void main(String[] args) {
    int[] arr = {-1, 0, 1, 2, 3};

  }

  private static int findValue(int[] arr, int target) {
    for (int i : arr) {
      if (i == target) {
        return i;
      }
    }
    return -1;
  }
}
