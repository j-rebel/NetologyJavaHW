/*
Для хранения контактов предлагаю использовать HashMap, в качестве ключа использовать номер телефона, а в качестве
значения хранить контактные данные. Лучше вынести эту коллекцию в отдельный класс Contacts.java, где добавить методы
для работы с этой коллекцией.

Map<String, Contact> contacts = new HashMap<>();

Нужно реализовать следующие public методы:

- Добавление контакта (имя, фамилия, номер телефона, группа контакта: работа, друзья, семья).
- Удаление контакта по имени и фамилии.
- Поиск контакта по номеру.
- Переопределим метод toString в удобочитаемый вид.
 */

package netology.homework15t1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Contacts {

    private Map<String, Contact> contacts = new HashMap<>();

    public Contacts(Map<String, Contact> contacts) {
        this.contacts = contacts;
    }

    public void addContact() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите имя или <enter> для выхода:");
            String name = scanner.nextLine();
            if ("".equals(name)) {
                break;
            }
            System.out.println("Введите фамилия или <enter> для выхода:");
            String surname = scanner.nextLine();
            if ("".equals(surname)) {
                break;
            }
            System.out.println("Введите телефон или <enter> для выхода:");
            String phone = scanner.nextLine();
            if ("".equals(phone)) {
                break;
            }
            System.out.println("Введите группа или <enter> для выхода:");
            String groupStr = scanner.nextLine();
            if ("".equals(groupStr)) {
                break;
            }

            Group group = Group.FAMILY;

            if (groupStr.equals(Group.FAMILY.getTitle())) {
                group = Group.FAMILY;
            } else if (groupStr.equals(Group.FRIENDS.getTitle())) {
                group = Group.FRIENDS;
            } else if (groupStr.equals(Group.WORK.getTitle())) {
                group = Group.WORK;
            } else {
                System.out.println("Такой группы не существует...");
                return;
            }

            this.getContacts().put(phone, new Contact(name, surname, phone, group));
        }
    }

    public void deleteContact() {
        System.out.println("Введите телефон контакта, который нужно удалить или <enter> для выхода:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (searchContact(input) == 1) {
            this.getContacts().remove(input);
        }
    }

    public void updateContact() {
        System.out.println("Введите телефон контакта, который нужно обновить или <enter> для выхода:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean isExit = false;
        if (searchContact(input) == 1 && !isExit) {
            System.out.println("Введите номер поля, которое хотите обновить: \n" +
                                "1) Имя \n" +
                                "2) Фамилия \n" +
                                "3) Телефон \n" +
                                "4) Группа \n" +
                                "5) Отмена \n"
            );

            int option = Integer.parseInt(scanner.nextLine());

            System.out.println("Введите новое значение");
            String newValue = scanner.nextLine();

            switch (option) {
                case 1:
                    this.getContacts().get(input).setName(newValue);
                    break;
                case 2:
                    this.getContacts().get(input).setSurname(newValue);
                    break;
                case 3:
                    Contact newContact = this.getContacts().get(input);
                    newContact.setPhone(newValue);
                    this.getContacts().put(newValue, newContact);
                    this.getContacts().remove(input);
                    break;
                case 4:
                    Group group = Group.FAMILY;

                    if (newValue.equals(Group.FAMILY.getTitle())) {
                        group = Group.FAMILY;
                    } else if (newValue.equals(Group.FRIENDS.getTitle())) {
                        group = Group.FRIENDS;
                    } else if (newValue.equals(Group.WORK.getTitle())) {
                        group = Group.WORK;
                    } else {
                        System.out.println("Такой группы не существует...");
                        return;
                    }
                    this.getContacts().get(input).setGroup(group);
                    break;
                case 5:
                    isExit = true;
                default:
                    isExit = true;
            }

        }
    }

    public int searchContact(String phone) {
        if ("".equals(phone)) {
            System.out.println("Возврат к предыдущему меню...");
            return 0;
        }
        if (this.getContacts().containsKey(phone)) {
            return 1;
        } else {
            //System.out.println("Контакт не найден...");
            return -1;
        }
    }

    public Map<String, Contact> getContacts() {
        return this.contacts;
    }

    public void setContacts(Map<String, Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        if (!this.getContacts().isEmpty()) {
            for (Map.Entry<String, Contact> pair : this.getContacts().entrySet()) {
                System.out.println(pair.getKey() + "\n - " + pair.getValue());
            }
        } else {
            System.out.println("Список пуст...");
        }
        return "\n";
    }
}
