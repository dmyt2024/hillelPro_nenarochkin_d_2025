package org.dmytr.productOrderMvc.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Order {
    private int id;

    @JsonFormat(pattern = "dd-MM-yyyy  HH:mm:ss")
    private LocalDateTime creationDate;
    private double totalCost;
    private List<Product> products;
}
