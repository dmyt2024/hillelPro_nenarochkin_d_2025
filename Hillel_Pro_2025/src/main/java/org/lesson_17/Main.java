package org.lesson_17;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Product> products = Arrays.asList(
                new Product("BMW", "car", 50000.0),
                new Product("Philips", "appliances", 1500.0),
                new Product("Tesla", "car", 3000.0),
                new Product("Whirpool", "appliances", 5500.0)
        );

        Map<String, Double> collect = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.averagingDouble(Product::getPrice)));


        Optional<Map.Entry<String, Double>> highAverPrice = collect.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        System.out.println("Average price of category: " + collect);
        System.out.println("Highest average price is a category " + highAverPrice.get());


    }
}
