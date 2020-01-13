/*
Задача 1. Онлайн-читалка

1) Описание:
Представьте себе, что вы проектируете онлайн-читалку. Как вы думаете, какими объектами мы можем описать такое
приложение? Одним из основных объектов этой предметной области являются книги. Давайте создадим общий класс Book
для них.

Прежде чем приступить к описанию класса, нужно ответить на следующие вопросы:

- Какие характеристики объекта "книга" из реального мира нужно перенести в java class Book (например: количество
страниц)?
- Какой тип будет у каждого поля создаваемого класса?
- Какие методы должны быть у созданного класса (например: сравнить две книги или вывести на печать)?
- Каким будет тип возвращаемых значений, и какими будут входные параметры для этих методов?

После такой подготовки создайте класс Book.java с выбранными полями и методами, которые будут полезны в онлайн-читалке.

Добавьте метод toString() для этого класса, который будет выводить название каждого поля и его значение через запятую.

2) Функционал программы:

- Созданный класс Book

3) Пример реализации:

- Создадим новый replt.it, как написано в инструкции к выполнению домашней работы.
- Создадим класс-файл Book.java

*/

package netology;

import java.util.Date;

public class Homework7t1 {

    private String title = "";
    private Date year = new Date();
    private Object author = new Object();
    private int numPages = 0;
    private String lang = "";
    private int circulation = 0;

    public Homework7t1(String title, Date year, Object author, int numPages, String lang, int circulation) {
        this.title = title;
        this.year = year;
        this.author = author;
        this.numPages = numPages;
        this.lang = lang;
        this.circulation = circulation;
    }

    @Override
    public String toString() {
        return "Homework7t1{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", author=" + author +
                ", numPages=" + numPages +
                ", lang='" + lang + '\'' +
                ", circulation=" + circulation +
                '}';
    }

    //getterr/setters

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public void setAuthor(Object author) {
        this.author = author;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public void setCirculation(int circulation) {
        this.circulation = circulation;
    }

    public String getTitle() {
        return title;
    }

    public Date getYear() {
        return year;
    }

    public Object getAuthor() {
        return author;
    }

    public int getNumPages() {
        return numPages;
    }

    public String getLang() {
        return lang;
    }

    public int getCirculation() {
        return circulation;
    }

}
