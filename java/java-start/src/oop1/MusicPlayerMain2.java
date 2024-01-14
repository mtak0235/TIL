package oop1;

public class MusicPlayerMain2 {
    public static void main(String[] args) {

        MusicPlayerData musicPlayerData = new MusicPlayerData();
        //on
        musicPlayerData.isOn = true;
        System.out.println("play");

        //loudly
        musicPlayerData.volume++;
        System.out.println("음악 플레이어 볼륨:" + musicPlayerData.volume);

        musicPlayerData.volume++;
        System.out.println("음악 플레이어 볼륨:" + musicPlayerData.volume);

        //lower
        musicPlayerData.volume--;
        System.out.println("음악 플레이어 볼륨:" + musicPlayerData.volume);

        //state
        System.out.println("음악 플레이어 상태 확인");
        if (musicPlayerData.isOn) {
            System.out.println("음악 플레이어 ON, 볼륨:" + musicPlayerData.volume);
        } else {
            System.out.println("음악 플레이어 OFF");
        }

        //off
        musicPlayerData.isOn = false;
        System.out.println("음악 플레이어 종료");
    }

}
