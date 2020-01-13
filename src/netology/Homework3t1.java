/*
Задача 1. Шифровальная машинка

1) Описание:

Нужно написать программу декодирования символов из восьмеричного ASCII кода. Для перевода таких смоволов можно
воспользоваться таблицей символов http://www.asciitable.com (восьмеричный код Oct). Пользователь вводит восьмеричный
код символа, который, далее декодируется в букву.

2) Функционал программы:

- Чтение символов;
- Перевод символов из ASCII кода;
- Вывод результата на экран;
- Запросить повторный ввод символов.

3) Пример:

Введите ASCII код (end для вывода результата):
150
Введите ASCII код (end для вывода результата):
151
Введите ASCII код (end для вывода результата):
end
Результат:
hi

Введите ASCII код (end для вывода результата):
...

*/

package netology;

import java.util.Scanner;

public class Homework3t1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String res = "";

        while (true) {

            System.out.println("Введите ASCII код (end для вывода результата):");

            String input = scanner.nextLine();

            if ("end".equals(input)) {
                break;
            }

            char c = (char) Integer.parseInt(input, 8);
            res += c;

        }

        System.out.println(res);

    }

}
