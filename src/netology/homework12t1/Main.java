/*
Задача 1. Лифт

1) Описание:

Сегодня мы будем реализовывать программу для работы лифта 25-ти этажного дома. Нужно написать программу, которая
считывает данные из консоли, ожидая ввода номера этажа. После ввода каждого числа (номера этажа) добавляет значение в
очередь. Как только пользователь введет 0, программа должна последовательно вывести список всех этажей, на которых лифт
делал остановки, в формате: "этаж 1 -> этаж 22 -> этаж 0". Если пользователь ввел этаж вне диапазона 0-25, —
проигнорировать ввод таких данных.

Для хранения введенных пользователем этажей подойдет структура на основе интерфейса очередь (queue). По мере ввода мы
сможем добавлять в конец очереди новые значения.

2) Функционал программы:

- Ввод номеров этажей для остановки;
- Вывод списка этажей, на которых лифт делал остановки в формате: "этаж 1 -> этаж 22 -> этаж 0".
 */

package netology.homework12t1;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PriorityQueue<Integer> floors = new PriorityQueue<Integer>();

        int maxFloor = 25;
        int minFloor = 0;

        while (true) {
            System.out.println("Введите номер этажа:");
            int floor = scanner.nextInt();
            if (floor == minFloor) {
                System.out.println("Лифт останавливался на следующих этажах:\n");
                while (!floors.isEmpty()) {
                    Integer fl = floors.poll();
                    System.out.print("Этаж " + fl + " -> ");
                }
                System.out.println("Этаж 0");
                break;
            } else if (floor > maxFloor || floor < minFloor) {
                System.out.println("Некорректный ввод...");
            } else {
                floors.offer(floor);
            }
        }
    }

}
