/*
Задача 1. Игра-шутер

1) Описание

Один из проектов — это игра-шутер (Half-Life 3, только никому ни слова). У игрока должна быть возможность использовать
разные виды оружия, в будущем в игру могут быть добавлены новые. Необходимо спроектировать иерархию классов, а также
систему слотов для оружия у игрока.

2) Функционал программы
- Создание объекта Player и добавление ему оружия;
- Возможность выбора оружия для выстрела.
*/

package netology.homework9t1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        System.out.format("У игрока %d слотов с оружием,"
                        + " введите номер, чтобы выстрелить,"
                        + " -1 чтобы выйти%n",
                player.getSlotsCount()
        );

        int slot;

        while (true) {
            try {
                slot = scanner.nextInt();
                if (slot == -1) {
                    break;
                }
                player.shotWithWeapon(slot - 1);
            } catch (InputMismatchException e) {
                System.out.println("Нужно ввести цифру от 1 до " + player.getSlotsCount());
                throw new IllegalArgumentException();
            }
        }
        System.out.println("Game over!");
    }
}
