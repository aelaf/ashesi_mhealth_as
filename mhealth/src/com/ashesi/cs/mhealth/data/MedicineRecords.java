package com.ashesi.cs.mhealth.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.ashesi.cs.mhealth.DataClass;

/**
 * Created by george.assan on 06/03/2016.
 */
public class MedicineRecords extends DataClass {
    public static final String TABLE_NAME_MEDICINES_RECORDS="medicines_records";
    public static final String MEDICINE_ID="medicine_id";
    public static final String MEDICINE_REC_ID="medicine_rec_id";
    public static final String MEDICINE_REC_DATE="medicine_rec_date";
    public static final String MEDICINE_QUANTITY = "quantity";
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
                +MEDICINE_CHARGE +" real default 0, "
                +MEDICINE_QUANTITY+ " integer default 1"
                +" )";
    }

    public boolean addOrUpdate(int id,String recDate,int claimId, int quantity, float charge){
        try{
            SQLiteDatabase db=getWritableDatabase();
            ContentValues cv=new ContentValues();

            cv.put(MEDICINE_ID, id);
            cv.put(MEDICINE_REC_DATE, recDate);
            cv.put(ClaimRecords.CLAIM_ID, claimId);
            cv.put(MEDICINE_CHARGE, charge);
            cv.put(MEDICINE_QUANTITY, quantity);

            if(db.insertWithOnConflict(TABLE_NAME_MEDICINES_RECORDS, null,cv,SQLiteDatabase.CONFLICT_REPLACE) <=0){
                return false;
            }
            close();
            return true;
        }catch(Exception ex){
            close();
            return false;
        }
    }


    @Override
    public String toString() {
        return "";
    }
}
