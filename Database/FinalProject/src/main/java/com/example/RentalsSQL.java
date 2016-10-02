package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class RentalsSQL {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public List<Rentals> findAll() {
        return jdbcTemplate.query(
            "SELECT rID, outDate, inDate, itemID, custID, dueDate FROM rentals",
                (rs, rowNum) -> new Rentals(rs.getLong("rID"),rs.getLong("custID"), rs.getLong("itemID"),
                rs.getString("outDate"), rs.getString("inDate"),rs.getString("dueDate")));
    }
	
	public void update(Rentals rental) {
        jdbcTemplate.update(
            "UPDATE rentals SET outDate=?, inDate=?, dueDate=?, itemID=?,custID=?  WHERE rID=?",
            rental.getoutDate(), rental.getinDate(),rental.getdueDate(),rental.getitemID(),rental.getcustID());
    }
	
	public void insert(Rentals rental){
		String SQL = "INSERT INTO rentals (outDate,inDate,dueDate,itemID,custID) values (?,?,?,?,?)";
		jdbcTemplate.update(SQL, rental.getoutDate(), rental.getinDate(), rental.getdueDate(),rental.getitemID(),rental.getcustID());
	}
	
	public List<Rentals> select(long cID) {
		
		
        return jdbcTemplate.query(
            "SELECT rID, outDate, inDate, itemID, custID, dueDate FROM rentals where custID = "+cID+"",
                (rs, rowNum) -> new Rentals(rs.getLong("rID"),rs.getLong("custID"), rs.getLong("itemID"),
                        rs.getString("outDate"), rs.getString("inDate"),rs.getString("dueDate")));
    }

	
}