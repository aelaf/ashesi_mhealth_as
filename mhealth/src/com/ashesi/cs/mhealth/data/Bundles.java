package com.ashesi.cs.mhealth.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.ashesi.cs.mhealth.DataClass;

import java.util.ArrayList;

/**
 * Created by george.assan on 06/03/2016.
 */
public class Bundles extends DataClass {
    public static final String TABLE_NAME_BUNDLES_RECORDS = "bundles";
    public static final String BUNDLE_ID = "bundle_id";
    public static final String BUNDLE_DATE = "bundle_date";
    public static final String BUNDLE_CHARGE = "total_charge";
    private int idAfterInsertion = 0;
    private String[] columns={BUNDLE_ID,BUNDLE_DATE,BUNDLE_DATE };
    /**
     * Creates an object of DataClass and calls getWritableDatabase to force database creation if necessary
     *
     * @param context
     */
    public Bundles(Context context) {
        super(context);
    }

    public static String getCreateSQLString() {
        return "create table " + TABLE_NAME_BUNDLES_RECORDS + " ("
                + BUNDLE_ID + " integer primary key, "
                + BUNDLE_DATE + " text default '1900-01-01', "
                + BUNDLE_CHARGE + " real default 0"
                + " )";
    }


    public boolean addOrUpdate(String bundleDate) {
        try {
            SQLiteDatabase db = getWritableDatabase();
            ContentValues cv = new ContentValues();


            cv.put(BUNDLE_DATE, bundleDate);
            idAfterInsertion = (int)db.insertWithOnConflict(TABLE_NAME_BUNDLES_RECORDS, null, cv, SQLiteDatabase.CONFLICT_REPLACE);
            if (idAfterInsertion<= 0) {
                return false;
            }
            close();
            return true;
        } catch (Exception ex) {
            close();
            return false;
        }
    }
    public int getJustAddedId(){
        return idAfterInsertion;

    }
    public int getBundleID(String bundleDate) {
        try {
            String selection = BUNDLE_DATE + "=" + bundleDate;
            cursor = db.query(TABLE_NAME_BUNDLES_RECORDS, columns, selection, null, null, null, null);
            cursor.moveToFirst();
            Bundle obj = fetch();
            close();
            return obj.getId();
        } catch (Exception ex) {
            Log.d("OPDCases.getOPDCase(int)", "Exception " + ex.getMessage());
            return 0;
        }
    }


    public Bundle fetch(){
        try
        {

            if(cursor.isBeforeFirst()){
                cursor.moveToFirst();
            }
            int index=cursor.getColumnIndex(BUNDLE_ID);
            int id=cursor.getInt(index);
            index=cursor.getColumnIndex(BUNDLE_DATE);
            String name=cursor.getString(index);
            index=cursor.getColumnIndex(BUNDLE_CHARGE);
            float charge=cursor.getFloat(index);
            cursor.moveToNext();
            return new Bundle(id,name,charge);
        }catch(Exception ex){
            return null;
        }

    }


}
