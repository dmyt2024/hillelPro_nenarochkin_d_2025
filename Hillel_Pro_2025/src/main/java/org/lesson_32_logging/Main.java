package org.lesson_32_logging;

public class Main {

    public static void main(String[] args) {

        Order order1 = new Order("David", "Capuccino");
        Order order2 = new Order("Tom", "Capuccino");
        Order order3 = new Order("Lisa", "Espresso");

        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();

        coffeeOrderBoard.add(order2);
        coffeeOrderBoard.add(order3);
        coffeeOrderBoard.add(order1);

        coffeeOrderBoard.deliver();
        coffeeOrderBoard.deliver(2);


        coffeeOrderBoard.draw();
    }
}
