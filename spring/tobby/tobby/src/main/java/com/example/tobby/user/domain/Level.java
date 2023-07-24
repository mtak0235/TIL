package com.example.tobby.user.domain;

public enum Level {
    BASIC(1), SILVER(2), GOLD(3);
    private final int value;

    public int intValue() {
        return value;
    }

    Level(int value) {
        this.value = value;
    }

    public static Level valueOf(int value) {
        return switch (value) {
            case 1 -> BASIC;
            case 2 -> SILVER;
            case 3 -> GOLD;
            default -> throw new AssertionError("Unknown value: " + value);
        };
    }
}
