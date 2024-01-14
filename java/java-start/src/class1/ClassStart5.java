package class1;

public class ClassStart5 {
    public static void main(String[] args) {

        Student student1 = new Student();
        student1.name = "mtak";
        student1.age = 15;
        student1.grade = 90;

        Student student2 = new Student();
        student2.name = "yeji";
        student2.age = 16;
        student2.grade = 80;
        Student[] students = new Student[]{student1, student2} ;

        for (Student student : students) {
            System.out.println(String.format("이름:%s\t나이:%d\t성적:%d", student.name, student.age, student.grade));
        }
    }
}
