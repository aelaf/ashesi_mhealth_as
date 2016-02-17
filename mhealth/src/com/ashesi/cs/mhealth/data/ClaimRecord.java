package com.ashesi.cs.mhealth.data;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by ice on 17/02/2016.
 */
public class ClaimRecord {

    private int claimId;
    private int typeOfService;
    private int outcomeId;
    private int typeOfAttendance;
    private String firstVisitDate;
    private String secondVisitDate;
    private String thirdVisitDate;
    private float claimCharge;

    


    public ClaimRecord(int claimId,int typeOfService,int typeOfAttendance,int outcomeId,String firstVisitDate,float claimCharge){
        this.claimId = claimId;
        this.typeOfService = typeOfService;
        this.typeOfAttendance = typeOfAttendance;
        this.outcomeId = outcomeId;
        this.firstVisitDate = firstVisitDate;
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
