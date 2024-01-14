package construct1;

public class ConstructMain2 {
    public static void main(String[] args) {
        MemberContruct mtak = new MemberContruct("mtak", 15, 90);
        MemberContruct yehi = new MemberContruct("yehi", 15);
        MemberContruct[] members = {mtak, yehi};
        for (MemberContruct member : members) {
            System.out.println("member = " + member);
        }

    }
}
