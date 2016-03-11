package com.ashesi.cs.mhealth.data;

import android.content.Context;

import com.ashesi.cs.mhealth.DataClass;

import java.util.ArrayList;

/**
 * Created by george.assan on 06/03/2016.
 */
public class Procedures extends DataClass {
    public static final String TABLE_NAME_PROCEDURES="procedures";
    public static final String PROCEDURE_ID="procedure_id";
    public static final String PROCEDURE_NAME="procedure_name";
    public static final String PROCEDURE_GDRG_CODE="gdrg_code";
    public static final String PROCEDURE_CHARGE="charge";
    /**
     * Creates an object of DataClass and calls getWritableDatabase to force database creation if necessary
     *
     * @param context
     */
    public Procedures(Context context) {
        super(context);
    }


    private String[] columns={PROCEDURE_ID,PROCEDURE_NAME,PROCEDURE_GDRG_CODE, PROCEDURE_CHARGE};


    public static String getCreateSQLString(){
        return "create table " + TABLE_NAME_PROCEDURES + " ("
                +PROCEDURE_ID + " integer primary key, "
                +PROCEDURE_NAME +" text, "
                +PROCEDURE_GDRG_CODE +" text, "
                +PROCEDURE_CHARGE +" real default 0"
                +" )";
    }

    public static String getInsertSQLString(int id, String procedure_name, String gdrg,float charge){
        return "insert into "+TABLE_NAME_PROCEDURES +"("
                +PROCEDURE_ID+", "
                +PROCEDURE_NAME+", "
                +PROCEDURE_GDRG_CODE+", "
                +PROCEDURE_CHARGE
                +") values("+
                +id+","
                +"'"+procedure_name+"',"
                +"'"+gdrg+"',"
                +charge
                +")";
    }

    public Procedure fetch(){
        try
        {

            if(cursor.isBeforeFirst()){
                cursor.moveToFirst();
            }
            int index=cursor.getColumnIndex(PROCEDURE_ID);
            int id=cursor.getInt(index);
            index=cursor.getColumnIndex(PROCEDURE_NAME);
            String name=cursor.getString(index);
            index=cursor.getColumnIndex(PROCEDURE_GDRG_CODE);
            String gdrg =cursor.getString(index);
            index=cursor.getColumnIndex(PROCEDURE_CHARGE);
            float charge =cursor.getFloat(index);
            cursor.moveToNext();
            return new Procedure(id,name,gdrg,charge);
        }catch(Exception ex){
            return null;
        }

    }
    public ArrayList<Procedure> getProcedures(){
        ArrayList<Procedure> list=new ArrayList<Procedure>();
        try
        {
            db=getReadableDatabase();
            cursor=db.query(TABLE_NAME_PROCEDURES, columns, null, null, null, null,null);
            cursor.moveToFirst();
            Procedure p=fetch();
            while(p!=null){
                list.add(p);
                p=fetch();
            }
            close();
            return list;
        }catch(Exception ex){
            close();
            return list;
        }
    }

}
