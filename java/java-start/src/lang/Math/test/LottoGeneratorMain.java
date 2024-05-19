package lang.Math.test;

import java.util.Arrays;

public class LottoGeneratorMain {
    public static void main(String[] args) {
        LottoGenerator generator = new LottoGenerator();
        System.out.println("로또 번호:" + Arrays.toString(generator.generate(6)));
    }
}
