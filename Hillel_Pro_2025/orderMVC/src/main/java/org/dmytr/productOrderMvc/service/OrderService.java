package org.dmytr.productOrderMvc.service;


import org.dmytr.productOrderMvc.model.Order;
import org.dmytr.productOrderMvc.model.Product;
import org.dmytr.productOrderMvc.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    private final OrderRepository repository;

    @Autowired
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public void createOrder(Order order) {
        if( order.getCreationDate() == null ) {
            order.setCreationDate(LocalDateTime.now());
        }
        double total  = calculateTotal(order.getProducts());
        order.setTotalCost(total);
        repository.addOrder(order);
    }

    public Map<Integer,Order> getOrders() {
       return repository.getAllOrders();
    }

    public Order getOrderById(int id) {
        return repository.getOrderById(id);
    }

    private double calculateTotal(List<Product> products) {
        if (products == null)return 0;
        return products.stream()
                .mapToDouble(Product::getCost)
                .sum();
    }
}
