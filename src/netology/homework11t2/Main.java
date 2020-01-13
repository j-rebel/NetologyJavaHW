/*
Задача 2. Список сотрудников

1) Описание:

Необходимо создать программу учета сотрудников для гос. организации. Сотрудник имеет следующие атрибуты: фамилия, имя,
возраст, пол, образование, должность, отдел. Пользователь вводит с консоли описание каждого сотрудника путем
последовательного набора всех его атрибутов. Это происходит в бесконечном цикле, пока пользователь не введет ключевое
слово "end". Далее программа выводит коллекцию сотрудников на консоль.

2) Функционал программы:

Ввод описания сотрудников из консоли:
- фамилия;
- имя;
- возраст;
- пол;
- образование;
- должность;
- отдел.

Вывод списка сотрудников.
*/

package netology.homework11t2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();
        showMenu(employees);

    }

    public static void addEmployee(ArrayList<Employee> employees) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите информацию о сотруднике (фамилия, имя, возраст, пол, образование, должность, отдел");

            System.out.println("Введите имя:");
            String firstName = scanner.nextLine();
            System.out.println("Введите фамилию:");
            String lastName = scanner.nextLine();
            System.out.println("Введите возраст:");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.println("Введите пол:");
            String gender = scanner.nextLine();
            System.out.println("Введите образование:");
            String educationLevel = scanner.nextLine();
            System.out.println("Введите должность:");
            String position = scanner.nextLine();
            System.out.println("Введите отдел:");
            String department = scanner.nextLine();

            employees.add(
                    new Employee(
                                firstName,
                                lastName,
                                age,
                                gender,
                                educationLevel,
                                position,
                                department
                    )
            );

            System.out.println("Если хотите закончить ввод данных, введите end");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
        }
    }

    public static void printEmployees(ArrayList<Employee> employees) {

        System.out.println("Список сотрудников:");

        if (!employees.isEmpty()) {
            for (Employee employee:
                 employees) {
                System.out.println(employee);
            }
        } else {
            System.out.println("Список пуст, добавьте сотрудников!");
        }

    }

    public static void updateEmployee(ArrayList<Employee> employees) {
        int index = searchEmployee(employees);

        boolean isExit = false;

        if (index >= 0) {

            Scanner scanner = new Scanner(System.in);

            while (!isExit) {
                System.out.println(
                        "Введите номер параметра, который вы хотите изменить: \n" +
                        "1) Имя \n" +
                        "2) Фамилия \n" +
                        "3) Возраст \n" +
                        "4) Пол \n" +
                        "5) Образование \n" +
                        "6) Должность \n" +
                        "7) Отдел \n" +
                        "8) Выход \n"
                );

                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("Введите имя:");
                        String inputName = scanner.nextLine();
                        employees.get(index).setFirstName(inputName);
                        break;
                    case 2:
                        System.out.println("Введите фамилию:");
                        String inputLastName = scanner.nextLine();
                        employees.get(index).setLastName(inputLastName);
                        break;
                    case 3:
                        System.out.println("Введите возраст:");
                        int inputAge = scanner.nextInt();
                        employees.get(index).setAge(inputAge);
                        break;
                    case 4:
                        System.out.println("Введите пол:");
                        String inputGender = scanner.nextLine();
                        employees.get(index).setGender(inputGender);
                        break;
                    case 5:
                        System.out.println("Введите образование:");
                        String inputEd = scanner.nextLine();
                        employees.get(index).setEducationLevel(inputEd);
                        break;
                    case 6:
                        System.out.println("Введите должность:");
                        String inputPosition = scanner.nextLine();
                        employees.get(index).setPosition(inputPosition);
                        break;
                    case 7:
                        System.out.println("Введите отдел:");
                        String inputDep = scanner.nextLine();
                        employees.get(index).setDepartment(inputDep);
                        break;
                    case 8:
                        System.out.println("Возращаемся к основному меню...");
                        isExit = true;
                        break;
                }
            }
        }

    }

    public static void removeEmployee(ArrayList<Employee> employees) {

        int index = searchEmployee(employees);
        if (index >= 0) {
            employees.remove(index);
        }

    }

    public static int searchEmployee(ArrayList<Employee> employees) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите фамилию искомого сотрудника:");
        String searchedName = scanner.nextLine();
        int index = -1;

        for (int i = 0; i < employees.size(); i++) {
            if (searchedName.equals(employees.get(i).getLastName())) {
                return i;
            }
        }

        System.out.println("Сотрудник не найден..");
        return index;
    }

    public static void showMenu(ArrayList<Employee> employees) {

        boolean isExit = false;

        while (!isExit) {

            Scanner scanner = new Scanner(System.in);

            System.out.println(
                    "\nВведите номер опции: \n" +
                    "1) Вывести список сотрудников \n" +
                    "2) Добавить сотрудника \n" +
                    "3) Обновить информацию по сотруднику \n" +
                    "4) Удалить сотрудника \n" +
                    "5) Завершить работу \n"
            );

            String input = scanner.nextLine();

            int option = 0;

            try {
                option = Integer.parseInt(input);
            } catch (NumberFormatException e) {

            }

            switch (option) {
                case 1:
                    printEmployees(employees);
                    break;
                case 2:
                    addEmployee(employees);
                    break;
                case 3:
                    updateEmployee(employees);
                    break;
                case 4:
                    removeEmployee(employees);
                    break;
                case 5:
                    System.out.println("Выходим из программы...");
                    isExit = true;
                    break;
                default:
                    System.out.println("Некорректный ввод, попробуйте снова...");
            }


        }

    }

}
