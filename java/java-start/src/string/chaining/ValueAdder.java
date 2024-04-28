package string.chaining;

import com.sun.jdi.Value;

public class ValueAdder {
    private int value;

    public ValueAdder add(int value) {
        this.value += value;
        return this;
    }

    @Override
    public String toString() {
        return "ValueAdder{" +
                "value=" + value +
                '}';
    }

    public int getValue() {
        return value;
    }
}
