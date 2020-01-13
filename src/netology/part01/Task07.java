/*Задание 1
Обработаем исключительную ситуацию ArrayIndexOutOfBoundsException, которая возникает при попытке доступа к индексу, находящемуся за границей массива.

Воспользуйтесь готовым проектом: https://repl.it/@Netology/Java-Start-71.
В нем уже создан массив с тремя элементами, и есть попытка доступа до четвертого элемента.

Вам необходимо:

Сделать Fork данного проекта к себе, т.е. копию;
Дописать код, обрабатывающий исключение ArrayIndexOutOfBoundsException, используя блок try catch;
Вывести описание ошибки в блоке catch.
Задание 2
Создаем объекты LocalTime и LocalDateTime и выводим в консоль.

Вам необходимо:

Создать новый repl проект на сайте repl.it;
Создать объект LocalTime со временем 22.45 и вывести в консоль значение данного объекта;
Создать объект LocalDateTime с датой 31 декабря 2018 года и временем 01.45 и вывести в консоль значение данного объекта.
Решение заданий вы получите в материалах на следующем шаге.*/

package netology.part01;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Task07 {

    public static void main(String args[]) {

        /*Задание 1*/

        //добавьте обработку исключение ArrayIndexOutOfBoundsException
        int array[] = {1, 2, 3};
        try {
            System.out.println(array[4]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("А вот и ошибочка - " + e);
            System.out.println("А это описание ошибки " + e.getMessage());
        } finally {
            System.out.println("Не надо вызывать то, чего нет.");
        }

        /*Задание 2*/

        LocalTime time = LocalTime.of(22,45, 0);
        LocalDateTime date = LocalDateTime.of(2018, 12, 31, 1, 45);
        System.out.println(time);
        System.out.println(date);
    }

}
