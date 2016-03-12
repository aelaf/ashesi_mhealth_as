package com.ashesi.cs.mhealth.data;

/**
 * Created by george.assan on 09/03/2016.
 */
public class Procedure {
    private int id;
    private String procedure;
    private String gdrg;
    private float charge;

    public Procedure(){

    }

    public Procedure(int id, String procedure) {
        this.id = id;
        this.procedure = procedure;
    }

    public Procedure(int id, String procedure, String gdrg, float charge) {
        this.id = id;
        this.procedure = procedure;
        this.gdrg = gdrg;
        this.charge = charge;
    }

    public int getId() {
        return id;
    }

    public String getProcedure() {
        return procedure;
    }

    public String getGdrg() {
        return gdrg;
    }

    public float getCharge() {
        return charge;
    }


    @Override
    public String toString(){
        return this.procedure;
    }
}
