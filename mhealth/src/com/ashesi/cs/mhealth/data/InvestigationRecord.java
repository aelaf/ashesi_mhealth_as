package com.ashesi.cs.mhealth.data;

/**
 * Created by george.assan on 12/03/2016.
 */
public class InvestigationRecord {

    private int investigationRecNo;
    private int investigationId;
    private String investigationName;
    private String recDate;
    private int claim_id;
    private float charge;


    public InvestigationRecord(int investigationId, String investigationName, String recDate, float charge) {
        this.investigationId = investigationId;
        this.investigationName = investigationName;
        this.recDate = recDate;
        this.claim_id = claim_id;
        this.charge = charge;
    }

    public InvestigationRecord(int investigationId, String investigationName, String recDate, int claim_id, float charge) {
        this.investigationId = investigationId;
        this.investigationName = investigationName;
        this.recDate = recDate;
        this.claim_id = claim_id;
        this.charge = charge;
    }


    public InvestigationRecord(int investigationRecNo, int investigationId, String investigationName, String recDate, int claim_id, float charge) {
        this.investigationRecNo = investigationRecNo;
        this.investigationId = investigationId;
        this.investigationName = investigationName;
        this.recDate = recDate;
        this.claim_id = claim_id;
        this.charge = charge;
        
    }

    @Override
    public String toString() {
        return investigationName + " "+recDate;
    }

    public int getInvestigationRecNo() {
        return investigationRecNo;
    }

    public int getInvestigationId() {
        return investigationId;
    }

    public String getInvestigationName() {
        return investigationName;
    }

    public String getRecDate() {
        return recDate;
    }

    public int getClaim_id() {
        return claim_id;
    }

    public float getCharge() {
        return charge;
    }
}
