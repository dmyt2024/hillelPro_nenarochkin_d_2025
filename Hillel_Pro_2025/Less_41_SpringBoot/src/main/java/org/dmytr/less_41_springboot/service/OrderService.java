package org.dmytr.less_41_springboot.service;

import lombok.AllArgsConstructor;
import org.dmytr.less_41_springboot.model.Order;
import org.dmytr.less_41_springboot.model.Product;
import org.dmytr.less_41_springboot.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;


    public void addOrder(Order order) {
        if (order.getCreationDate() == null) {
            order.setCreationDate(LocalDateTime.now());
        }
        double total = calculateTotal(order.getProducts());
        order.setTotalCost(total);
        orderRepository.addOrder(order);

    }

    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    public void deleteOrderById(int id) {
        orderRepository.deleteOrderById(id);
    }

    public Order getOrderById(int id) {
        return orderRepository.getOrderById(id);
    }


    public void updateOrder(Order order) {
        if (order.getCreationDate() == null) {
            order.setCreationDate(LocalDateTime.now());
        }
        double total = calculateTotal(order.getProducts());
        order.setTotalCost(total);
        orderRepository.updateOrder(order);
    }

    public List<Product> getProductsById(int id) {
        return orderRepository.productsByOrderId(id);
    }

    private double calculateTotal(List<Product> products) {
        if (products == null) return 0;
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
}
