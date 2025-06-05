package org.dmytr.order_springboot.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class Order {
    private int id;
    private double totalCost;
    private List<Product> products;

    @JsonFormat(pattern = "dd-MM-yyyy  HH:mm:ss")
    private LocalDateTime creationDate;
}
