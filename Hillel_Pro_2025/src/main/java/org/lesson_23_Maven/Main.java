package org.lesson_23_Maven;

import org.passGenerator.PasswordGenerator;

public class Main {
    public static void main(String[] args) {
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        String password = passwordGenerator.generatePassword(10);
        System.out.println(password);
    }
}
