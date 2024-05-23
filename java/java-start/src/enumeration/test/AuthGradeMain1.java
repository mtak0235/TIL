package enumeration.test;

import enumeration.ref2.Grade;

public class AuthGradeMain1 {
    public static void main(String[] args) {
        for (AuthGrade value : AuthGrade.values()) {
            print(value);
        }
    }

    private static void print(AuthGrade grade) {
        System.out.printf("grade=%s,\tlevel=%d,\t설명=%s\n", grade.name(), grade.getLevel(), grade.getDescription());
    }
}
