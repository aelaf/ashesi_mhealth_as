package com.ashesi.cs.mhealth.data;

import android.content.Context;

import com.ashesi.cs.mhealth.DataClass;

/**
 * Created by george.assan on 06/03/2016.
 */
public class Bundles extends DataClass {
    public static final String TABLE_NAME_BUNDLES_RECORDS="bundles";
    public static final String BUNDLE_ID ="bundle_id";
    public static final String BUNDLE_DATE="bundle_date";
    public static final String BUNDLE_CHARGE="total_charge";
    /**
     * Creates an object of DataClass and calls getWritableDatabase to force database creation if necessary
     *
     * @param context
     */
    public Bundles(Context context) {
        super(context);
    }

    public static String getCreateSQLString(){
        return "create table " + TABLE_NAME_BUNDLES_RECORDS + " ("
                +BUNDLE_ID + " integer primary key, "
                +BUNDLE_DATE +" text default '1900-01-01', "
                +BUNDLE_CHARGE +" real default 0"
                +" )";
    }
}
