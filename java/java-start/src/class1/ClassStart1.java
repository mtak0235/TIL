package class1;

public class ClassStart1 {
    public static void main(String[] args) {
        String student1Name = "mtak";
        int student1Age = 15;
        int student1Grade = 90;
        String student2Name = "yeji";
        int student2Age = 16;
        int student2Grade = 80;

        System.out.println(String.format("이름:%s\t나이:%d\t성적:%d", student1Name, student1Age, student1Grade));
        System.out.println(String.format("이름:%s\t나이:%d\t성적:%d", student2Name, student2Age, student2Grade));
    }
}
