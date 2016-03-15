package com.ashesi.cs.mhealth.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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
    private int idAfterInsertion = 0;

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


    public boolean addOrUpdate(String typeOfService,String outcomes,String firstVisit, String secondVisit,String thirdVisit,
                               String fourthVisit, float charge, int bundleId){
        try{
            SQLiteDatabase db=getWritableDatabase();
            ContentValues cv=new ContentValues();

            cv.put(TYPE_OF_SERVICE, typeOfService);
            cv.put(OUTCOMES, outcomes);
            cv.put(FIRST_VISIT, firstVisit);
            cv.put(SECOND_VISIT, secondVisit);
            cv.put(THIRD_VISIT, thirdVisit);
            cv.put(FOURTH_VISIT, fourthVisit);
            cv.put(CLAIM_CHARGE, charge);
            cv.put(BUNDLE_ID, bundleId);
             idAfterInsertion = (int) db.insertWithOnConflict(TABLE_NAME_CLAIM_RECORDS, null,cv,SQLiteDatabase.CONFLICT_REPLACE);
            if(idAfterInsertion <=0){
                return false;
            }
            close();
            return true;
        }catch(Exception ex){
            close();
            return false;
        }
    }

    public int getClaimRecordId(){

        return idAfterInsertion;
    }
}
