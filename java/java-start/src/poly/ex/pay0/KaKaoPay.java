package poly.ex.pay0;

public class KaKaoPay implements Pay {
    private String option = "kakao";
    @Override
    public boolean pay(int amount) {
        System.out.println("카카오페이 시스템과 연결합니다.");
        System.out.println(amount + "원 결제를 시도합니다.");
        return true;
    }

    @Override
    public boolean isValid(String option) {
        return this.option.equals(option);
    }
}
