package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class InventorySQL {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public List<Inventory> findAll() {
        return jdbcTemplate.query(
            "SELECT invID, stockStatus, itemLocation, itype FROM inventory",
                (rs, rowNum) -> new Inventory(rs.getLong("invID"),
                rs.getString("stockStatus"), rs.getString("itemLocation"), rs.getString("itype")));
    }
	
	public void update(Inventory inventory) {
        jdbcTemplate.update(
            "UPDATE inventory SET stockStatus=?, itemLocation=?, itype=?  WHERE invID=?",
            inventory.getStockStatus(), inventory.getitemLocation(),inventory.gettype(),inventory.getInvID());
    }
	
	public void insert(Inventory inventory){
		String SQL = "INSERT INTO inventory (stockStatus,itemLocation,itype) values (?,?,?)";
		jdbcTemplate.update(SQL, inventory.getStockStatus(), inventory.getitemLocation(), inventory.gettype());
	}
	
	public List<Inventory> select(String type) {
		
		
        return jdbcTemplate.query(
            "SELECT invID, stockStatus, itemLocation,itype FROM project5.inventory where itype= '"+type+"'",
                (rs, rowNum) -> new Inventory(rs.getLong("invID"),
                rs.getString("stockStatus"), rs.getString("itemLocation"), rs.getString("itype")));
    }

	
}