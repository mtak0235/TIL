package array;


public class EnhancedFor1 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4};

        for (int n : numbers) {
            System.out.println("n = " + n);
        } //iter : shortcut
        System.out.println();

        int[] test = new int[10];
        for (int i : test) {
            System.out.println("i = " + i);
        }
    }
}
