package poly.ex.pay0;

public class PayService {
    private Pay pay;
    public void processPay(String option, int amount) {
        System.out.println("결제를 시작합니다: option=" + option + ", amount=" +
                amount);
        boolean result;
        pay = PayConfiguration.getPay(option);
        result = pay.pay(amount);
        if (result) {
            System.out.println("결제가 성공했습니다.");
        } else {
            System.out.println("결제가 실패했습니다.");
        }
    }
}
