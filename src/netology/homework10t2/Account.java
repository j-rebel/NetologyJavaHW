package netology.homework10t2;

public abstract class Account {
    private int balance;

    public Account(int balance) {
    }

    public abstract void pay(int amount);
    public abstract void transfer(Account account, int amount);
    public abstract void addMoney(int amount);
    public abstract int getBalance();
    public abstract void setBalance(int balance);
}
