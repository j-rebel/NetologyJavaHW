/*
Задача 2 (HashSet). Список студентов

1) Описание:

Вы разрабатываете систему учета студентов. Для каждого студента нужно хранить следующие данные – ФИО, номер группы,
номер студенческого билета. Уникальным идентификатором является номер студенческого билета. Пользователь вводит данные
студентов в бесконечном цикле до ввода команды "end". По окончании ввода программа должна вывести список студентов.
Структура данных, куда сохраняются студенты, должна отбрасывать ввод одного и того же студента более одного раза.
Учитывайте, что имена у людей могут быть одинаковыми, а номера документов – нет.

2) Функционал программы:

- Ввод информации о студентах;
- Вывод списка студентов.
*/

package netology.homework13t2;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        HashSet<Student> students = new HashSet<>();

        while (true) {

            System.out.println("Введите информацию о студенте: \"ФИО, номер группы, номер студенческого билета\"(для завершения работы программы введите \"end\")");

            Scanner scanner = new Scanner(System.in);

            String input = scanner.nextLine();

            if ("end".equals(input)) {
                break;
            }

            String[] arr = input.split(",");

            students.add(new Student(arr[0], arr[1], arr[2]));

        }

        System.out.println("Список студентов:");
        for (Student student : students) {
            System.out.println(student.getName() + " " + student.getGroup() + " " + student.getStudentId());
        }
    }

}
