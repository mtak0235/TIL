package poly.ex.pay0;

public class PayConfiguration {
    public static Pay getPay(String option) {
        Pay pay = new KaKaoPay();
        if (pay.isValid(option)) return pay;
        pay = new NaverPay();
        if (pay.isValid(option)) return pay;
        return new DefaultPay();
    }
}
