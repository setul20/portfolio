package com.example;

public class Rentals {
	
	private long rID, custID, itemID;
	private String outDate, inDate, dueDate;
	
	public Rentals(long rID, long custID, long itemID, String outDate, String inDate, String dueDate){
		this.rID =rID;
		this.custID =custID;
		this.itemID =itemID;
		this.outDate = outDate;
		this.inDate = inDate;
		this.dueDate = dueDate;
	}
	
	public long getrID(){
		return this.rID;
	}
	public void setrID(long rID){
		this.rID = rID;
	}
	
	public long getcustID(){
		return this.custID;
	}
	public void setcustID(long custID){
		this.custID = custID;
	}
	
	public long getitemID(){
		return this.itemID;
	}
	public void setitemID(long itemID){
		this.itemID = itemID;
	}
	
	
	public String getoutDate(){
		return this.outDate;
	}
	public void setoutDate(String outDate){
		this.outDate=outDate;
	}
	
	public String getinDate(){
		return this.inDate;
	}
	public void setinDate(String inDate){
		this.inDate=inDate;
	}
	
	public String getdueDate(){
		return this.dueDate;
	}
	public void setdueDate(String dueDate){
		this.dueDate=dueDate;
	}
}
