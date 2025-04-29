package org.lesson_32_logging;

import lombok.Getter;

@Getter

public class Order {

    private String nameCustomer;
    private String coffeeType;
    private int orderNumber;

    public Order(String nameCustomer, String coffeeType) {
        this.nameCustomer = nameCustomer;
        this.coffeeType = coffeeType;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
}
