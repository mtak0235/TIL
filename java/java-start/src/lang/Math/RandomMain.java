package lang.Math;

import java.util.Random;

public class RandomMain {
    public static void main(String[] args) {
//        Random random = new Random();
        Random random = new Random(1); //seed 같으면 Random 결과가 같다.
        int nextedInt = random.nextInt();
        System.out.println("nextedInt = " + nextedInt);
        double nextedDouble = random.nextDouble();
        System.out.println("nextedDouble = " + nextedDouble);
        boolean nextedBoolean = random.nextBoolean();
        System.out.println("nextedBoolean = " + nextedBoolean);
        int randomRange = random.nextInt(10);
        System.out.println("randomRange = " + randomRange);
        int randomRange1 = random.nextInt(10) + 1;
        System.out.println("randomRange1 = " + randomRange1);
    }

}
