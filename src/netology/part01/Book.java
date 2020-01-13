package netology.part01;

public class Book {
    public String authorSurname;
    public String authorName;
    public String name;
    public int pages;
    public String year;

    Book(String authorSurname, String authorName, String name, int pages, String year) {
        this.authorSurname = authorSurname;
        this.authorName = authorName;
        this.name = name;
        this.pages = pages;
        this.year = year;
    }

    public String getInfo() {
        String text = "";
        text += "Фамилия автора: " + this.authorSurname;
        text += ", имя автора: " + this.authorName;
        text += ", название книги: " + this.name;
        text += ", количество страниц: " + this.pages;
        text += ", год издания: " + this.year;
        return text;
    }
}
