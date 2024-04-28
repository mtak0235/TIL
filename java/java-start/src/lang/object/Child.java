package lang.object;

public class Child extends Parent {//extends 없었으면 extends Object 자동으로 들어갔을거암
    public void childMethod() {
        System.out.println("Child.childMethod");
    }
}
