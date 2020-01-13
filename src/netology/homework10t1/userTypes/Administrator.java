package netology.homework10t1.userTypes;

import netology.homework10t1.userRoles.CanAdministrate;
import netology.homework10t1.userRoles.CanOrder;
import netology.homework10t1.userRoles.CanRead;

public class Administrator extends User implements CanAdministrate, CanOrder, CanRead {

    @Override
    public void findBook() {
        System.out.println("Ищет книгу");
    }

    @Override
    public void giveBook(User user) {
        if (user instanceof Reader) {
            System.out.println("Выдает книгу");
        } else {
            System.out.println("Книги выдаются только читателям!");
        }
    }

    @Override
    public void overdueNotification(User user) {
        if (user instanceof Reader) {
            System.out.println("Посылает уведомление о просрочке");
        } else {
            System.out.println("Уведомления о просрочке посылается только читателям!");
        }
    }

    @Override
    public void orderBook(User user) {
        if (user instanceof Supplier) {
            System.out.println("Заказывает книгу");
        } else {
            System.out.println("Заказ отправляется только поставщикам!");
        }
    }

    @Override
    public void readBook() {
        System.out.println("Читает книгу");
    }
}
