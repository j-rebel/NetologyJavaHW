/*
Задача 2. Сравнение double

1) Описание:

Напишем программу для сравнения double, float и округления этих типов

2) Функционал программы:

- Ввод двух чисел double или float;
- Ввод операции;
- Вывод результата.

3) Пример:

Операции над double/float
1. Сравнить
2. Округлить
3. Отбросить дробную часть

1 <enter>
Введите первое число:
0.33 <enter>
Введите второе число:
0.33 <enter>
Результат:
числа равны
*/

package netology;

import java.util.Scanner;

public class Homework3t2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Операции над double/float \n1. Сравнить \n2. Округлить \n3. Отбросить дробную часть");

        int operationOfChoice = scanner.nextInt();

        switch (operationOfChoice) {
            case 1:
                System.out.println(compare());
                break;
            case 2:
                System.out.println(round());
                break;
            case 3:
                System.out.println(truncate());
                break;
            default:
                System.out.println("Неизвестная оперция");
                break;
        }

        scanner.close();

    }

    public static String compare() {
        Scanner scanner = new Scanner(System.in);
        String res = "";

        System.out.println("Введите первое число:");
        double a = scanner.nextDouble();

        System.out.println("Введите второе число:");
        double b = scanner.nextDouble();

        if (a - b > 0) {
            res = "Первое число больше";
        } else if (a - b < 0) {
            res = "Первое число меньше";
        } else {
            res = "Числа равны";
        }

        scanner.close();
        return res;
    }

    public static long round() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число:");

        long value = Math.round(scanner.nextDouble());

        scanner.close();

        return value;
    }

    public static int truncate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число:");

        double d = scanner.nextDouble();
        int res = (int) d;

        scanner.close();

        return res;
    }

}
