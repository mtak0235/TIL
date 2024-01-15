package loop;

public class WhileEx1 {
    public static void main(String[] args) {
        int count = 1;
        while (count <= 10) {
            System.out.println("count = " + count);
            count++;
        }
        for (int j = 1; j <= 10; j++) {
            System.out.println("j = " + j);
        }
    }
}
