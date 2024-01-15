package loop;

public class WhileEx2 {
    public static void main(String[] args) {
        int curr = 1;
        int evenNum = 0;
        while (evenNum != 10) {
            if (curr % 2 == 0) {
                System.out.println("curr = " + curr);
                evenNum++;
            }
            curr++;
        }
        evenNum = 0;
        for (int i = 1; evenNum != 10; i++) {
            if (i % 2 == 0) {
                System.out.println("i = " + i);
                evenNum++;
            }
            curr++;
        }
    }
}
