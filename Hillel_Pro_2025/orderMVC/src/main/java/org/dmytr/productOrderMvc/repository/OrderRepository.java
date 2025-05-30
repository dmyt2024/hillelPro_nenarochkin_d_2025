package org.dmytr.productOrderMvc.repository;

import org.dmytr.productOrderMvc.model.Order;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository

public class OrderRepository {
    private Map<Integer, Order> orders = new HashMap<>();

    public void addOrder(Order order) {
        orders.put(order.getId(), order);
    }

    public Map<Integer, Order> getAllOrders() {
        return orders;
    }

    public Order getOrderById(int id) {
        return orders.get(id);
    }


}
