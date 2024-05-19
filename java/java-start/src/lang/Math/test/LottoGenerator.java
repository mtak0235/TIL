package lang.Math.test;

import java.util.Random;

public class LottoGenerator {

    Random rand = new Random();

    public long[] generate(int count) {
        long[] arr = new long[count];

        for (int i = 0; i < count; i++) {
            long given = 0;
            do {
                given = rand.nextLong(45) + 1;
            }while (!isUnique(arr, given));
            arr[i] = given;
        }
        return arr;
    }

    private boolean isUnique(long[] arr, long given) {
        for (long l : arr) {
            if (l == given) {
                return false;
            }
        }
        return true;
    }
}
