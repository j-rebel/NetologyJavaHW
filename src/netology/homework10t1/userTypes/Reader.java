package netology.homework10t1.userTypes;

import netology.homework10t1.userRoles.CanRead;

public class Reader extends User implements CanRead {

    @Override
    public void readBook() {
        System.out.println("Читает книгу");
    }
}
