package netology.homework11t2;

public class Employee {

    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String educationLevel;
    private String position;
    private String department;

    public Employee(
            String firstName,
            String lastName,
            int age,
            String gender,
            String educationLevel,
            String position,
            String department) {
                        this.firstName = firstName;
                        this.lastName = lastName;
                        this.age = age;
                        this.gender = gender;
                        this.educationLevel = educationLevel;
                        this.position = position;
                        this.department = department;
                        System.out.println("Создан сотрудник " + lastName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", educationLevel=" + educationLevel +
                ", position='" + position + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
