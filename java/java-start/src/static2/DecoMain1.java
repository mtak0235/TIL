package static2;

public class DecoMain1 {
    public static void main(String[] args) {
        String s = "hello mtak";
        DecoUtil1 decoUtil1 = new DecoUtil1();
        String deco = decoUtil1.deco(s);

        System.out.println("before = " + s);
        System.out.println("after = " + deco);
        DecoUtil1 decoUtil2= new DecoUtil1();
        String deco2 = decoUtil2.deco(s);
        System.out.println("before = " + s);
        System.out.println("after = " + deco2);
    }
}
