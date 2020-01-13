/*
Создадим класс-файл Contact.java со следующими полями:
- Name (Имя — String);
- Surname (Фамилия — String);
- Phone (Номер телефона — String);
- Group (Группа — Enum).
- Переопределим метод toString для этого класса в удобочитаемый вид.
 */

package netology.homework15t1;

public class Contact {

    private String name;
    private String surname;
    private String phone;
    private Group group;

    public Contact(String name, String surname, String phone, Group group) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.group = group;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return  "Имя: " + name +
                ", фамилия: " + surname +
                ", телефон: " + phone +
                ", группа: " + group.getTitle();
    }
}
