package org.lesson_23;

import org.passGenerator.PasswordGenerator;

public class MainPassGener {
    public static void main(String[] args) {
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        String password = passwordGenerator.generatePassword(12);
        System.out.println("Your password: " + password);

    }
}
