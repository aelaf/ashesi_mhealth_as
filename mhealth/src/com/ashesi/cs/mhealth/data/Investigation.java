package com.ashesi.cs.mhealth.data;

/**
 * Created by george.assan on 09/03/2016.
 */
public class Investigation {
    private int id;
    private String investigation;
    private String gdrg;
    private float charge;

    public Investigation(int id,String investigation) {
        this.investigation = investigation;
        this.id = id;
    }

    public Investigation(int id, String investigation, String gdrg, float charge) {
        this.id = id;
        this.investigation = investigation;
        this.gdrg = gdrg;
        this.charge = charge;
    }

    public String getInvestigationName() {
        return investigation;
    }

    public String getGdrg() {
        return gdrg;
    }

    public float getCharge() {
        return charge;
    }

    public int getId() {

        return id;
    }



    @Override
    public String toString(){
        return investigation;
    }
}
