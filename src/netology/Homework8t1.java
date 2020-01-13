/*
Задача 1. Иерархия "Статусы книг"

1) Описание:

Рассмотрим предметную область обычной библиотеки. У каждой книги есть один из следующих статусов: взято в пользование
(BORROWED), доступно (AVAILABLE), задержана (OVERDUED), в архиве (ARCHIVED).

Из одного статуса доступно только ограниченное число статусов. Диаграмма переходов указана здесь:

Необходимо с помощью наследования реализовать программу, в которой будет 4 наследника базового класса BookMover по
переводу статуса книги из одного в другой. Данный функционал пригодится в случае массового перевода книг в какой-то
статус, но мы пока рассмотрим перевод только одной книги.

Также необходимо будет описать класс Book с базовым набором полей 'title' и 'status'.

2) Функционал программы:

- Создание книги с начальным статусом AVAILABLE;
- Возможноcть перевода из статуса AVAILABLE только в статус BORROWED или ARCHIVED (так же в другие статусы согласно
схеме);
- В случае перевода книги в недопустимый для нее статус вывести сообщение: "Перевод книги из статуса 'X' в статус 'Y'
невозможен".

3) Процесс реализации:

- Создайте Enum класс StatusEnum с 4 возможными статусами в нашей программе.
- Создайте класс BookMover с дефолтной реализацией метода moveToStatus.

protected void moveToStatus(Book book, StatusEnum requestedStatus) {
System.out.println("Moving status...");
}

- Создайте 4 наследника данного класса. Например: FromArchievedStatusMover — класс, в котором будут происходить
проверка и переход книги из статуса ARCHIVED в запрашиваемый статус, если он возможен. Если он невозможен,
то вывести сообщение: "Перевод книги из статуса 'X' в статус 'Y' невозможен". Проверку доступности необходимо сделать,
используя Enum, созданный на первом шаге, оператор switch и диаграмму переходов.
- В классе Main.java необходимо будет создать объект класса Book, используя конструктор. Убедитесь, что функции
перехода были реализованы верно и статус у книги корректный. Например:

Book book = new Book("The Lord of the Rings");
BookMover fromAvailableStatusMover = new FromAvailableStatusMover();
fromAvailableStatusMover.moveToStatus(book, StatusEnum.BORROWED);
System.out.println(book.getStatus());

*/

package netology;

import java.util.ArrayList;

public class Homework8t1 {

    public static void main(String[] args) {

        ArrayList<StatusEnum> statuses = new ArrayList<>();

        statuses.add(StatusEnum.AVAILABLE);
        statuses.add(StatusEnum.OVERDUED);
        statuses.add(StatusEnum.BORROWED);
        statuses.add(StatusEnum.ARCHIVED);

        Book book = new Book("Book one");
        BookMover mover = new BookMover();

        for (int i = 0; i < statuses.size(); i++) {
            book.setStatus(statuses.get(i));
            mover = MoverFactory.getMover(book);
            mover.moveToStatus(book, StatusEnum.AVAILABLE);
            mover.moveToStatus(book, StatusEnum.OVERDUED);
            mover.moveToStatus(book, StatusEnum.BORROWED);
            mover.moveToStatus(book, StatusEnum.ARCHIVED);
        }
    }

    public enum StatusEnum {
        BORROWED,
        AVAILABLE,
        OVERDUED,
        ARCHIVED
    }

    public static class Book {

        private String title = "";
        private StatusEnum status = StatusEnum.AVAILABLE;

        public Book(String title) {
            this.title = title;
            System.out.println("\nNew book created: " + this.title);
            System.out.println("Status: " + this.status);
        }

        public Book(String title, StatusEnum status) {
            this.title = title;
            this.status = status;
            System.out.println("\nNew book created: " + this.title);
            System.out.println("Status: " + this.status);
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public StatusEnum getStatus() {
            return status;
        }

        public void setStatus(StatusEnum status) {
            this.status = status;
        }
    }

    public static class MoverFactory {

        public static BookMover getMover(Book book) {

            BookMover mover = new BookMover();

            switch (book.getStatus()) {
                case AVAILABLE:
                    mover = new FromAvailableMover();
                    break;
                case OVERDUED:
                    mover = new FromOverduedMover();
                case BORROWED:
                    mover = new FromBorrowedMover();
                case ARCHIVED:
                    mover = new FromArchiveMover();
            }

            return mover;
        }
    }

    public static class BookMover {

        protected void moveToStatus(Book book, StatusEnum requestedStatus) {

            System.out.println("\nMoving status for book: " + book.getTitle());
            System.out.println("Current status: " + book.getStatus());
            System.out.println("Requested status change: " + requestedStatus);
        }

    }

    public static class FromArchiveMover extends BookMover {

        @Override
        protected void moveToStatus(Book book, StatusEnum requestedStatus) {
            super.moveToStatus(book, requestedStatus);
            switch (requestedStatus) {
                case ARCHIVED:
                    System.out.println("\n -- Change rejected: the book is already ARCHIVED");
                    break;
                case BORROWED:
                case OVERDUED:
                    System.out.println("\n -- Change rejected: unacceptable change");
                    break;
                case AVAILABLE:
                    System.out.println("\n -- Book " +
                                        book.getTitle() +
                                        ": status changed from " +
                                        book.getStatus() +
                                        " to " +
                                        requestedStatus
                    );
                    book.setStatus(StatusEnum.AVAILABLE);
                    break;
            }
        }
    }

    public static class FromAvailableMover extends BookMover {

        @Override
        protected void moveToStatus(Book book, StatusEnum requestedStatus) {
            super.moveToStatus(book, requestedStatus);
            switch (requestedStatus) {
                case ARCHIVED:
                    System.out.println("\n -- Book " +
                            book.getTitle() +
                            ": status changed from " +
                            book.getStatus() +
                            " to " +
                            requestedStatus
                    );
                    book.setStatus(StatusEnum.ARCHIVED);
                    break;
                case BORROWED:
                    System.out.println("\n -- Book " +
                            book.getTitle() +
                            ": status changed from " +
                            book.getStatus() +
                            " to " +
                            requestedStatus
                    );
                    book.setStatus(StatusEnum.BORROWED);
                    break;
                case OVERDUED:
                    System.out.println("\n -- Change rejected: unacceptable change");
                    break;
                case AVAILABLE:
                    System.out.println("\n -- Change rejected: the book is already AVAILABLE");
                    break;
            }
        }

    }

    public static class FromBorrowedMover extends BookMover {

        @Override
        protected void moveToStatus(Book book, StatusEnum requestedStatus) {
            super.moveToStatus(book, requestedStatus);
            switch (requestedStatus) {
                case ARCHIVED:
                    System.out.println("\n -- Book " +
                            book.getTitle() +
                            ": status changed from " +
                            book.getStatus() +
                            " to " +
                            requestedStatus
                    );
                    book.setStatus(StatusEnum.ARCHIVED);
                    break;
                case BORROWED:
                    System.out.println("\n -- Change rejected: the book is already AVAILABLE");
                    break;
                case OVERDUED:
                    System.out.println("\n -- Book " +
                            book.getTitle() +
                            ": status changed from " +
                            book.getStatus() +
                            " to " +
                            requestedStatus
                    );
                    book.setStatus(StatusEnum.OVERDUED);
                    break;
                case AVAILABLE:
                    System.out.println("\n -- Book " +
                            book.getTitle() +
                            ": status changed from " +
                            book.getStatus() +
                            " to " +
                            requestedStatus
                    );
                    book.setStatus(StatusEnum.AVAILABLE);
                    break;
            }
        }

    }

    public static class FromOverduedMover extends BookMover {

        @Override
        protected void moveToStatus(Book book, StatusEnum requestedStatus) {
            super.moveToStatus(book, requestedStatus);
            switch (requestedStatus) {
                case ARCHIVED:
                    System.out.println("\n -- Book " +
                            book.getTitle() +
                            ": status changed from " +
                            book.getStatus() +
                            " to " +
                            requestedStatus
                    );
                    book.setStatus(StatusEnum.ARCHIVED);
                    break;
                case BORROWED:
                    System.out.println("\n -- Change rejected: unacceptable change");
                    break;
                case OVERDUED:
                    System.out.println("\n -- Change rejected: the book is already OVERDUED");
                    break;
                case AVAILABLE:
                    System.out.println("\n -- Book " +
                            book.getTitle() +
                            ": status changed from " +
                            book.getStatus() +
                            " to " +
                            requestedStatus
                    );
                    book.setStatus(StatusEnum.AVAILABLE);
                    break;
            }
        }

    }
}
