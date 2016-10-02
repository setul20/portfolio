package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class CustomerSQL {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public List<Customer> findAll() {
        return jdbcTemplate.query(
            "SELECT cID, firstName, lastName, Email, Phone FROM customer",
                (rs, rowNum) -> new Customer(rs.getLong("cID"),
                rs.getString("firstName"), rs.getString("lastName"), rs.getString("Email"), rs.getString("Phone")));
    }
	
	public void update(Customer customer) {
        jdbcTemplate.update(
            "UPDATE customer SET firstName=?, lastName=?, Email=?, Phone=?  WHERE cID=?",
            customer.getFirstName(), customer.getLastName(),customer.getEmail(),customer.getPhone(), customer.getcID());
    }
	
	public void insert(Customer customer){
		String SQL = "INSERT INTO customer (firstName,lastName,Email,Phone) values (?,?,?,?)";
		jdbcTemplate.update(SQL, customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getPhone());
	}

	
}
