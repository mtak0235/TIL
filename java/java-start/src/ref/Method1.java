package ref;

public class Method1 {
    public static void main(String[] args) {

        Student mtak = new Student();
        initStudent(mtak, "mtak", 25, 54);
        Student yeji = new Student("yeji", 23, 89);
        System.out.println("mtak = " + mtak);
        System.out.println("yeji = " + yeji);
    }

    static Student initStudent(Student student, String name, int age, int grade) {
        student.name = name;
        student.age = age;
        student.grade = grade;
        return student;
    }
}
