package com.ashesi.cs.mhealth.data;

import android.content.Context;

import com.ashesi.cs.mhealth.DataClass;

import java.util.ArrayList;

/**
 * Created by george.assan on 09/03/2016.
 */
public class TypeOfAttendances extends DataClass {
    public static final String TABLE_TYPE_OF_ATTENDANCES="type_of_attendance";
    public static final String TYPE_OF_ATTENDANCE_ID = "type_of_attendance_id";
    public static final String TYPE_OF_ATTENDANCE_NAME = "type_of_attendance_name";
    /**
     * Creates an object of DataClass and calls getWritableDatabase to force database creation if necessary
     *
     * @param context
     */
    public TypeOfAttendances(Context context) {
        super(context);
    }

    private String[] columns={TYPE_OF_ATTENDANCE_ID,TYPE_OF_ATTENDANCE_NAME};


    public TypeOfAttendance fetch(){
        try
        {

            if(cursor.isBeforeFirst()){
                cursor.moveToFirst();
            }
            int index=cursor.getColumnIndex(TYPE_OF_ATTENDANCE_ID);
            int id=cursor.getInt(index);
            index=cursor.getColumnIndex(TYPE_OF_ATTENDANCE_NAME);
            String name=cursor.getString(index);
            cursor.moveToNext();
            return new TypeOfAttendance(id,name);
        }catch(Exception ex){
            return null;
        }

    }




    public static String getCreateSQLString(){
        return "create table " + TABLE_TYPE_OF_ATTENDANCES + " ("
                +TYPE_OF_ATTENDANCE_ID + " integer primary key, "
                +TYPE_OF_ATTENDANCE_NAME +" text "

                +")";
    }

    public static String getInsertSQLString(int id, String type_of_attendance_name) {
        return "insert into " + TABLE_TYPE_OF_ATTENDANCES + "("
                + TYPE_OF_ATTENDANCE_ID + ", "
                + TYPE_OF_ATTENDANCE_NAME
                + ") values(" +
                +id + ","
                + "'" + type_of_attendance_name + "'"
                + ")";
    }

    public ArrayList<TypeOfAttendance> getArrayList(){
        ArrayList<TypeOfAttendance> list=new ArrayList<TypeOfAttendance>();
        TypeOfAttendance typeOfAttendance =fetch();
        while(typeOfAttendance!=null){
            list.add(typeOfAttendance);
            typeOfAttendance=fetch();
        }
        return list;
    }

    public ArrayList<TypeOfAttendance> getTypeOfAttendances(){
        ArrayList<TypeOfAttendance> list=new ArrayList<TypeOfAttendance>();
        try
        {
            db=getReadableDatabase();
            cursor=db.query(TABLE_TYPE_OF_ATTENDANCES, columns, null, null, null, null,null);
            cursor.moveToFirst();
            TypeOfAttendance v=fetch();
            while(v!=null){
                list.add(v);
                v=fetch();
            }
            close();
            return list;
        }catch(Exception ex){
            close();
            return list;
        }
    }


}
