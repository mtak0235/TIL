package poly.ex.pay0;

public class NaverPay implements Pay {
    private static String option = "naver";
    @Override
    public boolean pay(int amount) {
        System.out.println("네이버페이 시스템과 연결합니다.");
        System.out.println(amount + "원 결제를 시도합니다.");
        return true;
    }

    @Override
    public boolean isValid(String option) {
        return this.option.equals(option);
    }
}
