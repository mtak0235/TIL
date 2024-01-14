package static2;

import static static2.DecoData.staticCall;
//import static static2.DecoData.*;

public class DecoDataMain {
    public static void main(String[] args) {
        System.out.println("정적 호출");
        DecoData.staticCall();
        staticCall();
        staticCall();
        staticCall();
        staticCall();

        System.out.println("동적 호출");
        DecoData decoData = new DecoData();
        decoData.instanceCall();

        System.out.println("동적 호출2");
        DecoData decoData1 = new DecoData();
        decoData1.instanceCall();

        staticCall(decoData);

        DecoData decoData2 = new DecoData();
        decoData2.staticCall();
        staticCall();
    }
}
