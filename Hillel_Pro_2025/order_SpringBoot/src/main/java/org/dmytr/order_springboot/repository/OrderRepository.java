package org.dmytr.order_springboot.repository;

import lombok.AllArgsConstructor;
import org.dmytr.order_springboot.mapper.OrderMapper;
import org.dmytr.order_springboot.mapper.ProductMapper;
import org.dmytr.order_springboot.model.Order;
import org.dmytr.order_springboot.model.Product;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository

@AllArgsConstructor
public class OrderRepository {


    private final JdbcTemplate jdbcTemplate;
    //Map<Integer,Order> orders = new HashMap<>();


    public void addOrder(Order order) {
        String sql = """
                INSERT INTO `order`(totalCost, creationDate)
                VALUES (?,?)
                """;

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection ->
        {
            PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, order.getTotalCost());
            ps.setTimestamp(2, Timestamp.valueOf(order.getCreationDate()));
            return ps;

        }, keyHolder);
        int orderId = keyHolder.getKey().intValue();

        String sqlProducts = "INSERT INTO product (name, price, order_id) VALUES (?, ?, ?)";
        List<Product> products = order.getProducts();
        jdbcTemplate.batchUpdate(sqlProducts, new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Product product = products.get(i);
                ps.setString(1, product.getName());
                ps.setDouble(2, product.getPrice());
                ps.setInt(3, orderId);

            }

            @Override
            public int getBatchSize() {
                return products.size();
            }
        });


    }


    public List<Order> getAllOrders() {
        String sql = "SELECT * FROM `order`";
        List<Order> orders = jdbcTemplate.query(sql, new OrderMapper());

        for (Order order : orders) {
            List<Product> products = productsByOrderId(order.getId());
            order.setProducts(products);
        }
        return orders;

    }

    public List<Product> productsByOrderId(int id) {
        String sql = "SELECT * FROM product WHERE order_id = ?";
        return jdbcTemplate.query(sql, new ProductMapper(), id);

    }

    public void deleteOrderById(int id) {
        String deleteProducts = "DELETE FROM product WHERE order_id = ?";
        jdbcTemplate.update(deleteProducts, id);
        String sql = "DELETE FROM `order` WHERE  id = ?";
        jdbcTemplate.update(sql, id);

    }


    public Order getOrderById(int id) {
        String sql = "SELECT * FROM `order` WHERE id=?";
        Order order = jdbcTemplate.queryForObject(sql, new OrderMapper(), id);
        List<Product> products = productsByOrderId(id);
        order.setProducts(products);
        return order;

    }

    public void updateOrder(Order order) {
        String updateOrderSql = "UPDATE `order` SET totalCost = ?, creationDate = ? WHERE id = ?";
        jdbcTemplate.update(updateOrderSql,
                order.getTotalCost(),
                Timestamp.valueOf(order.getCreationDate()),
                order.getId());

        String deleteProductsSql = "DELETE FROM product WHERE order_id = ?";
        jdbcTemplate.update(deleteProductsSql, order.getId());

        String insertProductSql = "INSERT INTO product (name, price, order_id) VALUES (?, ?, ?)";
        List<Product> products = order.getProducts();
        jdbcTemplate.batchUpdate(insertProductSql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Product p = products.get(i);
                ps.setString(1, p.getName());
                ps.setDouble(2, p.getPrice());
                ps.setInt(3, order.getId());
            }

            @Override
            public int getBatchSize() {
                return products.size();
            }
        });
    }


}
