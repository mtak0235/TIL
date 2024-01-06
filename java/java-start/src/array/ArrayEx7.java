package array;

import java.util.Scanner;

public class ArrayEx7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] reports = new int[4][3];
        String[] subjects = {"국어", "영어", "수학"};
        for (int i = 0; i < reports.length; i++) {
            System.out.println((i + 1) + "번 학생의 성적을 입력하세요:");
            for (int j = 0; j < 3; j++) {
                System.out.print(subjects[j]+" 점수:");
                reports[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < reports.length; i++) {
            int tot = 0;
            for (int j : reports[i]) {
                tot += j;
            }
            System.out.println((i + 1) + "번 학생의 총점:" + tot + ", 평균: " + (double)tot/reports[i].length);
        }
    }
}
