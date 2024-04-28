package lang.object.equals;

public class EqualsMain2 {
    public static void main(String[] args) {
        UserV2 mtak = new UserV2("mtak");
        UserV2 mtak2 = new UserV2("mtak");
        System.out.println("(mtak2==mtak) = " + (mtak2 == mtak));
        System.out.println("mtak2.equals(mtak) = " + mtak2.equals(mtak));
        
    }
}
