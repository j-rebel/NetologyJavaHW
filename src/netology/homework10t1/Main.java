/*
Задача 1. Библиотека

1) Описание:

Необходимо разработать иерархию работников библиотеки. Нужно реализовать совмещение нескольких ролей в библиотеке в
одном исполнителе через интерфейсы. Каждый объект в программе имеет определенный набор действий.

Часто программист, создающий объект, не представляет все ситуации, в которых тот будет использоваться. Также
программисту, использующему объект, часто неизвестны все его детали.

Для передачи информации о том, что должен уметь объект, используются интерфейсы.

Примером интерфейсов в нашей библиотеке может служить понятие роли на проекте. Каждая роль подразумевает набор
определенных операций, которые должен "уметь" объект пользователь — User в программе.

2) Функционал программы:

- Создайте иерархию "Пользователи библиотеки" со следующими интерфейсами:
- Читатель – берет и возвращает книги.
- Библиотекарь – заказывает книги.
- Поставщик книг – приносит книги в библиотеку.
- Администратор – находит и выдает книги и уведомляет о просрочках времени возврата.
- В методе public static void main создайте 2-3 объекта, реализующих эти интерфейсы.
*/

package netology.homework10t1;

import netology.homework10t1.userTypes.Administrator;
import netology.homework10t1.userTypes.Reader;
import netology.homework10t1.userTypes.Supplier;

public class Main {
    public static void main(String[] args) {
        Reader user1 = new Reader();
        Administrator user2 = new Administrator();
        Supplier user3 = new Supplier();

        user1.readBook();

        user2.findBook();
        user2.giveBook(user1);
        user2.giveBook(user3);
        user2.orderBook(user1);
        user2.orderBook(user3);
        user2.overdueNotification(user1);
        user2.overdueNotification(user3);
        user2.readBook();

        user3.deliverBook(user1);
        user3.deliverBook(user2);
        user3.readBook();
    }
}
