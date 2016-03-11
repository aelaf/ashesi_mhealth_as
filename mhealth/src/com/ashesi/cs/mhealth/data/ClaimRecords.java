package com.ashesi.cs.mhealth.data;

import android.content.Context;

import com.ashesi.cs.mhealth.DataClass;

/**
 * Created by ice on 17/02/2016.
 */
public class ClaimRecords extends DataClass{

    /**
     * Creates an object of DataClass and calls getWritableDatabase to force database creation if necessary
     *
     * @param context
     */

    public static final String CLAIM_ID="claim_id";
    public static final String TABLE_NAME_CLAIM_RECORDS="claim_records";
    public static final String TYPE_OF_SERVICE="type_of_service";
    public static final String OUTCOMES="outcomes";
    public static final String FIRST_VISIT="first_visit";
    public static final String SECOND_VISIT="second_visit";
    public static final String THIRD_VISIT="third_visit";
    public static final String FOURTH_VISIT="fourth_visit";
    public static final String CLAIM_CHARGE="charge";
    public static final String STATUS = "status";
    public static final String BUNDLE_ID="bundle_id";

    public ClaimRecords(Context context) {
        super(context);
    }

    public static String getCreateSQLString(){
        return "create table " +TABLE_NAME_CLAIM_RECORDS + " ("
                +CLAIM_ID + " integer primary key, "
                +TYPE_OF_SERVICE +" text, "
                +OUTCOMES+" text, "
                +FIRST_VISIT+" text default '1900-01-01', "
                +SECOND_VISIT+" text default '1900-01-01', "
                +THIRD_VISIT+" text default '1900-01-01', "
                +FOURTH_VISIT+" text default '1900-01-01', "
                +CLAIM_CHARGE +" real default 0, "
                +STATUS +" text default 'open', "
                +BUNDLE_ID+" integer default 0"
                + ")";
    }
}
