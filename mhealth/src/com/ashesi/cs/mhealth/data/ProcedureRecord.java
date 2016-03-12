package com.ashesi.cs.mhealth.data;

/**
 * Created by george.assan on 11/03/2016.
 */
public class ProcedureRecord {
    private int procedureRecNo;
    private int procedureId;
    private String procedureName;
    private String recDate;
    private int claim_id;
    private float charge;

    public ProcedureRecord(int procedureId, String procedureName, String recDate, float charge) {
        this.procedureId = procedureId;
        this.procedureName = procedureName;
        this.recDate = recDate;
        this.claim_id = claim_id;
        this.charge = charge;
    }

    public ProcedureRecord(int procedureId, String procedureName, String recDate, int claim_id, float charge) {
        this.procedureId = procedureId;
        this.procedureName = procedureName;
        this.recDate = recDate;
        this.claim_id = claim_id;
        this.charge = charge;
    }


    public ProcedureRecord(int procedureRecNo, int procedureId, String procedureName, String recDate, int claim_id, float charge) {
        this.procedureRecNo = procedureRecNo;
        this.procedureId = procedureId;
        this.procedureName = procedureName;
        this.recDate = recDate;
        this.claim_id = claim_id;
        this.charge = charge;


    }

    @Override
    public String toString() {
        return procedureName +" "+recDate;
    }

    public int getProcedureRecNo() {
        return procedureRecNo;
    }

    public int getProcedureId() {
        return procedureId;
    }

    public String getProcedureName() {
        return procedureName;
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
