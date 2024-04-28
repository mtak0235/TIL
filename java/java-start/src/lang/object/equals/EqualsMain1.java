package lang.object.equals;

public class EqualsMain1 {
    public static void main(String[] args) {
        UserV1 user1 = new UserV1("mtak");
        UserV1 user2 = new UserV1("mtak");
        System.out.println("user2==user1 = " + (user2 == user1));
        System.out.println("user2.equals(user1) = " + user2.equals(user1));


    }
}
