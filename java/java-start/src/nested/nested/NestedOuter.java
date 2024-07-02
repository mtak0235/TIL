package nested.nested;

public class NestedOuter {

  private static int outClassValue = 3;
  private int outInstanveValue = 2;
  static class Nested {

    private int nestedInstanceValue = 1;
    public void print() {
      System.out.println(nestedInstanceValue);

//      System.out.println(outInstanceValue); outer class instance member access forbidden
      System.out.println(outClassValue);//outter class member accessible
      System.out.println(NestedOuter.outClassValue);//even more, private, still accessible
    }
  }


}
