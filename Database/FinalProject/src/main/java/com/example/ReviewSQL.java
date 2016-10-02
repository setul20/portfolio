package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class ReviewSQL {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public List<Review> findAll() {
        return jdbcTemplate.query(
            "SELECT reviewNum, rtype, reviewBody, rating FROM review",
                (rs, rowNum) -> new Review(rs.getLong("reviewNum"),
                rs.getString("rtype"), rs.getString("reviewBody"), rs.getInt("rating")));
    }
	
	public void update(Review review) {
        jdbcTemplate.update(
            "UPDATE review SET rtype=?, reviewBody=?, rating=?  WHERE reviewNum=?",
            review.getReviewNum(), review.getType(),review.getReviewBody(),review.getRating());
    }
	
	public void insert(Review review){
		String SQL = "INSERT INTO review (rtype,reviewBody,rating) values (?,?,?)";
		jdbcTemplate.update(SQL, review.getType(), review.getReviewBody(), review.getRating());
	}

public List<Review> select(String type) {
		
		
        return jdbcTemplate.query(
            "SELECT reviewNum, rtype, reviewBody, rating FROM project5.review where rtype= '"+type+"'",
                (rs, rowNum) -> new Review(rs.getLong("reviewNum"),
                rs.getString("rtype"), rs.getString("reviewBody"), rs.getInt("rating")));
    }
	
}