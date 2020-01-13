/*
Задача 2. Морской бой

1) Описание:

Вы пишете игру "морской бой" в минимальном варианте, где стреляете только вы. На входе — двумерный массив 10 на 10,
заполненный числами.

Возможные числа: 0 ("пустое поле"), 1 ("есть корабль"), 2 ("корабль застрелен"), 3 ("промах"). При этом "корабли"
занимают не более 10 клеток. Расстоянием между кораблями и "палубностью" кораблей мы пренебрегаем. Пользователь вводит
координаты поля, в которое стреляет.

В зависимости от результата "выстрела" программа выдает ему ответ — "попал"/"не попал". После попадания во все корабли,
либо по истечении 30 ходов, игра считается законченной. Если за время игры были застрелены все 10 клеток с кораблями,
то игра выиграна.

2) Функционал программы:

- Создание массива карты 10 на 10 клеток;
- Автоматическое заполнение полей карты кораблями;
- Подсчет количества ходов (не должно превышать 30);
- Проверка все ли корабли подбиты (если да, то победа игрока).

3) Пример:

Игра "Морской бой"
Заполнение кораблей...
Введите координаты для атаки (осталось 30):
1:1
промах
Введите координаты для атаки (осталось 29):
1:2
корабль застрелен
Введите координаты для атаки (осталось 28):
...
Победа! Поздравляем, вы подбили все вражеские корабли!
*/

package netology;

import java.util.Random;
import java.util.Scanner;

public class Homework6t2 {

    static int currentTurn = 1;

    public static void main(String[] args) {

        int TURNS = 3;
        int FIELD_SIZE = 10;
        int MAX_SHIP_COUNT = 1;

        System.out.println("Игра \"Морской бой\"\n");

        int board[][] = createBoard(MAX_SHIP_COUNT, FIELD_SIZE, 1);

        while (currentTurn <= TURNS) {
            System.out.println("Выберите координаты для выстрела (ходов осталось " + (TURNS - currentTurn + 1) + "):");

            shoot(board);

            if (!areShipsLeft(board)) {
                System.out.println("Поздравляем! Вы победили за " + currentTurn + " хода");
                break;
            }
        }
        if (areShipsLeft(board)) {
            System.out.println("К сожалению, вы проиграли...");
        }
    }

    public static void printBoard(int board[][]) {
        System.out.println("Состояние поля:");
        System.out.print("     ");
        for (int i = 0; i< board.length; i++) {
            System.out.format("%4d", i + 1);

        }

        System.out.println("\n==============================================");

        for (int i = 0; i< board.length; i++) {
            System.out.format("%3d |", i + 1);
            for (int j = 0; j < board.length; j++) {
                System.out.format("%4d", board[i][j]);
            }

            System.out.println();
        }
        System.out.println();
    }

    public static int[][] createBoard(int MAX_SHIP_COUNT, int FIELD_SIZE, int SHIP) {

        System.out.println("Заполнение кораблей...\n");

        int board[][] = new int[FIELD_SIZE][FIELD_SIZE];

        Random random = new Random();
        for (int i = 0; i <MAX_SHIP_COUNT; i++) {
            int shipX = random.nextInt(FIELD_SIZE);
            int shipY = random.nextInt(FIELD_SIZE);

            if (board[shipY][shipX] == SHIP){
                i--;
            }

            board[shipY][shipX] = SHIP;
        }
        return board;
    }

    public static void shoot(int board[][]) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int Y = Integer.parseInt(input.substring(0, input.indexOf(":")));
        int X = Integer.parseInt(input.substring(input.indexOf(":") + 1, input.length()));

        switch (board[Y - 1][X - 1]) {
            case 0:
                System.out.println("Промах!");
                board[Y - 1][X - 1] = 3;
                break;
            case 1:
                System.out.println("Корабль потоплен!");
                board[Y - 1][X - 1] = 2;
                break;
            case 2:
                System.out.println("Корабль уже потонул...");
                break;
            case 3:
                System.out.println("Вы сюда уже стреляли");
                break;
        }

        currentTurn++;
        printBoard(board);

    }

    public static boolean areShipsLeft(int board[][]) {
        for (int i = 0; i< board.length; i++) {
            for (int j = 0; j < board.length; j++) {
              if (board[i][j] == 1) {
                  return true;
              }
            }
        }
        return false;
    }

}
