package access;

public class BankAccount {
    private int balance;

    public BankAccount() {
        balance = 0;
    }

    public void deposit(int amount) {
        if (isAmountValid(amount)) {
            balance += amount;
            System.out.println("ok");
            return ;
        }
        System.out.println("invalid cache");
    }

    public void withdraw(int amount) {
        if (isAmountValid(amount) && balance >= amount) {
            balance -= amount;
            System.out.println("ok");
            return;
        }
        System.out.println("invalid cache. short of leftover");
    }

    public int getBalance() {
        return balance;
    }

    private boolean isAmountValid(int amount) {
        return amount > 0;
    }
}
