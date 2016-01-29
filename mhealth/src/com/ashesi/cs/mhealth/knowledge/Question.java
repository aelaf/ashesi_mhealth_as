package com.ashesi.cs.mhealth.knowledge;

public class Question {
	private int qId;
	private String qContent;
	private int choId;
	private int categoryId;
	private String date;
	private String guid;
	private int rec_state;
	
	public Question(int id, String content, int choId, int catId, String theDate, String g_uid, int recstate) {
		// TODO Auto-generated constructor stub
		qId = id;
		qContent = content;
		this.choId = choId;
		categoryId = catId;
		date = theDate;
		guid = g_uid;
		rec_state = recstate;
	}
	
	public int getId(){
		return qId;
	}
	
	public String getContent(){
		return qContent;
	}
	
	public int getCategoryId(){
		return categoryId;
	}
	
	public int getChoId(){
		return choId;
	}
	
	public String toString(){
		return qContent + " - " + choId + " under category: " + categoryId;
	}
	
	public String getDate(){
		return date;
	}
	
	public String getGuid(){
		return guid;
	}
	
	public int getRecState(){
		return rec_state;
	}

}
