/*
Задача 2. Перевод времени

1) Описание:

Для работы программы менеджера задач нам нужно сравнивать разные по длительности задачи.

Вам нужно разработать часть функциональности, отвечающую за перевод времени из одних единиц в другие. Например, на одну
задачу нужно 2 дня, 4 часа и 10 минут, на вторую задачу нужно 3 дня, 4 часа и 15 минут.

Хранить и использовать три переменные неудобно, поэтому для хранения времени обычно используют минимальную из
используемых единиц. В нашем случае это секунды (хотя иногда используют миллисекунды).

Например, задача занимает 1 день 2 часа 10 минут, а программа переводит и хранит это как
24 * 3600 + 2 * 3600 + 10 * 60 = 94200 секунд. С одной переменной уже гораздо проще выполнять сравнение, сложение и
вычитание.

Нужно написать программу, которая в цикле запрашивает название задачи и ее продолжительность (3 числа: дни, часы и
минуты), подсчитывает, сколько времени потребуется на выполнение всех задач, а также выводит время в секундах самой
продолжительной задачи и самой короткой.

2) Функционал программы:

- Возможность ввода из консоли нескольких задач:
    Название;
    Количество дней;
    Количество часов;
    Количество минут.
- Завершение программы, если пользователь ввел end.
- Перед завершением программы вывод информации:
    Всего потребуется секунд на выполнение всех задач;
    Самая продолжительная задача займет XXXX секунд (имя задачи выводить не нужно);
    Самая короткая задача займет XXXX секунд (имя задачи выводить не нужно).

3) Пример:

Введите название задачи
"Дизайн главной страницы" <нажмите enter>
Сколько дней потребуется на выполнение?
3 <нажмите enter>
Сколько часов?
5 <нажмите enter>
Сколько минут?
0 <нажмите enter>
Для завершения работы программы введите `end` / для продолжения нажмите enter

...
Введите название задачи
"Верстка footer" <нажмите enter>
Сколько дней потребуется на выполнение?
0 <нажмите enter>
Сколько часов?
4 <нажмите enter>
Сколько минут?
0 <нажмите enter>
Для завершения работы программы введите `end` / для продолжения нажмите enter
end <нажмите enter>


Всего потребуется: 291600 секунд
Самая продолжительная задача займет: 277200 секунд
Самая короткая задача займет: 14400 секунд
*/

package netology;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Homework2t2 {

    public static void main(String[] args) {

        Map<String, Integer> taskList = new TreeMap<String, Integer>();

        Scanner scanner = new Scanner(System.in);

        int minTime = Integer.MAX_VALUE;
        int maxTime = 0;
        int totalTime = 0;
        int currentTaskTime = 0;

        while (true) {
            System.out.println("Введите название задачи");
            String taskName = scanner.nextLine();
            System.out.println("Сколько дней потребуется на выполнение?");
            int days = scanner.nextInt();
            System.out.println("Сколько часов?");
            int hours = scanner.nextInt();
            System.out.println("Сколько минут?");
            int minutes = scanner.nextInt();

            currentTaskTime = convertToSeconds(days, hours, minutes);

            taskList.put(taskName, currentTaskTime);

            totalTime += currentTaskTime;

            if (currentTaskTime > maxTime) {maxTime = currentTaskTime;}
            if (currentTaskTime < minTime) {minTime = currentTaskTime;}

            System.out.println("Для завершения работы программы введите `end` / для продолжения нажмите enter");

            scanner.nextLine();
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
        }

        System.out.println("Всего потребуется: " + totalTime + " секунд");
        System.out.println("Самая продолжительная задача займет: " + maxTime + " секунд");
        System.out.println("Самая короткая задача займет: " + minTime + " секунд");
        System.out.println();
        System.out.println("Список текущих задач:");
        for (Map.Entry<String, Integer> taskRecord : taskList.entrySet()) {
            String key = taskRecord.getKey();
            int value = taskRecord.getValue();
            System.out.println("Задача: " + key + " (займет " + value + " секунд)");
        }
    }

    public static int convertToSeconds (int days, int hours, int minutes) {
        return days*24*60*60 + hours*60*60 + minutes*60;
    }
}
