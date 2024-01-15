package construct1;

public class MemberInitMain3 {
    public static void main(String[] args) {
        MemberInit memberInit = new MemberInit();
        memberInit.initMember("mtak", 15, 90);

        MemberInit memberInit1 = new MemberInit();
        memberInit1.initMember("yeji", 16, 80);

        MemberInit[] members = {memberInit, memberInit1};
        for (MemberInit member : members) {
            System.out.println("member = " + member);
        }
    }
}
