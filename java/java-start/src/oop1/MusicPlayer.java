package oop1;

public class MusicPlayer {
    int volume = 0;
    boolean isOn = false;
     void volumeUp() {
        volume++;
        System.out.println("음악 플레이어 볼륨:" + volume);
    }

     void volumeDown() {
        volume--;
        System.out.println("음악 플레이어 볼륨:" + volume);
    }

     void showStatus() {
        System.out.println("음악 플레이어 상태 확인");
        if (isOn) {
            System.out.println("음악 플레이어 ON, 볼륨:" + volume);
        } else {
            System.out.println("음악 플레이어 OFF");
        }
    }

     void off() {
        isOn = false;
        System.out.println("음악 플레이어 종료");
    }

    void on() {
        isOn = true;
        System.out.println("play");
    }
}
