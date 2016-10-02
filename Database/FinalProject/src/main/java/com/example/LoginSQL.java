package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class LoginSQL {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public List<Login> findAll() {
        return jdbcTemplate.query(
            "SELECT loginID, user, password FROM login",
                (rs, rowNum) -> new Login(rs.getLong("loginID"),
                rs.getString("user"), rs.getString("password")));
    }
	


	
}