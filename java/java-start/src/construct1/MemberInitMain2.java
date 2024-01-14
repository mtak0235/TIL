package construct1;

public class MemberInitMain2 {
    public static void main(String[] args) {
        MemberInit memberInit = new MemberInit();
        initMember(memberInit, "mtak", 15, 90);

        MemberInit memberInit1 = new MemberInit();
        initMember(memberInit1, "yeji", 16, 80);

        MemberInit[] members = {memberInit, memberInit1};
        for (MemberInit member : members) {
            System.out.println("member = " + member);
        }
    }

    static void initMember(MemberInit member, String name, int age, int grade) {
        member.name = name;
        member.grade = grade;
        member.age = age;
    }
}
