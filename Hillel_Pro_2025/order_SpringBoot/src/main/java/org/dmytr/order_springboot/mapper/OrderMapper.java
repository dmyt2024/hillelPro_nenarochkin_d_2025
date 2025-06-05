package org.dmytr.order_springboot.mapper;

import org.dmytr.order_springboot.model.Order;
import org.dmytr.order_springboot.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();
        order.setId(rs.getInt("id"));
        order.setTotalCost(rs.getDouble("totalCost"));
        order.setCreationDate(rs.getTimestamp("creationDate").toLocalDateTime());
        return order;
    }
}
