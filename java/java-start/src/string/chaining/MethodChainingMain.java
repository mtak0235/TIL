package string.chaining;

public class MethodChainingMain {
    public static void main(String[] args) {
        ValueAdder a = new ValueAdder();
        a.add(1);
        a.add(2);
        a.add(3);
        System.out.println("a = " + a.getValue());

        ValueAdder adder = new ValueAdder();
        ValueAdder adder1 = adder.add(1);
        ValueAdder adder2 = adder1.add(2);
        ValueAdder adder3 = adder2.add(3);
        System.out.println("adder = " + adder.getValue());

        ValueAdder valueAdder = new ValueAdder();
        int result = valueAdder.add(1).add(2).add(3).getValue();
        System.out.println("result = " + result);

    }
}
