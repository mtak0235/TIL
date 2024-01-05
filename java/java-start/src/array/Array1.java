package array;

public class Array1 {
    public static void main(String[] args) {
        int[] students;
        students = new int[5];
        students[0] = 90;
        students[1] = 80;
        students[2] = 40;
        students[3] = 50;
        students[4] = 80;

        for (int i = 0; i < 5; i++) {
            System.out.println("학생"+ (i +  1) + "의 점수" + students[i]);
        }
    }
}
