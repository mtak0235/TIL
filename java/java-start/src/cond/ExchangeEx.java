package cond;

public class ExchangeEx {
    public static void main(String[] args) {
        int dollar = 100;
        int rate = 1300;
        int won;
        if (dollar < 0) {
            System.out.println("잘못된 금액이다.");
        } else if (dollar == 0) {
            System.out.println("환전할 금액이 없습니다.");
        } else {
            won = dollar * rate;
            System.out.println("won = " + won);
        }
    }
}
