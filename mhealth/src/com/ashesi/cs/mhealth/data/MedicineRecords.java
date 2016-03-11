package com.ashesi.cs.mhealth.data;

import android.content.Context;

import com.ashesi.cs.mhealth.DataClass;

/**
 * Created by george.assan on 06/03/2016.
 */
public class MedicineRecords extends DataClass {
    public static final String TABLE_NAME_MEDICINES_RECORDS="medicines_records";
    public static final String MEDICINE_ID="medicine_id";
    public static final String MEDICINE_REC_ID="medicine_rec_id";
    public static final String MEDICINE_REC_DATE="medicine_rec_date";
    public static final String MEDICINE_CHARGE="charge";
    /**
     * Creates an object of DataClass and calls getWritableDatabase to force database creation if necessary
     *
     * @param context
     */
    public MedicineRecords(Context context) {
        super(context);
    }

    public static String getCreateSQLString(){
        return "create table " + TABLE_NAME_MEDICINES_RECORDS + " ("
                +MEDICINE_REC_ID + " integer primary key, "
                +MEDICINE_ID +" integer default 0, "
                +MEDICINE_REC_DATE+" text default '1900-01-01', "
                + ClaimRecords.CLAIM_ID +" integer default 0, "
                +MEDICINE_CHARGE +" real default 0"
                +" )";
    }
}
