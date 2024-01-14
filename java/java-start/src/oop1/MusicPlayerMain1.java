package oop1;

public class MusicPlayerMain1 {
    public static void main(String[] args) {
        int volume =0;
        boolean isOn = false;

        //1. on
        isOn = true;
        System.out.println("play");

        //2. loudly
        volume++;
        System.out.println("음악 플레이어 볼륨:" + volume);
        //3. loudly
        volume++;
        System.out.println("음악 플레이어 볼륨:" + volume);
        //4. lower
        volume--;
        System.out.println("음악 플레이어 볼륨:" + volume);
        //5. state
        System.out.println("음악 플레이어 상태 확인");
        if (isOn) {
            System.out.println("음악 플레이어 ON, 볼륨:" + volume);
        } else {
            System.out.println("음악 플레이어 OFF");
        }
        //6. off
        isOn = false;
        System.out.println("음악 플레이어 종료");
    }

}
