package org.dmytr.less_41_springboot.controller;

import lombok.AllArgsConstructor;
import org.dmytr.less_41_springboot.model.Order;
import org.dmytr.less_41_springboot.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;


    @PostMapping("/addOrder")
    public void addOrder(@RequestBody Order order) {
        orderService.addOrder(order);
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<?> getAllOrders() {
        try {
            List<Order> orders = orderService.getAllOrders();
            return ResponseEntity.ok(orders);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("ERROR receiving order: " + e.getMessage());
        }
    }


    @DeleteMapping("/deleteOrder/{id}")
    public void deleteOrder(@PathVariable int id) {
        orderService.deleteOrderById(id);
    }

    @GetMapping("/getOrder/{id}")
    public Order getOrderById(@PathVariable int id) {
        return orderService.getOrderById(id);
    }

    @PutMapping("/updateOrder")
    public void updateOrder(@RequestBody Order order) {
        orderService.updateOrder(order);
    }
}
