package immutable.change;

import immutable.address.ImmutableAddress;

public class ImmutableObj {
    private final int value;

    public ImmutableObj(int value) {
        this.value = value;
    }

    public ImmutableObj add(int value) {
        return new ImmutableObj(this.value + value);
    }
    public int getValue() {
        return value;
    }
}
