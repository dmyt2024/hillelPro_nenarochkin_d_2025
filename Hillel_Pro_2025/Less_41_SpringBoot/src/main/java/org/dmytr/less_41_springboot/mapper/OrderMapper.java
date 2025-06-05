package org.dmytr.less_41_springboot.mapper;

import org.dmytr.less_41_springboot.model.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

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
