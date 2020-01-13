package netology.homework10t2.accountTypes;

import netology.homework10t2.Account;

public class CheckingAccount extends Account {

    private int balance = 0;

    public CheckingAccount(int balance) {
        super(balance);
        if (balance >= 0) {
            this.balance = balance;
            System.out.println("Создаем расчетный счет с балансом " + this.balance);
        } else {
            System.out.println("Расчетный счет не может уходить в минус!");
        }
    }


    @Override
    public void pay(int amount) {
        if ((this.getBalance() - amount) >= 0) {
            this.setBalance(this.getBalance() - amount);
        } else {
            System.out.println("Расчетный счет не может уходить в минус!");
        }
    }

    @Override
    public void transfer(Account account, int amount) {
        if ((this.getBalance() - amount) >= 0) {
            this.setBalance(this.getBalance() - amount);
            account.setBalance(account.getBalance() + amount);
        } else {
            System.out.println("Расчетный счет не может уходить в минус!");
        }
    }

    @Override
    public void addMoney(int amount) {
        this.setBalance(this.getBalance() + amount);
    }

    @Override
    public int getBalance() {
        return this.balance;
    }

    @Override
    public void setBalance(int balance) {
        this.balance = balance;
    }
}
