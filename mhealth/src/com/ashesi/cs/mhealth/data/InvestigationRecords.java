package com.ashesi.cs.mhealth.data;

import android.content.Context;

import com.ashesi.cs.mhealth.DataClass;

/**
 * Created by george.assan on 06/03/2016.
 */
public class InvestigationRecords extends DataClass {
    public static final String TABLE_NAME_INVESTIGATIONS="investigation_records";
    public static final String INVESTIGATION_ID="investigation_id";
    public static final String INVESTIGATION_REC_ID="investigation_rec_id";
    public static final String INVESTIGATION_REC_DATE="investigation_rec_date";
    public static final String INVESTIGATION_CHARGE="charge";
    /**
     * Creates an object of DataClass and calls getWritableDatabase to force database creation if necessary
     *
     * @param context
     */
    public InvestigationRecords(Context context) {
        super(context);
    }



    public static String getCreateSQLString(){
        return "create table " + TABLE_NAME_INVESTIGATIONS + " ("
                +INVESTIGATION_REC_ID + " integer primary key, "
                +INVESTIGATION_ID +" integer default 0, "
                +INVESTIGATION_REC_DATE+ " text default '1990-01-01', "
                +ClaimRecords.CLAIM_ID +" integer default 0, "
                +INVESTIGATION_CHARGE +" real default 0"
                +" )";
    }
}