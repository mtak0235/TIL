package cond;

public class ScoreEx {
    public static void main(String[] args) {
        String status;
        int grade = 95;
        if (grade >= 90) status = "A";
        else if (grade >= 80) status = "B";
        else if (grade >= 70) status = "C";
        else if (grade >= 60) status = "D";
        else status = "F";
        System.out.println("status = " + status);
    }
}
