package construct1;

public class MemberContruct {
    String name;
    int age;
    int grade;

    public MemberContruct(String name, int age) {
        this(name, age, 50);
//        this.name = name;
//        this.age = age;
//        this.age = 80;
    }

    @Override
    public String toString() {
        return "MemberContruct{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                '}';
    }

    public MemberContruct(String name, int age, int grade) {
        System.out.println("셍성자 호출");
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}
