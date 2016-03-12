package com.ashesi.cs.mhealth.data;

/**
 * Created by george.assan on 12/03/2016.
 */
public class MedicineRecord {
    private int medicineRecNo;
    private int medicineId;
    private String medicineName;
    private String recDate;
    private int quantity;
    private int claim_id;
    private float charge;

    public MedicineRecord(int medicineId, String medicineName, String recDate,int quantity, float charge) {
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.recDate = recDate;
        this.quantity = quantity;
        ;
        this.charge = charge;
    }

    public MedicineRecord(int medicineId, String medicineName, String recDate,int quantity, int claim_id, float charge) {
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.recDate = recDate;
        this.claim_id = claim_id;
        this.charge = charge;
        this.quantity = quantity;
    }


    public MedicineRecord(int medicineRecNo, int medicineId, String medicineName, String recDate,int quantity, int claim_id, float charge) {
        this.medicineRecNo = medicineRecNo;
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.recDate = recDate;
        this.claim_id = claim_id;
        this.charge = charge;
        this.quantity = quantity;

    }

    @Override
    public String toString() {
        return medicineName +" "+recDate+" "+ quantity;
    }

    public int getMedicineRecNo() {
        return medicineRecNo;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public String getRecDate() {
        return recDate;
    }

    public int getClaim_id() {
        return claim_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getCharge() {
        return charge;
    }
}
