/*
Задача 2. Польская запись

1) Описание:

Задача — написать программу перевода инфиксной записи (например 2 + 3) в постфиксную запись (2 3 +), что и будет
являться так называемой "Обратной польской записью".

Обра́тная по́льская запись (англ. Reverse Polish notation, RPN) — форма записи математических и логических выражений, в
которой операнды расположены перед знаками операций (источник
https://ru.wikipedia.org/wiki/%D0%9F%D0%BE%D0%BB%D1%8C%D1%81%D0%BA%D0%B0%D1%8F_%D0%BD%D0%BE%D1%82%D0%B0%D1%86%D0%B8%D1%8F).
Такая запись имеет ряд преимуществ перед инфиксной записью при выражении математических формул:

- Любая формула может быть выражена без скобок.
- Удобна для вычисления формул в stack машинах (например JVM).
- Нет нежелательных приоритетов операторов.
- Необходимо реализовать алгоритм на основе очереди, который прочитает математическую формулу, найдет все числа и сохранит их отдельно от знаков (в отдельную коллекцию).

2) Функционал программы:

- Ввод выражения в инфиксной записи;
- Перевод выражения в постфиксную запись;
- Вывод результата.
*/

package netology.homework12t2;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите математическую формулу:");

        String input = scanner.nextLine();
        System.out.println(input);

        transformFormulaToRPN(input);
    }

    public static void transformFormulaToRPN(String input) {
        printDiditsQueue(createDiditsQueue(input));
        printOperatorsStack(createOperatorsStack(input));
    }

    public static String leaveDigits(String input) {
        String regexDigits = "\\D";
        String regexRemoveSpaces = "\\s{2,}";

        return input.replaceAll(regexDigits, " ").replaceAll(regexRemoveSpaces, " ").trim();
    }

    public static ArrayDeque<Integer> createDiditsQueue(String input) {
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();

        String[] arr = leaveDigits(input).split(" ");

        for (String s : arr) {
            queue.offer(Integer.parseInt(s));
        }

        return queue;
    }

    public static void printDiditsQueue(ArrayDeque<Integer> queue) {
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
        System.out.print("   ");
    }

    public static String leaveOperators(String input) {
        String regexOperators = "[^+-/*]";
        String regexRemoveSpaces = "\\s{2,}";

        return input.replaceAll(regexOperators, " ").replaceAll(regexRemoveSpaces, " ").trim();
    }

    public static Stack<String> createOperatorsStack(String input) {
        Stack<String> stack = new Stack<String>();

        String[] arr = leaveOperators(input).split(" ");

        stack.addAll(Arrays.asList(arr));

        return stack;
    }

    public static void printOperatorsStack(Stack<String> stack) {
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.print("   ");
    }

}
