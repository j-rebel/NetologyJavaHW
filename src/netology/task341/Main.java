package netology.task341;


import java.util.ArrayList;
import java.util.Scanner;

class Main {

    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {
        String[] arrToCheck = getInput();
        checkInput(arrToCheck[0], arrToCheck[1], getUsers());
    }

    public static String[] getInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();

        return new String[]{login, password};
    }

    public static User checkInput(String login, String password, ArrayList<User> users) throws UserNotFoundException, AccessDeniedException {
        for (User user : users) {
            if(user.getLogin().equals(login) && user.getPassword().equals(password)) {
                if(user.getAge() >= 18) {
                    System.out.println("Access granted!");
                    return user;
                } else {
                    throw new AccessDeniedException("Access denied!");
                }
            }
        }
        throw new UserNotFoundException("User not found!");
    }

    public static ArrayList<User> getUsers() {
        ArrayList<User> res = new ArrayList<User>();
        res.add(new User("logOne", "passOne", 16));
        res.add(new User("logTwo", "passTwo", 17));
        res.add(new User("logThree", "passThree", 18));
        res.add(new User("logFour", "passFour", 19));
        res.add(new User("logFive", "passFive", 20));
        return res;
    }
}