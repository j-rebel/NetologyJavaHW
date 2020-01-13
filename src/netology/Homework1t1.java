/*
Описание:
- Напишите программу для подсчета суммы 3х целых чисел.

Функционал программы:
- Ввод первого числа;
- Ввод второго числа;
- Ввод третьего числа;
- Вывести на экран сумму этих чисел.

Пример вывода:
Программа расчета суммы трех чисел
Введите первое число:
10 <enter>
Введите второе число:
15 <enter>
Введите третье число:
20 <enter>
Сумма чисел = 45
*/

package netology;

import java.util.Scanner;

public class Homework1t1 {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Программа расчета суммы трех чисел");

            System.out.println("Введите первое число:");
            int firstInput = scanner.nextInt();
            System.out.println("Введите второе число:");
            int secondInput = scanner.nextInt();
            System.out.println("Введите третье число:");
            int thirdInput = scanner.nextInt();
            System.out.println("Сумма чисел = " + sum(firstInput, secondInput, thirdInput));

            scanner.close();

        }

        public static int sum(int a, int b, int c) {
            int result = a + b + c;
            return result;
        }
    }

