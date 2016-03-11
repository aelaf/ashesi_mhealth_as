package com.ashesi.cs.mhealth.data;

public class OPDCase {
	private int id;
	private String opdCaseName;
	private int category;
	private int displayOrder;
	private String gdrg;
	private float charge;

	public OPDCase(){
		
	}
	public OPDCase(int id, String opdCaseName){
		this.id=id;
		this.opdCaseName=opdCaseName;
	}
	
	public OPDCase(int id, String opdCaseName, int category){
		this.id=id;
		this.opdCaseName=opdCaseName;
		this.category=category;
	}
	
	public OPDCase(int id, String opdCaseName, int category, int displayOrder){
		this.id=id;
		this.opdCaseName=opdCaseName;
		this.category=category;
		this.displayOrder=displayOrder;
	}
	public OPDCase(int id, String opdCaseName, int category, int displayOrder,String gdrg, float charge){
		this.id=id;
		this.opdCaseName=opdCaseName;
		this.category=category;
		this.displayOrder=displayOrder;
		this.gdrg = gdrg;
		this.charge = charge;
	}
	public int getID(){
		return id;
	}
	
	public String getOPDCaseName(){
		return opdCaseName;
	}
	
	public int getCategory(){
		return category;
	}
	
	public int getDisplayOrder(){
		return displayOrder;
	}
	
	public String toString(){
		return opdCaseName;
	}
	
	
	
}
