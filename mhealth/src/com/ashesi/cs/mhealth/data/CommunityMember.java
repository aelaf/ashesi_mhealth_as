package com.ashesi.cs.mhealth.data;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import org.json.JSONObject;

public class CommunityMember {
	private int id;
	private int serialNo;
	private int communityId;
	private String fullname;
	private String birthdate;
	private String gender;
	private String cardNo;
	public static String MALE="male";
	public static String FEMALE="female";
	private int recState;
	private String communityName;
	private String nhisId;
	private String nhisExpiryDate;
	private boolean isBirthDateConfirmed;
	private String firstAccessDate;
	
	CommunityMember(int id,int serialNo,int communityId,String fullname,String birthdate,int isBirthDateConfirmed, String gender,String cardNo,int recState,String communityName,String nhisId, String nhisExpiryDate, String fristAccessDate){
		this.id=id;
		this.communityId=communityId;
		this.fullname=fullname;
		this.birthdate=birthdate;
		this.gender=gender;
		this.cardNo=cardNo;
		this.recState=recState;
		this.communityName=communityName;
		this.nhisId="none";
		this.nhisExpiryDate="";
		if(isBirthDateConfirmed==1){
			this.isBirthDateConfirmed=true;
		}else{
			this.isBirthDateConfirmed=false;
		}
		this.nhisId=nhisId;
		this.nhisExpiryDate=nhisExpiryDate;
		this.serialNo=serialNo;
		this.firstAccessDate=firstAccessDate;
		
	}
	
	CommunityMember(int id,int serialNo,int communityId,String fullname,String birthdate,int isBirthDateConfirmed, String gender,String cardNo,int recState,String communityName,String nhisId, String nhisExpiryDate){
		this.id=id;
		this.communityId=communityId;
		this.fullname=fullname;
		this.birthdate=birthdate;
		this.gender=gender;
		this.cardNo=cardNo;
		this.recState=recState;
		this.communityName=communityName;
		this.nhisId="none";
		this.nhisExpiryDate="";
		if(isBirthDateConfirmed==1){
			this.isBirthDateConfirmed=true;
		}else{
			this.isBirthDateConfirmed=false;
		}
		this.nhisId=nhisId;
		this.nhisExpiryDate=nhisExpiryDate;
		this.serialNo=serialNo;
		
	}
	
	CommunityMember(int id,int communityId,String fullname,String birthdate,boolean isBirthDateConfirmed, String gender,String cardNo,int recState,String communityName,String nhisId, String nhisExpiryDate){
		this.id=id;
		this.communityId=communityId;
		this.fullname=fullname;
		this.birthdate=birthdate;
		this.gender=gender;
		this.cardNo=cardNo;
		this.recState=recState;
		this.communityName=communityName;
		this.nhisId="none";
		this.nhisExpiryDate="";
		this.isBirthDateConfirmed=true;
		this.nhisId=nhisId;
		this.nhisExpiryDate=nhisExpiryDate;
	}
	
	CommunityMember(int id,int communityId,String fullname,String birthdate,int isBirthDateConfirmed, String gender,String cardNo,int recState,String communityName,String nhisId, String nhisExpiryDate){
		this.id=id;
		this.communityId=communityId;
		this.fullname=fullname;
		this.birthdate=birthdate;
		this.gender=gender;
		this.cardNo=cardNo;
		this.recState=recState;
		this.communityName=communityName;
		this.nhisId="none";
		this.nhisExpiryDate="";
		if(isBirthDateConfirmed==1){
			this.isBirthDateConfirmed=true;
		}else{
			this.isBirthDateConfirmed=false;
		}
		this.nhisId=nhisId;
		this.nhisExpiryDate=nhisExpiryDate;
		
	}
	
	CommunityMember(int id,int communityId,String fullname,String birthdate,String gender,String cardNo,int recState,String communityName){
		this.id=id;
		this.communityId=communityId;
		this.fullname=fullname;
		this.birthdate=birthdate;
		this.gender=gender;
		this.cardNo=cardNo;
		this.recState=recState;
		this.communityName=communityName;
		this.nhisId="none";
		this.nhisExpiryDate="";
	}
	
	CommunityMember(int id,int communityId,String fullname,String birthdate,String gender,String cardNo,int recState){
		this.id=id;
		this.communityId=communityId;
		this.fullname=fullname;
		this.birthdate=birthdate;
		this.gender=gender;
		this.cardNo=cardNo;
		this.recState=recState;
		this.communityName="";
		this.nhisId="none";
		this.nhisExpiryDate="";
	}
	
	CommunityMember(int id,int communityId,String fullname,String birthdate,String gender,String cardNo, int recState, String communityName,  String nhisId, String nhisExpiryDate){
		this.id=id;
		this.communityId=communityId;
		this.fullname=fullname;
		this.birthdate=birthdate;
		this.gender=gender;
		this.cardNo=cardNo;
		this.recState=recState;
		this.communityName=communityName;
		this.nhisId=nhisId;
		this.nhisExpiryDate=nhisExpiryDate;
	}               
	
	CommunityMember(int id,int communityId,String fullname,String birthdate,String gender,String cardNo){
		this.id=id;
		this.communityId=communityId;
		this.fullname=fullname;
		this.birthdate=birthdate;
		this.gender=gender;
		this.cardNo=cardNo;
		this.recState=0;
		this.communityName="";
	}
	
	CommunityMember(int id,int communityId,String fullname,String birthdate,String gender){
		this.id=id;
		this.communityId=communityId;
		this.fullname=fullname;
		this.birthdate=birthdate;
		this.gender=gender;
		this.cardNo="none";
		this.recState=0;
		this.communityName="";
	}
		
	public double getAgeAsYear(){
		try
		{
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd",Locale.UK);
			java.util.Date d=dateFormat.parse(birthdate);
			
			Calendar c=Calendar.getInstance();
			int y=c.get(Calendar.YEAR);
			int m=c.get(Calendar.MONTH);
				
			c.setTime(d);
			int diff=y-c.get(Calendar.YEAR);
			if(diff>0){
				return diff;
			}
			
			return (m-c.get(Calendar.MONTH))/12;
		}
		catch(Exception ex){
			return 0;
		}
	}
	
	public String getFullname(){
		return fullname;
	}
	
	public String getBirthdate(){
		return birthdate;
	}
	
	public String getFormatedBirthdate(){
		try
		{
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd",Locale.UK);
			java.util.Date date=dateFormat.parse(birthdate);
			dateFormat=new SimpleDateFormat("dd/MM/yyyy",Locale.UK);
			return dateFormat.format(date);
		}
		catch(Exception ex){
			return "";
		}
	}
	
	public java.util.Date getBirthdateDate(){
		try
		{
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd",Locale.UK);
			return dateFormat.parse(birthdate);
		}
		catch(Exception ex){
			return null;
		}
		
	}
	
	public String getGender(){
		return gender;
	}

	public int getId(){
		return id;
	}
	
	public int getCommunityID(){
		return communityId;
	}
	
	public String getCommunity(){
		return communityName;
	}
	
	public String toString(){
		return id + "\t" + fullname +"\t " +getFormatedBirthdate()+"\t "+gender +"\t " +cardNo +"\t"+communityName ;
	}
	
	public String getCardNo(){
		return cardNo;
	}
	
	public String getNHISId(){
		return nhisId;
	}

	public int getSerialNo(){
		return serialNo;
	}
	
	public String getNHISExpiryDate(){
		return nhisExpiryDate;
	}
	/**
	 * is the insurance expiring
	 * @param limit in months
	 * @return
	 */
	public boolean IsNHISExpiring(int limit){
		java.util.Date d=getNHISExpiryDateDate();
		if(d==null){
			return false;
		}
		Calendar c=Calendar.getInstance();
		c.add(Calendar.MONTH,limit);
		Calendar nhis=Calendar.getInstance();
		nhis.setTime(d);
		return nhis.before(c);
	}
	
	public boolean IsBirthDateConfirmed(){
		return this.isBirthDateConfirmed;
	}
	
	public java.util.Date getNHISExpiryDateDate(){
		try
		{
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd",Locale.UK);
			return dateFormat.parse(nhisExpiryDate);
		}
		catch(Exception ex){
			return null;
		}
		
	}
	
	public String getFormatedNHISExpiryDate(){
		try
		{
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-d",Locale.UK);
			java.util.Date date=dateFormat.parse(nhisExpiryDate);
			dateFormat=new SimpleDateFormat("dd/MM/yyyy",Locale.UK);
			return dateFormat.format(date);
		}
		catch(Exception ex){
			return "";
		}
	}
	
	public int getRecState(){
		return recState;
	}
	
	public String getFirstAccessDate(){
		return this.firstAccessDate;
	}
	public String getJSON(){
		try{
			JSONObject obj=new JSONObject();
			obj.put("communityMemberId", id);
			obj.put("fullname", fullname);
			obj.put("gender", gender);
			obj.put("birthdate", birthdate);
			obj.put("cardNumber", cardNo);
			obj.put("communityId",communityId);
			obj.put("recState", recState);
			return obj.toString();
		}catch(Exception ex){
			return "{}";
		}
	}
	
	public String getURLString(){

		return "fn="+fullname
				+"g="+gender
				+"bd="+birthdate
				+"cn="+cardNo
				+"cid="+communityId;
	}
	
	

}
