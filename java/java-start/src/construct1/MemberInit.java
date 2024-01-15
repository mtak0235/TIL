package construct1;

public class MemberInit {
    String name;
    int age;
    int grade;

    @Override
    public String toString() {
        return "MemberInit{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                '}';
    }

    void initMember(String name, int age, int grade) {
        this.name = name;
        this.grade = grade;
        this.age = age;
    }
}
