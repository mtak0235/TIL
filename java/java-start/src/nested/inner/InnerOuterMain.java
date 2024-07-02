package nested.inner;

public class InnerOuterMain {

  public static void main(String[] args) {
    InnerOuter innerOuter = new InnerOuter();
    InnerOuter.Inner inner = innerOuter.new Inner();
    inner.print();
    System.out.println(inner.getClass());
  }
}
