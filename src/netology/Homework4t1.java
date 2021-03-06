/*
Задача 1. Добавление новой задачи в TaskManager

1) Описание:

Напишем программу для упрощения ввода менеджером данных о задаче. При добавлении задачи менеджер Иван вводит следующий
текст: "Добавить картинку на главный экран приветствия, задача начинается в 15 и заканчивается в 19" (минуты учитывать
пока не будем).

Нужно найти в этом тексте время (часы) после выражения "начинается в" и "заканчивается в", рассчитать разницу между
ними, и, если результат вычисления будет отрицательным или равным нулю, — завершить выполнение программы и вывести
сообщение: "Формат введенных данных неверный".

2) Функционал программы:

- Возможность ввода из консоли текста задачи и времени;
- Распознавание времени начала начали задачи и времени завершения задачи;
- Расчет времени на выполнение задачи и вывод на экран.

3) Примеры:

- Пример 1

Введите название задачи и время на ее выполнение:
"Добавить картинку на главный экран приветствия, задача начинается в 15 и заканчивается в 19" <нажмите enter>
"На задачу потребуется: 4 ч."

- Пример 2

Введите название задачи и время на ее выполнение:
"Изменить заголовок главного экрана, задача начинается в 11 и заканчивается в 8" <нажмите enter>
"Формат введенных данных неверный"
*/

package netology;

import java.util.Scanner;

public class Homework4t1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите название задачи и время на ее выполнение:");

        while (true) {

            String input = scanner.nextLine();

            if ("end".equals(input)) {
                scanner.close();
                break;
            }

            int startTime = Integer.parseInt(
                                input.substring(
                                        input.indexOf("задача начинается в") + 20,
                                        input.indexOf("задача начинается в") + 22
                                ).trim()
            );

            int endTime = Integer.parseInt(
                    input.substring(
                            input.indexOf("заканчивается в") + 16,
                            input.length()
                    ).trim()
            );



            String res = endTime > startTime ?
                    "На задачу потребуется: " + (endTime - startTime) + " ч." :
                    "Формат введенных данных неверный";
            System.out.println(res);

        }

        scanner.close();
    }
}
