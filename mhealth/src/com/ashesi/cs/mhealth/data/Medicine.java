package com.ashesi.cs.mhealth.data;

/**
 * Created by george.assan on 09/03/2016.
 */
public class Medicine {

    private int id;
    private String medicine;
    private String gdrg;
    private float charge;

    public Medicine() {
    }

    public Medicine(int id, String medicine) {
        this.id = id;
        this.medicine = medicine;
    }

    public Medicine(int id, String medicine, String gdrg, float charge) {

        this.id = id;
        this.medicine = medicine;
        this.gdrg = gdrg;
        this.charge = charge;

    }

    public int getId() {
        return id;
    }

    public String getMedicine() {
        return medicine;
    }

    public String getGdrg() {
        return gdrg;
    }

    public float getCharge() {
        return charge;
    }



    @Override
    public String toString() {
        return medicine;
    }
}
