package immutable.address;

public class MemberMain1 {
    public static void main(String[] args) {
        Address seoul = new Address("seoul");
        MemberV1 mtak = new MemberV1("mtak", seoul);
        MemberV1 yeji = new MemberV1("yeji", seoul);

        System.out.println("mtak = " + mtak);
        System.out.println("yeji = " + yeji);

//        yeji.getAddress().setValue("busan"); //side effect 발생

        System.out.println("mtak = " + mtak);
        System.out.println("yeji = " + yeji);

    }
}
