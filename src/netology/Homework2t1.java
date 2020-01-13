/*
Задача 1. Високосный год

1) Описание:

Нужно написать программу, которая будет рассчитывать количество дней в году. Зачем это бывает нужно? Варианты бывают
разные: например, для расчета продолжительности долгосрочных проектов в днях или чтобы узнать, сколько дней потребуется
для космической экспедиции на Марс. Для расчета количества дней в году требуется знать несколько правил:

В високосном году 366 дней, в обычном 365.

Високосный год — это год, номер которого делится без остатка на 400 (например 2000 или 2400), либо делится на 4 но не
делится на 100 (например 2008, 2096, но не 2100).

2) Функционал программы

- Вывод сообщения в консоли Введите год в формате "yyyy".
- Ввод года в формате yyyy (например 2004).
- Чтение значения из консоли и расчет количества дней.
- Результат работы программы: напечатать в консоли количество дней в году Количество дней 365 или Количество дней 366.

3) Пример

- Пример 1
Введите год в формате "yyyy"
2000 <нажмите enter>
Количество дней 366

- Пример 2
Введите год в формате "yyyy"
2018 <нажмите enter>
Количество дней 365
*/

package netology;

import java.util.Scanner;

public class Homework2t1 {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите год в формате \"yyyy\"");
        int year = scanner.nextInt();

        if (year % 400 == 0) {
            System.out.println(366);
        } else if (year % 4 == 0 && year % 100 != 0) {
            System.out.println(366);
        } else {
            System.out.println(365);
        }

        scanner.close();
    }
}