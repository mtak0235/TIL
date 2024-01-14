package static2;

public class Car {
    private String model;
    private static int totalCnt;

    public Car(String model) {
        this.model = model;
        System.out.println(String.format("차량 구입, 이름:\t%s", model));
        totalCnt++;
    }

    public static void showTotalCars() {
        System.out.println("totalCnt = " + totalCnt);
    }
}
