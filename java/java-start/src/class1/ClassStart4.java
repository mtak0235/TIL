package class1;

public class ClassStart4 {
    public static void main(String[] args) {
        Student[] students = new Student[2];

        students[0] = new Student();
        students[0].name = "mtak";
        students[0].age = 15;
        students[0].grade = 90;

        Student student2 = new Student();
        student2.name = "yeji";
        student2.age = 16;
        student2.grade = 80;
        students[1] = student2;

        System.out.println(String.format("이름:%s\t나이:%d\t성적:%d", students[0].name, students[0].age, students[0].grade));
        System.out.println(String.format("이름:%s\t나이:%d\t성적:%d", students[1].name, students[1].age, students[1].grade));
    }
}
