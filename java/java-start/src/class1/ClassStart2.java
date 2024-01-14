package class1;

public class ClassStart2 {
    public static void main(String[] args) {
        String[] studentNames = {"mtak", "yeji"};
        int[] studentAges = {15, 16};
        int[] studentGrades = {90, 80};

        for (int i = 0; i < studentNames.length; i++) {
            System.out.println(String.format("이름:%s\t나이:%d\t성적:%d", studentNames[i], studentAges[i], studentGrades[i]));
        }

    }
}
