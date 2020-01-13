package netology.homework10t1.userTypes;

import netology.homework10t1.userRoles.CanRead;
import netology.homework10t1.userRoles.CanSupply;

public class Supplier extends User implements CanRead, CanSupply {

    @Override
    public void readBook() {
        System.out.println("Читает книгу");
    }

    @Override
    public void deliverBook(User user) {
        if (user instanceof Administrator) {
            System.out.println("Доставляем книги");
        } else {
            System.out.println("Доставка производится только администраторам!");
        }
    }
}
