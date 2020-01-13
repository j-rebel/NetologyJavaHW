/*
Задача 1. Пропущенные вызовы

1) Описание:

Совсем недавно мы с вами создавали программу для хранения номеров телефонов. Следующая программа будет будет немного
схожа по тематике. Нужно написать программу для хранения пропущенных звонков, используя уже изученные коллекции, в том
числе коллекцию TreeMap. Программа должна хранить список пропущенных вызовов в формате: дата и время звонка и, конечно,
имя контакта.

2) Функционал программы:

- Добавление контакта (имя, фамилия, номер телефона, группа контакта: работа, друзья, семья);
- Добавление пропущенного вызова;
- Вывод всех пропущенных вызовов с указанием фамилии и имени. Если контакта нет в списке контактов, вывести только номер
телефона;
- Очистка пропущенных вызовов.
- После запуска программа должна предложить пользователю выполнить любое действие из списка выше, а после завершения
действия (например, ввода данных нового контакта), снова вывести список доступных действий (меню).
*/

package netology.homework15t1;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

        Contacts contacts = new Contacts(new HashMap<>());
        MissedCalls missedCalls = new MissedCalls(new TreeMap<>());

        showMenu(contacts, missedCalls);

    }

    public static void showMenu(Contacts contacts, MissedCalls missedCalls) {

        Scanner scanner = new Scanner(System.in);

        boolean isExit = false;

        while (!isExit) {

            System.out.println("Меню:\n" +
                    "1. Добавить контакт\n" +
                    "2. Удалить контакт\n" +
                    "3. Обновить контакт\n" +
                    "4. Вывести список контактов\n" +
                    "5. Добавить пропущенный вызов\n" +
                    "6. Вывести все пропущенные вызовы\n" +
                    "7. Очистить пропущенные вызовы\n" +
                    "8. Выход\n" +
                    "Выберите пункт из меню (1-8):");

            int option = 0;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Некорректный ввод...\n");
            }


            switch (option) {

                case 1:
                    contacts.addContact();
                    break;
                case 2:
                    contacts.deleteContact();
                    break;
                case 3:
                    contacts.updateContact();
                    break;
                case 4:
                    System.out.println(contacts);
                    break;
                case 5:
                    missedCalls.addCall();
                    break;
                case 6:
                    missedCalls.printMissedCalls(contacts);
                    break;
                case 7:
                    missedCalls.resetCalls();
                    break;
                case 8:
                    System.out.println("Выходим из программы...");
                    isExit = true;
                    break;
                default:

            }

        }

    }


}
