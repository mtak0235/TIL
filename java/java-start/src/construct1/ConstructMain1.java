package construct1;

public class ConstructMain1 {
    public static void main(String[] args) {
        MemberContruct mtak = new MemberContruct("mtak", 15, 90);
        MemberContruct yehi = new MemberContruct("yehi", 15, 65);
        MemberContruct[] members = {mtak, yehi};
        for (MemberContruct member : members) {
            System.out.println("member = " + member);
        }

    }
}
