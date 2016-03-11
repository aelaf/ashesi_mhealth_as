package com.ashesi.cs.mhealth.data;

import android.content.Context;

import com.ashesi.cs.mhealth.DataClass;

import java.util.ArrayList;

/**
 * Created by george.assan on 09/03/2016.
 */
public class Outcomes extends DataClass {
    public static final String TABLE_OUTCOMES="outcomes";
    public static final String OUTCOMES_ID = "outcomes_id";
    public static final String OUTCOMES_NAME = "outcomes_name";
    private String[] columns={OUTCOMES_ID,OUTCOMES_NAME };
    /**
     * Creates an object of DataClass and calls getWritableDatabase to force database creation if necessary
     *
     * @param context
     */
    public Outcomes(Context context) {
        super(context);
    }

    public static String getCreateSQLString(){
        return "create table " + TABLE_OUTCOMES + " ("
                +OUTCOMES_ID + " integer primary key, "
                +OUTCOMES_NAME +" text "

                +")";
    }

    public static String getInsertSQLString(int id, String outcome_name) {
        return "insert into " + TABLE_OUTCOMES + "("
                + OUTCOMES_ID + ", "
                + OUTCOMES_NAME
                + ") values(" +
                +id + ","
                + "'" + outcome_name + "'"
                + ")";
    }


    public Outcome fetch(){
        try
        {

            if(cursor.isBeforeFirst()){
                cursor.moveToFirst();
            }
            int index=cursor.getColumnIndex(OUTCOMES_ID);
            int id=cursor.getInt(index);
            index=cursor.getColumnIndex(OUTCOMES_NAME);
            String name=cursor.getString(index);
            cursor.moveToNext();
            return new Outcome(id,name);
        }catch(Exception ex){
            return null;
        }

    }

    public ArrayList<Outcome> getOutcomes(){
        ArrayList<Outcome> list=new ArrayList<Outcome>();
        try
        {
            db=getReadableDatabase();
            cursor=db.query(TABLE_OUTCOMES, columns, null, null, null, null,null);
            cursor.moveToFirst();
            Outcome obj=fetch();
            while(obj!=null){
                list.add(obj);
                obj=fetch();
            }
            close();
            return list;
        }catch(Exception ex){
            close();
            return list;
        }
    }

}

