package immutable.address;
public class MemberMain2 {
    public static void main(String[] args) {
        ImmutableAddress seoul = new ImmutableAddress("seoul");
        MemberV2 mtak = new MemberV2("mtak", seoul);
        MemberV2 yeji = new MemberV2("yeji", seoul);

        System.out.println("mtak = " + mtak);
        System.out.println("yeji = " + yeji);

//        yeji.getAddress().setValue("busan"); //compile err

        yeji.setAddress(new ImmutableAddress("busan"));

        System.out.println("mtak = " + mtak);
        System.out.println("yeji = " + yeji);

    }
}

