package loop;

public class WhileEx3 {
    public static void main(String[] args) {
        int max = 100;

        int i = 1;
        int sum = 0;
        while (i != max + 1) {
            sum += i;
            i++;
        }
        System.out.println("sum = " + sum);

        sum = 0;
        for (int j = 1; j < max + 1; j++) {
            sum += j;
        }
        System.out.println("sum = " + sum);
    }
}
