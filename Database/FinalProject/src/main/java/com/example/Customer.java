package com.example;

public class Customer{
	private long cID;
	private String firstName, lastName, Email, Phone;
	
	public Customer(long cID, String firstName, String lastName, String Email, String Phone){
		this.cID = cID;
		this.firstName = firstName;
		this.lastName= lastName;
		this.Email= Email;
		this.Phone= Phone;
	}
	
	public long getcID(){
		return this.cID;
	}
	public void setcID(long cID){
		this.cID = cID;
	}
	
	public String getFirstName(){
		return this.firstName;
	}
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public String getLastName(){
		return this.lastName;
	}
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public String getEmail(){
		return this.Email;
	}
	public void setEmail(String Email){
		this.Email = Email;
	}
	
	public String getPhone(){
		return this.Phone;
	}
	public void setPhone(String Phone){
		this.Phone = Phone;
	}
	
}