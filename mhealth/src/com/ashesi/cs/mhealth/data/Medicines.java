package com.ashesi.cs.mhealth.data;

import android.content.Context;

import com.ashesi.cs.mhealth.DataClass;

import java.util.ArrayList;

/**
 * Created by george.assan on 06/03/2016.
 */
public class Medicines extends DataClass{
    public static final String TABLE_NAME_MEDICINES="medicines";
    public static final String MEDICINE_ID="medicine_id";
    public static final String MEDICINE_NAME="medicine_name";
    public static final String MEDICINE_GDRG_CODE="gdrg_code";
    public static final String MEDICINE_CHARGE="charge";

    private String[] columns={MEDICINE_ID,MEDICINE_NAME,MEDICINE_GDRG_CODE, MEDICINE_CHARGE};
    /**
     * Creates an object of DataClass and calls getWritableDatabase to force database creation if necessary
     *
     * @param context
     */
    public Medicines(Context context) {
        super(context);
    }


    public static String getCreateSQLString(){
        return "create table " + TABLE_NAME_MEDICINES + " ("
                +MEDICINE_ID + " integer primary key, "
                +MEDICINE_NAME +" text, "
                +MEDICINE_GDRG_CODE +" text, "
                +MEDICINE_CHARGE +" real default 0"
                +" )";
    }

    public static String getInsertSQLString(int id, String medicine_name, String gdrg,float charge){
        return "insert into "+TABLE_NAME_MEDICINES +"("
                +MEDICINE_ID+", "
                +MEDICINE_NAME+", "
                +MEDICINE_GDRG_CODE+", "
                +MEDICINE_CHARGE
                +") values("+
                +id+","
                +"'"+medicine_name+"',"
                +"'"+gdrg+"',"
                +charge
                +")";
    }

    public Medicine fetch(){
        try
        {

            if(cursor.isBeforeFirst()){
                cursor.moveToFirst();
            }
            int index=cursor.getColumnIndex(MEDICINE_ID);
            int id=cursor.getInt(index);
            index=cursor.getColumnIndex(MEDICINE_NAME);
            String name=cursor.getString(index);
            index=cursor.getColumnIndex(MEDICINE_GDRG_CODE);
            String gdrg =cursor.getString(index);
            index=cursor.getColumnIndex(MEDICINE_CHARGE);
            float charge =cursor.getFloat(index);
            cursor.moveToNext();
            return new Medicine(id,name,gdrg,charge);
        }catch(Exception ex){
            return null;
        }

    }
    public ArrayList<Medicine> getMedicines(){
        ArrayList<Medicine> list=new ArrayList<Medicine>();
        try
        {
            db=getReadableDatabase();
            cursor=db.query(TABLE_NAME_MEDICINES, columns, null, null, null, null,null);
            cursor.moveToFirst();
            Medicine p=fetch();
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
