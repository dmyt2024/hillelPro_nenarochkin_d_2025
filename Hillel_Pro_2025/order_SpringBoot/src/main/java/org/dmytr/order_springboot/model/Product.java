package org.dmytr.order_springboot.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Product {
    private int id;
    private String name;
    private double price;
}
