package access;

public class Speaker {
    private int volume;

    public Speaker(int volume) {
        this.volume = volume;
    }

    void volumeUp() {
        if (volume >= 100) {
            System.out.println("too much");
        } else {
            volume += 10;
            System.out.println("ok");
        }
    }

    void volumeDown() {
        volume -= 10;
        System.out.println("ok");
    }

    void showVolume() {
        System.out.println(" current volume = " + volume);
    }
}
