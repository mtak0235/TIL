package construct1;

public class MemberInitMain1 {
    public static void main(String[] args) {
        MemberInit memberInit = new MemberInit();
        memberInit.name = "mtak";
        memberInit.age = 15;
        memberInit.grade = 90;

        MemberInit memberInit1 = new MemberInit();
        memberInit1.name = "yeji";
        memberInit1.age = 16;
        memberInit1.grade = 80;
        MemberInit[] members = {memberInit, memberInit1};
        for (MemberInit member : members) {
            System.out.println("member = " + member);
        }

    }
}
