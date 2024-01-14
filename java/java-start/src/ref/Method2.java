package ref;

import ref.Student;

public class Method2 {
    public static void main(String[] args) {
        Student mtak = createStudent("mtak", 25, 95);

        System.out.println("mtak = " + mtak);
    }

    static Student createStudent(String name, int age, int grade) {
        Student student = new Student();
        student.name = name;
        student.age = age;
        student.grade = grade;
        return student;
    }
}
