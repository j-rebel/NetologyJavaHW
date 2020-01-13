package netology.homework10t1.userRoles;

import netology.homework10t1.userTypes.User;

public interface CanAdministrate {
    void findBook();
    void giveBook(User user);
    void overdueNotification(User user);
}
