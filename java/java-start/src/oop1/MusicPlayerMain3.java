package oop1;

public class MusicPlayerMain3 {
    public static void main(String[] args) {

        MusicPlayerData musicPlayerData = new MusicPlayerData();
        //on
        on(musicPlayerData);

        //loudly
        volumeUp(musicPlayerData);
        volumeUp(musicPlayerData);

        //lower
        volumeDown(musicPlayerData);
        //state
        showStatus(musicPlayerData);
        //off
        off(musicPlayerData);
    }

    private static void volumeUp(MusicPlayerData musicPlayerData) {
        musicPlayerData.volume++;
        System.out.println("음악 플레이어 볼륨:" + musicPlayerData.volume);
    }

    private static void volumeDown(MusicPlayerData musicPlayerData) {
        musicPlayerData.volume--;
        System.out.println("음악 플레이어 볼륨:" + musicPlayerData.volume);
    }

    private static void showStatus(MusicPlayerData musicPlayerData) {
        System.out.println("음악 플레이어 상태 확인");
        if (musicPlayerData.isOn) {
            System.out.println("음악 플레이어 ON, 볼륨:" + musicPlayerData.volume);
        } else {
            System.out.println("음악 플레이어 OFF");
        }
    }

    private static void off(MusicPlayerData musicPlayerData) {
        musicPlayerData.isOn = false;
        System.out.println("음악 플레이어 종료");
    }

    private static void on(MusicPlayerData musicPlayerData) {
        musicPlayerData.isOn = true;
        System.out.println("play");
    }

}
