package netology.homework10t2.accountTypes;

import netology.homework10t2.Account;

public class CreditAccount extends Account {

    private int balance = 0;

    public CreditAccount(int balance) {
        super(balance);
        if (balance >= 0) {
            this.balance = balance * -1;
            System.out.println("Создаем кредитный счет с балансом " + this.balance);
        } else {
            System.out.println("Кредитный счет не может уходить в плюс!");
        }
    }


    @Override
    public void pay(int amount) {
        if (this.getBalance() - amount <= 0) {
            this.setBalance(this.getBalance() - amount);
        } else {
            System.out.println("Кредитный счет не может уходить в плюс!");
        }
    }

    @Override
    public void transfer(Account account, int amount) {
        if (this.getBalance() - amount <= 0) {
            this.setBalance(this.getBalance() - amount);
            account.setBalance(account.getBalance() + amount);
        } else {
            System.out.println("Кредитный счет не может уходить в плюс!");
        }
    }

    @Override
    public void addMoney(int amount) {
        if ((this.getBalance() + amount) <= 0) {
            this.setBalance(this.getBalance() + amount);
        } else {
            System.out.println("Кредитный счет не может уходить в плюс!");
        }
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
