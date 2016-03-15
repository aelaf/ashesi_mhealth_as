package com.ashesi.cs.mhealth.data;

/**
 * Created by george.assan on 14/03/2016.
 */
public class Bundle {
    private int id;
    private String bundleDate;
    private float totalCharge;

    public Bundle() {
    }

    public Bundle(String bundleDate) {
        this.id = id;
        this.bundleDate = bundleDate;
    }

    public Bundle(String bundleDate, float totalCharge) {
        this.bundleDate = bundleDate;
        this.totalCharge = totalCharge;
    }

    public Bundle(int id, String bundleDate, float totalCharge) {
        this.id = id;
        this.bundleDate = bundleDate;
        this.totalCharge = totalCharge;
    }

    public int getId() {
        return id;
    }

    public String getBundleDate() {
        return bundleDate;
    }

    public float getTotalCharge() {
        return totalCharge;
    }
}
