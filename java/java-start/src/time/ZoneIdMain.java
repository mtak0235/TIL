package time;

import java.time.ZoneId;
import java.util.Set;

public class ZoneIdMain {
    public static void main(String[] args) {
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        for (String availableZoneId : availableZoneIds) {
            ZoneId zoneId = ZoneId.of(availableZoneId);
            System.out.println("zoneId = " + zoneId + " " + zoneId.getRules());

        }
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println("zoneId = " + zoneId);
        ZoneId zoneId1 = ZoneId.of("Asia/Seoul");
        System.out.println("zoneId1 = " + zoneId1);
    }
}
