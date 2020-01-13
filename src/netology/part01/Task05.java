/*Задание 1
Предположим, что мы создаем программу для семейного архива, в котором должна храниться информация о всех членах семьи:
имя, пол, возраст, имя отца, имя матери.

Для создания архива создадим класс Human, в котором описаны атрибуты (имя, пол, возраст, имя отца, имя матери) и
конструктор, для создания новых экземпляров класса (прабабушка, бабушка, мама и т.д.).

Воспользуйтесь готовым проектом: https://repl.it/@Netology/JavaStart51. В нем уже создан для вас класс Human с
атрибутами и конструктор.

Предположим, что информация о прапрадедушках, прапрабабушках и отце нам уже известна. В классе Main в проекте уже
созданы экземпляры классов, например:

Human grandmaFromMotherSide = new Human("Olga", "Ж", 71, null, null);
Алгоритм решения:
Сделайте Fork (копию) данного проекта у себя;

Создайте экземпляр класса с именем “mother”;

В конструкторе экземпляра “mother” передайте экземпляр объекта grandpaFromMotherSide в качестве отца и
grandmaFromMotherSide в качестве матери;

Вызовите метод getInfo, который выведет на экран информацию о членах семьи;

Создайте два экземпляра класса (двоих детей разных полов, от родителей “mother” и “father”) и также вызвать метод getInfo.

Задание 2
Предположим, что мы создаем программу для онлайн-библиотеки. Объектами в данной системе могут быть: “Пользователь”,
“Книга”, “Издательство”, “Администратор библиотеки”.

Мы напишем часть программы и поработаем с объектом “Книга”. Опишем класс “Книга”.

Название класса — Book, его атрибуты:

фамилия автора (authorSurname - тип String),
имя автора (authorName - тип String),
название книги (name - тип String),
количество страниц (pages - тип int),
год издания (year - тип String).
Алгоритм решения:
Создайте новый repl на сайте repl.it;

Создайте класс Book, описать все атрибуты;

Создайте конструктор, принимающий в качестве параметров все 5 атрибутов;

Cоздайте метод getInfo() в этом классе, который будет выводить информацию об экземпляре класса;

Создайте три экземпляра класса Book и вызовите метод getInfo() на каждом.

Решение заданий вы получите в материалах к следующему занятию.*/

package netology.part01;

public class Task05 {

        public static void main(String[] args) {

            /*Задание 1*/

            Human grandpaFromFatherSide = new Human("Nikolay", "M", 72, null, null);
            Human grandpaFromMotherSide = new Human("Alexey", "M", 67, null, null);

            Human grandmaFromMotherSide = new Human("Olga", "Ж", 71, null, null);
            Human grandmaFromFatherSide = new Human("Irina", "Ж", 70, null, null);
            Human father = new Human("Pavel", "M", 47, grandpaFromFatherSide, grandmaFromFatherSide);

            System.out.println(grandpaFromFatherSide.getInfo());
            System.out.println(grandpaFromMotherSide.getInfo());
            System.out.println(grandmaFromMotherSide.getInfo());
            System.out.println(grandmaFromFatherSide.getInfo());
            System.out.println(father.getInfo());

            /*Задание 2*/

            Book sherlockBook = new Book("Doil", "Arthur", "The Adventures of Sherlock Holmes", 339, "1998");
            Book redDragonBook = new Book("Harris", "Thomas", "Red Dragon", 502, "1981");
            Book bookStivenKing = new Book("King", "Stephen", "Dreamcatcher", 620, "2001");

            System.out.println(sherlockBook.getInfo());
            System.out.println(redDragonBook.getInfo());
            System.out.println(bookStivenKing.getInfo());

        }

    }
