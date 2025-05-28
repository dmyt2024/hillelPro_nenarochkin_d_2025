package org.dmytr.customer.dao;

import lombok.AllArgsConstructor;
import org.dmytr.customer.dto.Customer;
import org.dmytr.customer.mapper.CustomerMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class CustomerDao {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void add(Customer customer) {
        String sql = """
                INSERT INTO customer(fullName, email, socialSecurityNumber) 
                VALUES (?,?,?)
                """;

        jdbcTemplate.update(sql, customer.getFullName(), customer.getEmail(), customer.getSocialSecurityNumber());
    }

    public Customer findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM customer WHERE id=?", new CustomerMapper(), id);


    }

    public List<Customer> getAll() {
        return jdbcTemplate.query("SELECT * FROM customer", new BeanPropertyRowMapper<>(Customer.class));
    }

    public Customer getNamed(int id, String name) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("id", id)
                .addValue("fullName", name);
        String sql = """
                SELECT * FROM customer WHERE id=:id AND fullName=:fullName
                """;
        return namedParameterJdbcTemplate.queryForObject(sql, sqlParameterSource, new CustomerMapper());
    }

    public void deleteById(int id) {
        jdbcTemplate.update("DELETE FROM customer WHERE id=?", id);
    }

    public void update(Customer customer) {
        String sql = """
                UPDATE customer
                        SET fullName = ?, email = ?, socialSecurityNumber = ?
                        WHERE id = ?
                """;
        jdbcTemplate.update(sql,
                customer.getFullName(),
                customer.getEmail(),
                customer.getSocialSecurityNumber(),
                customer.getId());
    }


}
