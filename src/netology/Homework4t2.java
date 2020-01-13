/*
Задача 2. Удаляем лишние пробелы

1) Описание:

Напишем программу для очистки пользовательских данных от лишних пробелов. Наша задача — написать метод, который будет
принимать на вход строку, введенную пользователем, и возвращать обработанную строку без лишних пробелов. Результат
выполнения нужно вывести в консоль.

2) Функционал программы:

- Возможность ввода из консоли любого текста;
- Удаление пробелов в начале строки;
- Удаление лишних пробелов в любом месте текста.

3) Пример:

"Введите текст:"
"  Текст с   большим количеством    пробелов !  " <нажмите enter>
"Пробелы удалены:"
"Текст с большим количеством пробелов!"
*/

package netology;

import java.util.Scanner;

public class Homework4t2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

       while (true) {

           System.out.println("Введите текст:");

           String input = scanner.nextLine();

           if ("end".equals(input)) {
               scanner.close();
               break;
           }

           System.out.println("Пробелы удалены:\n" + extraTrim(input));

       }

    }

    public static String extraTrim(String input) {
        String regex = "\\s+";
        String regexFinal = "\\s+(?=\\p{Punct})";
        String res = input.trim();
        res = res.replaceAll(regex, " ");
        res = res.replaceAll(regexFinal, "");

        return res;
    }

}
