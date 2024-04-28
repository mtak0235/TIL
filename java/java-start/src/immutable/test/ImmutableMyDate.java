package immutable.test;

public class ImmutableMyDate {
    private int year;
    private int month;
    private int day;

    public ImmutableMyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "MuDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    public ImmutableMyDate withDay(int day) {
        return new ImmutableMyDate(year, month, day);
    }
    public ImmutableMyDate withMonth(int month) {
        return new ImmutableMyDate(year, month, day);
    }

    public ImmutableMyDate withYear(int year) {
        return new ImmutableMyDate(year, month, day);
    }
}
