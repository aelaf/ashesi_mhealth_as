package com.ashesi.cs.mhealth.data;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by ice on 17/02/2016.
 */
public class ClaimRecord {
    public final String DATE_NOT_SET="not set";
    private int claimId;
    private int typeOfService;
    private int outcomeId;
    private int typeOfAttendance;
    private String firstVisitDate;
    private String secondVisitDate;
    private String thirdVisitDate;
    private String fourthVisitDate;
    private float claimCharge;




    public ClaimRecord(int claimId,int typeOfService,int typeOfAttendance,int outcomeId,String firstVisitDate,float claimCharge){
        this.claimId = claimId;
        this.typeOfService = typeOfService;
        this.typeOfAttendance = typeOfAttendance;
        this.outcomeId = outcomeId;
        this.firstVisitDate = firstVisitDate;
        this.secondVisitDate = DATE_NOT_SET;
        this.thirdVisitDate = DATE_NOT_SET;
        this.fourthVisitDate = DATE_NOT_SET;
        this.claimCharge = claimCharge;
    }

    public ClaimRecord(int claimId,int typeOfService,int typeOfAttendance,int outcomeId,
                       String firstVisitDate,String secondVisitDate,float claimCharge){
        this.claimId = claimId;
        this.typeOfService = typeOfService;
        this.typeOfAttendance = typeOfAttendance;
        this.outcomeId = outcomeId;
        this.firstVisitDate = firstVisitDate;
        this.secondVisitDate = secondVisitDate;
        this.thirdVisitDate = DATE_NOT_SET;
        this.fourthVisitDate = DATE_NOT_SET;
        this.claimCharge = claimCharge;

    }

    public ClaimRecord(int claimId,int typeOfService,int typeOfAttendance,int outcomeId,
                       String firstVisitDate,String secondVisitDate,String thirdVisitDateVisitDate,float claimCharge){
        this.claimId = claimId;
        this.typeOfService = typeOfService;
        this.typeOfAttendance = typeOfAttendance;
        this.outcomeId = outcomeId;
        this.firstVisitDate = firstVisitDate;
        this.secondVisitDate = secondVisitDate;
        this.thirdVisitDate = thirdVisitDateVisitDate;
        this.fourthVisitDate = DATE_NOT_SET;
        this.claimCharge = claimCharge;

    }
    public ClaimRecord(int claimId,int typeOfService,int typeOfAttendance,int outcomeId,
                       String firstVisitDate,String secondVisitDate,String thirdVisitDateVisitDate,
                       String fourthVisitDate,float claimCharge){
        this.claimId = claimId;
        this.typeOfService = typeOfService;
        this.typeOfAttendance = typeOfAttendance;
        this.outcomeId = outcomeId;
        this.firstVisitDate = firstVisitDate;
        this.secondVisitDate = secondVisitDate;
        this.thirdVisitDate = thirdVisitDateVisitDate;
        this.fourthVisitDate = fourthVisitDate;
        this.claimCharge = claimCharge;

    }




    //Getter methods for ClaimRecord class variables
    public int getClaimId() {
        return claimId;
    }

    public int getTypeOfService() {
        return typeOfService;
    }

    public int getOutcomeId() {
        return outcomeId;
    }

    public int getTypeOfAttendance() {
        return typeOfAttendance;
    }

    public String getFirstVisitDate() {
        return firstVisitDate;
    }

    public String getSecondVisitDate() {
        return secondVisitDate;
    }

    public String getThirdVisitDate() {
        return thirdVisitDate;
    }

    public String getFourthVisitDate() {
        return fourthVisitDate;
    }

    public float getClaimCharge() {
        return claimCharge;
    }




    //setter methods for Claim Record Class


    public void setTypeOfService(int typeOfService) {
        this.typeOfService = typeOfService;
    }

    public void setOutcomeId(int outcomeId) {
        this.outcomeId = outcomeId;
    }

    public void setTypeOfAttendance(int typeOfAttendance) {
        this.typeOfAttendance = typeOfAttendance;
    }

    public void setFirstVisitDate(String firstVisitDate) {
        this.firstVisitDate = firstVisitDate;
    }

    public void setSecondVisitDate(String secondVisitDate) {
        this.secondVisitDate = secondVisitDate;
    }

    public void setThirdVisitDate(String thirdVisitDate) {
        this.thirdVisitDate = thirdVisitDate;
    }

    public void setFourthVisitDate(String fourthVisitDate) {
        this.fourthVisitDate = fourthVisitDate;
    }

    public void setClaimCharge(float claimCharge) {
        this.claimCharge = claimCharge;
    }

    public String getFormatedFirstVisitDate(){
        try
        {
            SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-d", Locale.UK);
            java.util.Date date=dateFormat.parse(firstVisitDate);
            dateFormat=new SimpleDateFormat("d/MM/yyyy",Locale.UK);
            return dateFormat.format(date);
        }
        catch(Exception ex){
            return "";
        }

    }
    public String getFormatedSecondVisitDate(){
        try
        {
            SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-d", Locale.UK);
            java.util.Date date=dateFormat.parse(secondVisitDate);
            dateFormat=new SimpleDateFormat("d/MM/yyyy",Locale.UK);
            return dateFormat.format(date);
        }
        catch(Exception ex){
            return "";
        }

    }
    public String getFormatedThirdVisitDate(){
        try
        {
            SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-d", Locale.UK);
            java.util.Date date=dateFormat.parse(thirdVisitDate);
            dateFormat=new SimpleDateFormat("d/MM/yyyy",Locale.UK);
            return dateFormat.format(date);
        }
        catch(Exception ex){
            return "";
        }

    }
    public String getFormatedFourthVisitDate(){
        try
        {
            SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-d", Locale.UK);
            java.util.Date date=dateFormat.parse(fourthVisitDate);
            dateFormat=new SimpleDateFormat("d/MM/yyyy",Locale.UK);
            return dateFormat.format(date);
        }
        catch(Exception ex){
            return "";
        }

    }


   /**
    public String toString(){
        String str="not lab confirmed";
        if(isLab()){
            str="lab confirmed";
        }
        return fullname +", "+ opdCaseName  +", " +str+", "+getFormatedRecDate();

    }

    public void setLab(String lab){
        this.lab=lab;
    }

    public String getLab(){
        if(this.lab==null){
            return OPDCaseRecords.LAB_NOT_CONFIRMED;
        }

        return this.lab;
    }

    public boolean isLab(){
        if(this.lab==null){
            return false;
        }
        if(this.lab.equalsIgnoreCase(OPDCaseRecords.LAB_CONFIRMED)){
            return true;
        }else{
            return false;
        }
    }**/

    public String getJSON(){
        JSONObject obj=new JSONObject();
        try
        {
            obj.put("claimId",claimId);
            obj.put("typeOfService", typeOfService);
            obj.put("typeOfAttendance", typeOfAttendance);
            obj.put("outcomeId",outcomeId);
            obj.put("firstVisitDate",firstVisitDate);
            obj.put("secondVisitDate",secondVisitDate);
            obj.put("thirdVisitDate",thirdVisitDate);
            obj.put("claimCharge",claimCharge);
            return obj.toString();
        }catch(Exception ex){
            return "{}";
        }

    }
}
