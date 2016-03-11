package com.ashesi.cs.mhealth.data;

import android.content.Context;

import com.ashesi.cs.mhealth.DataClass;

import java.util.ArrayList;


/**
 * Created by george.assan on 06/03/2016.
 */
public class Investigations extends DataClass {
    public static final String TABLE_NAME_INVESTIGATIONS="investigations";
    public static final String INVESTIGATION_ID="investigation_id";
    public static final String INVESTIGATION_NAME="investigation_name";
    public static final String INVESTIGATION_GDRG_CODE="gdrg_code";
    public static final String INVESTIGATION_CHARGE="charge";

    private String[] columns={INVESTIGATION_ID,INVESTIGATION_NAME,INVESTIGATION_GDRG_CODE, INVESTIGATION_CHARGE};
    /**
     * Creates an object of DataClass and calls getWritableDatabase to force database creation if necessary
     *
     * @param context
     */
    public Investigations(Context context) {
        super(context);
        
        
    }
    public static String getCreateSQLString(){
        return "create table " + TABLE_NAME_INVESTIGATIONS + " ("
                +INVESTIGATION_ID + " integer primary key, "
                +INVESTIGATION_NAME +" text, "
                +INVESTIGATION_GDRG_CODE +" text, "
                +INVESTIGATION_CHARGE +" real default 0"
                +" )";
    }

    public static String getInsertSQLString(int id, String investigation_name, String gdrg,float charge){
        return "insert into "+TABLE_NAME_INVESTIGATIONS +"("
                +INVESTIGATION_ID+", "
                +INVESTIGATION_NAME+", "
                +INVESTIGATION_GDRG_CODE+", "
                +INVESTIGATION_CHARGE
                +") values("+
                +id+","
                +"'"+investigation_name+"',"
                +"'"+gdrg+"',"
                +charge
                +")";
    }

    public Investigation fetch(){
        try
        {

            if(cursor.isBeforeFirst()){
                cursor.moveToFirst();
            }
            int index=cursor.getColumnIndex(INVESTIGATION_ID);
            int id=cursor.getInt(index);
            index=cursor.getColumnIndex(INVESTIGATION_NAME);
            String name=cursor.getString(index);
            index=cursor.getColumnIndex(INVESTIGATION_GDRG_CODE);
            String gdrg =cursor.getString(index);
            index=cursor.getColumnIndex(INVESTIGATION_CHARGE);
            float charge =cursor.getFloat(index);
            cursor.moveToNext();
            return new Investigation(id,name,gdrg,charge);
        }catch(Exception ex){
            return null;
        }

    }
    public ArrayList<Investigation> getInvestigations(){
        ArrayList<Investigation> list=new ArrayList<Investigation>();
        try
        {
            db=getReadableDatabase();
            cursor=db.query(TABLE_NAME_INVESTIGATIONS, columns, null, null, null, null,null);
            cursor.moveToFirst();
            Investigation i=fetch();
            while(i!=null){
                list.add(i);
                i=fetch();
            }
            close();
            return list;
        }catch(Exception ex){
            close();
            return list;
        }
    }

}
