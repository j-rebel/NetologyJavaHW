/*
Задача 1. Список покупок

1) Описание:

Наверное, у каждого из нас есть списки желаемых покупок. Особенно перед праздниками. Так давайте напишем программу для
хранения этих "хотелок" так, чтобы они автоматически сортировались по какому-то признаку.

Что известно:

Сущность "Хотелка": название (уникальное), краткое описание, цена, URL-адрес интернет-магазина или адрес магазина,
приоритет (0 - 5, где 0 - очень низкий приоритет, а 5 - очень высокий приоритет).

2) Функционал программы:

- Добавление "хотелок";
- Сортировка по убыванию/возрастанию цены;
- Сортировка по приоритету от самого важного до самого низкого приоритета.
*/

package netology.homework14t1;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        WishList list = new WishList();

        showMenu(list);
    }

    public static void showMenu(WishList list) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\nВыберите тип сортировки для Wishlist (для выхода нажмите <enter>)\n" +
                    "1. Сортировка по убыванию цены\n" +
                    "2. Сортировка по возрастанию цены\n" +
                    "3. Сортировка по приоритету от самого важного\n" +
                    "4. Сортировка по приоритету от низкого приоритета\n" +
                    "5. Добавить пункт в список\n" +
                    "6. Вывести список\n" +
                    "Введите индентификатор опции:");


            String input = scanner.nextLine();

            if ("".equals(input)) {
                break;
            }

            int option = Integer.parseInt(input);

            switch (option) {

                case 1:
                    list.sortDescPrice();
                    list.printWishList();
                    break;
                case 2:
                    list.sortAscPrice();
                    list.printWishList();
                    break;
                case 3:
                    list.sortDescPriority();
                    list.printWishList();
                    break;
                case 4:
                    list.sortAscPriority();
                    list.printWishList();
                    break;
                case 5:
                    list.addWishes();
                    break;
                case 6:
                    list.printWishList();
                    break;
                default:
                    break;
            }
        }
    }
}
