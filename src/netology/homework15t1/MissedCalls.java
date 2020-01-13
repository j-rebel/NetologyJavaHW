/*
Для хранения пропущенных вызовов использовать TreeMap, где ключ — время пропущенного вызова, а значение — номер
телефона. Для хранения времени звонка подойдет тип данных LocalDateTime — у него уже определен метод compareTo для
использования в коллекции TreeMap. Нужно также создать отдельный класс для хранения и работы с этой коллекцией
MissedCalls.java.

Map<LocalDateTime, String> missedCalls = new TreeMap<>();

Нужно реализовать следующие public методы:

- Добавление пропущенного вызова.
- Возвращение списка пропущенных вызовов.
- Очистка списка пропущенных вызовов.
*/

package netology.homework15t1;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MissedCalls {

    TreeMap<LocalDateTime, String> missedCalls = new TreeMap<>();

    public void printMissedCalls(Contacts contacts) {
        if (!this.getMissedCalls().isEmpty()) {
            for (Map.Entry<LocalDateTime, String> pair : this.getMissedCalls().entrySet()) {
                if (contacts.searchContact(pair.getValue()) == 1) {
                    System.out.println(
                            contacts.getContacts().get(pair.getValue()).getName() +
                            " " +
                            contacts.getContacts().get(pair.getValue()).getSurname() +
                            " " +
                            pair.getValue() +
                            " " +
                            pair.getKey()
                    );
                } else {
                    System.out.println(pair.getValue() + " " + pair.getKey());
                }
            }
        } else {
            System.out.println("Список пуст...");
        }
    }

    public void addCall() {
        System.out.println("Введите номер:");
        Scanner scanner = new Scanner(System.in);
        String phone = scanner.nextLine();
        getMissedCalls().put(LocalDateTime.now(), phone);
    }

    public void resetCalls() {
        this.getMissedCalls().clear();
    }

    public Map<LocalDateTime, String> getMissedCalls() {
        return missedCalls;
    }

    public void setMissedCalls(TreeMap<LocalDateTime, String> missedCalls) {
        this.missedCalls = missedCalls;
    }

    public MissedCalls(TreeMap<LocalDateTime, String> missedCalls) {
        this.missedCalls = missedCalls;
    }


}
