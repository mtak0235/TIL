package class1;

public class ClassStart3 {
    public static void main(String[] args) {
        Student student1;
        student1 = new Student();
        student1.name = "mtak";
        student1.age = 15;
        student1.grade = 90;
        Student student2;
        student2 = new Student();
        student2.name = "yeji";
        student2.age = 16;
        student2.grade = 80;
        System.out.println(String.format("이름:%s\t나이:%d\t성적:%d", student1.name, student1.age, student1.grade));
        System.out.println(String.format("이름:%s\t나이:%d\t성적:%d", student2.name, student2.age, student2.grade));
    }
}
