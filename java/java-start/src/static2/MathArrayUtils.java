package static2;

public class MathArrayUtils {
    private MathArrayUtils() {
    }

    public static int sum(int[] array) {
        int ret = 0;
        for (int i : array) {
            ret += i;
        }
        return ret;
    }

    public static double average(int[] array) {
        int sum = sum(array);
        return (double) sum / array.length;
    }

    public static int min(int[] array) {
        int ret = array[0];
        for (int i : array) {
            if (ret > i) {
                ret = i;
            }
        }
        return ret;
    }

    public static int max(int[] array) {
        int ret = array[0];
        for (int i : array) {
            if (ret < i) {
                ret = i;
            }
        }
        return ret;
    }
}
