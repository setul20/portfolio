package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class EquipmentSQL {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public List<Equipment> findAll() {
        return jdbcTemplate.query(
            "SELECT type, rentalCost, replacementFee, imageURL FROM equipment",
                (rs, rowNum) -> new Equipment(rs.getString("type"),
                rs.getString("rentalCost"), rs.getString("replacementFee"), rs.getString("imageURL")));
    }
	
	public void update(Equipment equipment) {
        jdbcTemplate.update(
            "UPDATE equipment SET rentalCost=?, replacementFee=?, imageURL=?  WHERE type=?",
            equipment.getRentalCost(), equipment.getReplacementFee(),equipment.getImageURL(),equipment.getType());
    }
	
	public void insert(Equipment equipment){
		String SQL = "INSERT INTO equipment (rentalCost,replacementFee,imageURL) values (?,?,?)";
		jdbcTemplate.update(SQL, equipment.getRentalCost(), equipment.getReplacementFee(), equipment.getImageURL());
	}

	
}