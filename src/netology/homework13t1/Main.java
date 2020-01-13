/*
Задача 1 (HashMap). Телефонный справочник

1) Описание:

Эта задача про телефонный справочник с поддержкой групп контактов. Один контакт может входить в несколько групп.
Например, если вы работаете со своим другом, то он будет в группах "Друзья" и "Работа". У пользователя должна быть
возможность создания групп и контактов, добавления одного контакта в несколько групп.

2) Функционал программы:

- Создание группы;
- Создание контакта;
- Добавление контакта в разные группы;
- Вывод групп с контактами.
*/

package netology.homework13t1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        PhoneContacts phoneContacts = new PhoneContacts();

        showMenu(phoneContacts);

    }

    public static void showMenu(PhoneContacts phoneContacts) {

        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;

        while (!isExit) {

            System.out.println(
                    "\nВыберите действие:" +
                    "\n1) Вывести контакты всех групп" +
                    "\n2) Вывести контакты определенной группы" +
                    "\n3) Добавить контакт" +
                    "\n4) Добавить группу" +
                    "\n5) Выход"
            );

            String input = scanner.nextLine();
            int option = Integer.parseInt(input);

            switch (option) {
                case 1:
                    phoneContacts.printContacts();
                    break;
                case 2:
                    System.out.println("Введите название нужной группы:");
                    phoneContacts.printContactsOfACertainGroup(scanner.nextLine());
                    break;
                case 3:
                    System.out.println("Введите название нужной группы:");
                    String group = scanner.nextLine();
                    System.out.println("Введите имя контакта:");
                    String name = scanner.nextLine();
                    System.out.println("Введите телефон контакта:");
                    String phone = scanner.nextLine();
                    phoneContacts.addContact(group, new Contact(name, phone));
                    break;
                case 4:
                    System.out.println("Введите название нужной группы:");
                    phoneContacts.addGroup(scanner.nextLine());
                    break;
                case 5:
                    System.out.println("Выходим из программы...");
                    isExit = true;
                    break;
                default:
                    System.out.println("Некорректный ввод, попробуйте еще раз...");
                    break;
            }
        }
    }
}
