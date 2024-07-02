import java.util.*;
public class Sort {
  public static void main(String[] str) {
    stream1();

  }

  private static void stream1() {
    int[] a = {1, 2, 3, 4, 5};
    Integer[] array = Arrays.stream(a)
                            .boxed()
                            .toArray(Integer[]::new);
    Arrays.sort(array, Collections.reverseOrder());
    for (Integer i : array) {
      System.out.println("i = " + i);
    }
  }

}
