package org.lesson_18;

public class Main {


    public static void main(String[] args) {


        UserRepository userRepository = new UserRepository();

        userRepository.addUser(new User(154, "Petr", "petr@gmail.com"));
        userRepository.addUser(new User(232, "Vasiliy", "vas@gmail.com"));
        userRepository.addUser(new User(356, "Anna", "ann@gmail.com"));

        // Search by ID
        int searchId = 154;
        userRepository.findUserById(searchId)
                .ifPresent(
                        user -> System.out.println("Found user: " + user));

        // Search by E-mail
        String searchEmail = "ann@gmail.com";
        userRepository.findUserByEmail(searchEmail)
                .ifPresent(
                        user -> System.out.println("Found user: " + user));

        // All users
        userRepository.findAllUsers()
                .ifPresent(
                        users -> System.out.println("Count users: " + users.size() + " users."));


    }
}
