package org.dmytr.less_41_springboot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Order {
    private int id;
    private double totalCost;
    private List<Product> products;

    @JsonFormat(pattern = "dd-MM-yyyy  HH:mm:ss")
    private LocalDateTime creationDate;
}

