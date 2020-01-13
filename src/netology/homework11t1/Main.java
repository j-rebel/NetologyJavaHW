/*
Задача 1. Записная книга

1) Описание:

Мы уже делали записную книжку с описанием дел, но не сохраняли их в какую-то структуру данных. Списки дел можно хранить
в массивах и списках. Массивы имеют фиксированную длину, и после того как массив создан, он не может расти или
уменьшаться. ArrayList (одна из имплементаций списка) может менять свой размер во время исполнения программы, при этом
не обязательно указывать размерность при создании объекта. Кроме того, вы без проблем можете вставить новый элемент в
середину коллекции, а также спокойно удалить элемент из любого места. Поэтому очень удобно использовать List для
ведения списка дел, ведь часто бывает, что нужно добавить какие-то дела в середине дня или же что-то удалить.

Необходимо реализовать программу, в которой пользователь вводит с консоли описание дел (одно дело — одна строка, затем
Enter) в бесконечном цикле, пока не введет ключевое слово "end". Программа сохраняет все эти дела в списке "List" и
после команды "end" выводит их в консоль.

2) Функционал программы:

- Запрос списка задач/дел у пользователя;
- Возможность добавить задачу в список;
- Возможность удалить задачу из списка;
- Возможность вывода всех задач.

*/

package netology.homework11t1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Task> taskList = new ArrayList();
        taskList.add(new Task("Пишем программу."));
        taskList.add(new Task("Проверяем функционал."));
        taskList.add(new Task("Сдаем на проверку."));

        modifyList(taskList);

    }

    public static void showMenu() {
        System.out.println(
                "Выберите действие:\n" +
                "1. Добавить задачу\n" +
                "2. Вывести список задач\n" +
                "3. Удалить задачу\n" +
                "0. Выход"
        );
    }

    public static void modifyList(ArrayList<Task> taskList) {

        Scanner scanner = new Scanner(System.in);

        boolean isExit = false;

        while (!isExit) {

            showMenu();

            String input = scanner.nextLine();

            int option = -1;

            try {
                option = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Введите номер опции, которую хотите использовать!");
            }

            switch (option) {
                case 1:
                    addTask(taskList);
                    break;
                case 2:
                    showTasks(taskList);
                    break;
                case 3:
                    removeTask(taskList);
                    break;
                case 0:
                    System.out.println("Выходим из программы..");
                    isExit = true;
                    break;
                default:
                    System.out.println("Некорректный ввод..");
                    continue;
            }
        }
    }

    public static void addTask(ArrayList<Task> taskList) {

        Scanner scanner = new Scanner(System.in);
        int count = 0;

        while (true) {

            System.out.println("Введите описание задачи:");

            String input = scanner.nextLine();

            if ("end".equals(input)) {
                break;
            }

            taskList.add(new Task(input));
            count++;
        }

        if (count > 0) {

            System.out.println("Добавлены задачи:");

            System.out.println("+---------------------------------------------+");

            System.out.printf(
                    "| %-15s | %-25s |\n",
                    "Индекс",
                    "Описание задачи"
            );

            System.out.println("+---------------------------------------------+");

            for (int i = taskList.size() - count; i < taskList.size(); i++) {

                System.out.printf(
                        "| %-15s | %-25s |\n",
                        i,
                        taskList.get(i).getDescription()
                );

            }

            System.out.println("+---------------------------------------------+");

        }

    }

    public static void showTasks(ArrayList<Task> taskList) {

        System.out.println("Задачи в списке:");

        System.out.println("+---------------------------------------------+");

        System.out.printf(
                "| %-15s | %-25s |\n",
                "Индекс",
                "Описание задачи"
        );

        System.out.println("+---------------------------------------------+");

        for (int i = 0; i < taskList.size(); i++) {

            System.out.printf(
                    "| %-15s | %-25s |\n",
                    i,
                    taskList.get(i).getDescription()
            );

        }

        System.out.println("+---------------------------------------------+");

    }


    public static void removeTask(ArrayList<Task> taskList) {

        showTasks(taskList);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите индекс задачи, которую хотите удалить:");

        try {

            int input = scanner.nextInt();

            System.out.println("Удалена задача: " + taskList.get(input).getDescription());

            taskList.remove(input);
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("Некорректный ввод, попробуйте снова!");
        }
    }
}
