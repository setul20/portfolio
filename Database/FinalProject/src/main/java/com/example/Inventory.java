package com.example;

public class Inventory {
	private long invID;
	private String stockStatus, itemLocation, itype;
	
	public Inventory(long invID, String stockStatus, String itemLocation, String itype){
		this.invID =invID;
		this.stockStatus = stockStatus;
		this.itemLocation = itemLocation;
		this.itype = itype;
	}
	
	public long getInvID(){
		return this.invID;
	}
	public void setInvID(long invID){
		this.invID = invID;
	}
	
	public String getStockStatus(){
		return this.stockStatus;
	}
	public void setStockStatus(String stockStatus){
		this.stockStatus=stockStatus;
	}
	
	public String getitemLocation(){
		return this.itemLocation;
	}
	public void setitemLocation(String itemLocation){
		this.itemLocation=itemLocation;
	}
	
	public String gettype(){
		return this.itype;
	}
	public void settype(String itype){
		this.itype=itype;
	}
}
