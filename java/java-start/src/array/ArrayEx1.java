package array;

public class ArrayEx1 {
    public static void main(String[] args) {
        int[] students = new int[5];
        int total = 0;
        for (int i = 0; i < students.length; i++) {
            students[i] = 90 - i * 10;
            total += students[i];
        }
        double average = (double) total / students.length;
        System.out.println("점수 총합: " + total);
        System.out.println("점수 평균:  " + average);
    }
}
