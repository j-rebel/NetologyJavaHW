/*
Задача 3. Считаем онлайн-пользователей

1) Описание:

Давайте научимся считать, сколько пользователей сейчас находится онлайн в нашей библиотеке. Для этого нужно создать
класс "Пользователь" (User) с полями: интернет-почта, имя и фамилия (email, name, surname).

2) Функционал программы:

- Класс User;
- Подсчет созданных пользователей.

3) Пример реализации:

- Создадим класс User c полями с полями: email, name, surname.
- Добавим к этому классу статическое поле totalOnline, в котором будем подсчитывать, сколько пользователей сейчас
онлайн (не забудьте продумать тип данных для этой переменной).
- В классе Main в одноименном статическом методе необходимо создать не менее 3 пользователей.
- Заполните все объекты класса User (например, именами знаменитостей).
- Во время создания каждого объекта User увеличивайте переменную User.totalOnline на единицу.
- Выведите в консоль, сколько пользователей находятся онлайн (значение поля User.totalOnline).
*/

package netology;

import java.util.Date;

public class Homework7t3 {

    public static void main(String[] args) {

        new Date();

        User user1 = new User("user1@gmail.com", "User", "One");
        User user2 = new User("user2@gmail.com", "User", "Two");
        User user3 = new User("user3@gmail.com", "User", "Three");

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
        System.out.println("Пользователей в сети: " + User.getUserCount());


    }

    public static class User {

        private static int userCount = 0;

        private String email = "";
        private String name = "";
        private String surname = "";

        public User(String email, String name, String surname) {
            this.email = email;
            this.name = name;
            this.surname = surname;
            userCount++;
        }

        public static int getUserCount() {
            return userCount;
        }

        public static void setUserCount(int userCount) {
            User.userCount = userCount;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        @Override
        public String toString() {
            return "User{" +
                    "email='" + email + '\'' +
                    ", name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    '}';
        }
    }

}
