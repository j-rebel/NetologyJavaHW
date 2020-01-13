/*
Задача 2. Банковские счета

1) Описание:

Часто в проектировании программ нам удобно опираться на понятия, которые не представлены в реальном мире, но служат
удобной "опорой" для объединения нескольких классов.

Так, например, в банковском деле нет абстрактного понятия "Счет". Каждый счет в банке имеет четкое назначение:
сберегательный, кредитный, расчетный. Но банковская программа работает с общими для счетов операциями как с одинаковыми
объектами, и выполняет их, обращаясь к общему типу "Счет", хотя его и невозможно явно инстанцировать в программе.
Реализуйте этот сценарий, опираясь на механизмы полиморфизма.

2) Функционал программы:

- Создайте несколько классов — различных счетов на основе общего интерфейса:
- Сберегательный счет (SavingsAccount)
- Кредитный счет (CreditAccount)
- Расчетный счет (CheckingAccount)
- Выполните перевод с одного счета на другой в методе public static void main.
*/

package netology.homework10t2;

import netology.homework10t2.accountTypes.CheckingAccount;
import netology.homework10t2.accountTypes.CreditAccount;
import netology.homework10t2.accountTypes.SavingsAccount;

public class Main {
    public static void main(String[] args) {
        CheckingAccount check = new CheckingAccount(1000);
        CreditAccount credit = new CreditAccount(1000);
        SavingsAccount save = new SavingsAccount(1000);
        System.out.println("\n\n");

        System.out.println("Баланс расчетного счета " + check.getBalance());
        check.pay(500);
        System.out.println("Баланс расчетного счета после оплаты " + check.getBalance());
        check.transfer(save, 500);
        System.out.println("Баланс расчетного счета после перевода " + check.getBalance());
        check.addMoney(500);
        System.out.println("Баланс расчетного счета после пополнения " + check.getBalance());
        check.pay(9500);
        System.out.println("Баланс расчетного счета после оплаты " + check.getBalance() + "\n\n");

        System.out.println("Баланс сберегательного счета " + save.getBalance());
        save.pay(500);
        System.out.println("Баланс сберегательного счета после оплаты " + save.getBalance());
        save.transfer(check, 500);
        System.out.println("Баланс сберегательного счета после перевода " + save.getBalance());
        save.addMoney(500);
        System.out.println("Баланс сберегательного счета после пополнения " + save.getBalance());
        save.pay(9500);
        System.out.println("Баланс сберегательного счета после оплаты " + check.getBalance() + "\n\n");

        System.out.println("Баланс кредитного счета " + credit.getBalance());
        credit.pay(500);
        System.out.println("Баланс кредитного счета после оплаты " + credit.getBalance());
        credit.transfer(save, 500);
        System.out.println("Баланс кредитного счета после перевода " + credit.getBalance());
        credit.addMoney(500);
        System.out.println("Баланс кредитного счета после пополнения " + credit.getBalance());
        credit.pay(9500);
        System.out.println("Баланс кредитного счета после оплаты " + credit.getBalance());
    }
}
