/*
Описание:
- Напишите программу для вычисления площади и длины произвольной окружности по его радиусу.
Напомним, что площадь круга вычисляется по формуле: π x R² (константу π можно считать равной 3.14),
 а формула вычисления длины: 2 x π x R.

Функционал программы:
- Запросите пользователя ввести радиус окружности;
- Рассчитайте площадь окружности;
- Рассчитайте длину окружности;
- Выведите на экран результат вычисления.

Пример 1:
Введите радиус окружности в сантиметрах:
10 <enter>
Площадь окружности: 314 см.кв.
Длина окружности: 62.8 см.

Пример 2:
Введите радиус окружности в сантиметрах:
4 <enter>
Площадь окружности: 50.24 см.кв.
Длина окружности: 25.12 см.
*/

package netology;

import java.util.Scanner;

public class Homework1t2 {

    private static final double PI = 3.14d;

    public static void main(String[] args) {

        System.out.println("Введите радиус окружности в сантиметрах:");

        Scanner scanner = new Scanner(System.in);

        double radius = scanner.nextDouble();

        System.out.println("Площадь окружности: " + countCircleArea(radius) + " см.кв.");
        System.out.println("Длина окружности: " + countCircleLength(radius) + " см.");

        scanner.close();
    }

    public static double countCircleArea(double r) {
        return roundOff(Homework1t2.PI * r * r);
    }

    public static double countCircleLength(double r) {
        return roundOff(2 * Homework1t2.PI * r);
    }

    public static double roundOff(double a) {
        return Math.round(a * 1000.0) / 1000.0;
    }

}
