package access;

public class SpeakerMain {
    public static void main(String[] args) {
        Speaker speaker = new Speaker(40);
        speaker.showVolume();

        speaker.volumeUp();
        speaker.volumeDown();

        speaker.volumeUp();
        speaker.showVolume();

        //필드에 직접 접근
//        System.out.println("direct access");
//        speaker.volume = 200;
//        speaker.showVolume();

    }
}
