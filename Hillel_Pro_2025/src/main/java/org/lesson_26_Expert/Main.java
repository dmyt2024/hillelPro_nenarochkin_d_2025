package org.lesson_26_Expert;

public class Main {
    public static void main(String[] args) {

        Address address = new Address("01010, Odessa, Grushevskogo str, 67");
        User user = new User("Petr");


        user.setAddress(address);
        System.out.println(user.getAddress());
    }
}
