package com.example;

public class Equipment {
	private String type, rentalCost, replacementFee, imageURL;
	
	
	public Equipment(String type, String rentalCost, String replacementFee, String imageURL){
		this.type = type;
		this.rentalCost = rentalCost;
		this.replacementFee = replacementFee;
		this.imageURL=imageURL;
	}
	
	public String getType(){
		return this.type;
	}
	
	public void setType(String type){
		this.type=type;
		
	}
	
	public String getRentalCost(){
		return this.rentalCost;
	}
	public void setRentalCost(String rentalCost){
		this.rentalCost = rentalCost;
	}
	
	public String getReplacementFee(){
		return this.replacementFee;
	}
	public void setReplacementFee(){
		this.replacementFee = replacementFee;
	}
	
	public String getImageURL(){
		return this.imageURL;
	}
	public void setImageURL(String imageURL){
		this.imageURL = imageURL;
	}
}
