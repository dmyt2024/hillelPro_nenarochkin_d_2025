package org.lesson_32_logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class CoffeeOrderBoard {


    private static final Logger logger = LogManager.getLogger();

    private final List<Order> orders = new LinkedList<>();

    private int orderNumberToSet = 1;


    public void add(Order order) {
        try {
            if (order == null) {
                throw new IllegalArgumentException("Your order null");
            }
            order.setOrderNumber(orderNumberToSet++);
            orders.add(order);
            logger.info("Added order: {};  name: {};  type: {}."
                    , order.getOrderNumber()
                    , order.getNameCustomer()
                    , order.getCoffeeType());
        } catch (IllegalArgumentException e) {
            logger.error("ERROR add order: {}", e.getMessage(), e);
        }
    }

    public void deliver() {
        try {
            if (orders.isEmpty()) {
                logger.warn("No orders to be delivered");
                return;
            }
            Order order = orders.remove(0);
            logger.info("Delivered order: {}; name {}; type {}."
                    , order.getOrderNumber()
                    , order.getNameCustomer()
                    , order.getCoffeeType());
        } catch (Exception e) {
            logger.error("ERROR by delivering", e);
        }
    }

    public void deliver(int orderNumber) {
        try {
            Optional<Order> orderToDeliver = orders.stream()
                    .filter(order -> order.getOrderNumber() == orderNumber)
                    .findFirst();
            if (orderToDeliver.isPresent()) {
                orders.remove(orderToDeliver.get());
                logger.info("Delivered order number: {}; name: {}; type: {}."
                        , orderToDeliver.get().getOrderNumber()
                        , orderToDeliver.get().getNameCustomer()
                        , orderToDeliver.get().getCoffeeType());
            } else
                throw new NoSuchElementException("Order with number " + orderNumber + " not found");
        } catch (NoSuchElementException e) {
            logger.error("ERROR deliver by order number {}:", e.getMessage(), e);
        } catch (Exception e) {
            logger.error("UNKNOWN ERROR by delivering", e);
        }
    }


    public void draw() {
        System.out.println("NUM | NAME   | COFFEE_TYPE");
        orders.stream()
                .sorted(Comparator.comparing(Order::getOrderNumber))
                .forEach(order -> System.out.printf("%3d | %-6s | %-10s%n"
                        , order.getOrderNumber()
                        , order.getNameCustomer()
                        , order.getCoffeeType()));
    }
}
