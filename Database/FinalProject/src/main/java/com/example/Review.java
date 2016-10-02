package com.example;

public class Review {

	private long reviewNum;
	private String rtype, reviewBody;
	private int rating;
	
	public Review(long reviewNum, String rtype, String reviewBody, int rating){
		this.reviewNum=reviewNum;
		this.rtype =rtype;
		this.reviewBody = reviewBody;
		this.rating=rating;
	}
	
	public long getReviewNum(){
		return this.reviewNum;
	}
	public void setReviewNum(long reviewNum){
		this.reviewNum=reviewNum;
	}
	
	public String getType(){
		return this.rtype;
	}
	public void setType(String rtype){
		this.rtype=rtype;
	}
	
	public String getReviewBody(){
		return this.reviewBody;
	}
	public void setReviewBody(String reviewBody){
		this.reviewBody=reviewBody;
	}
	
	public int getRating(){
		return this.rating;
	}
	public void setRating(int rating){
		this.rating = rating;
	}
}
