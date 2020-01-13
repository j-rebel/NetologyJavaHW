/*
Задача 2. Учетная запись пользователя

1) Описание:

Давайте создадим учетную запись пользователя онлайн-библиотеки, используя которую, мы сможем хранить, передавать и
выводить на экран данные о книге или книгах, которые читает пользователь.

2) Функционал программы:

- Класс "Пользователь" (User) с полями: интернет-почта, имя и фамилия (email, name, surname).
- Класс "Автор" (Author) c полями: имя, фамилия, год рождения, страна (name, surname, birthday, country).
- Класс "Книга" (Book) с полями: автор, количество страниц, год издания (author, pages, year).
- Свяжите между собой классы Author, Book и User (использовать списки или массивы не обязательно)
- Создайте метод toString у класса User и выведите в консоль подробную информацию о пользователе (значения полей нужно
разделить запятой): какие книги он читает.

3) Пример реализации:

- Создайте новый проект в repl.it.
- Создайте класс User.
- Создайте класс Author.
- Создайте класс Book.
- Подумайте, как можно связать между собой эти классы (как классы зависят друг от друга), и используйте один класс в
другом.
- В классе Main.java в методе main должен создаваться объект класса User. Заполните все поля создаваемого объекта.
- Выведите значения всех полей созданного объекта.
*/


package netology;

import java.util.ArrayList;

public class Homework7t2 {

    public static void main(String[] args) {

        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Братья Карамазовы",new Author("Достоевский")));
        books.add(new Book("Тени",new Author("Салтыков-Щедрин")));
        books.add(new Book("В ожидании варваров",new Author("Кутзее")));
        books.add(new Book("Космическая одиссея",new Author("Кларк")));

        User user = new User("Пользователь 1", books);
        System.out.println(user);
    }

    public static class User {

        private String name = "";
        private ArrayList<Book> booksRead = new ArrayList<>();

        public User(String name, ArrayList<Book> booksRead) {
            this.name = name;
            this.booksRead = booksRead;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public ArrayList<Book> getBooksRead() {
            return booksRead;
        }

        public void setBooksRead(ArrayList<Book> booksRead) {
            this.booksRead = booksRead;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", booksRead=" + booksRead +
                    '}';
        }
    }

    public static class Author {

        private String name = "";
        private ArrayList<Book> booksBy = new ArrayList<>();

        public Author(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public ArrayList<Book> getBooksBy() {
            return booksBy;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setBooksBy(ArrayList<Book> booksBy) {
            this.booksBy = booksBy;
        }

        public void addBooksBy(Book book) {
            this.booksBy.add(book);
        }

        @Override
        public String toString() {
            return "Author{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static class Book {

        private String title = "";
        Author author = new Author("");

        public Book(String title, Author author) {
            this.title = title;
            this.author = author;
            author.addBooksBy(this);
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Author getAuthor() {
            return author;
        }

        public void setAuthor(Author author) {
            this.author = author;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "title='" + title + '\'' +
                    ", author=" + author +
                    '}';
        }
    }

}
