package com.ashesi.cs.mhealth.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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

    public boolean addOrUpdate(int id,String recDate,int claimId, float charge){
        try{
            SQLiteDatabase db=getWritableDatabase();
            ContentValues cv=new ContentValues();

            cv.put(INVESTIGATION_ID,
                    id);
            cv.put(INVESTIGATION_REC_DATE, recDate);
            cv.put(ClaimRecords.CLAIM_ID, claimId);
            cv.put(INVESTIGATION_CHARGE, charge);

            if(db.insertWithOnConflict(TABLE_NAME_INVESTIGATIONS, null,cv,SQLiteDatabase.CONFLICT_REPLACE) <=0){
                return false;
            }
            close();
            return true;
        }catch(Exception ex){
            close();
            return false;
        }
    }
}