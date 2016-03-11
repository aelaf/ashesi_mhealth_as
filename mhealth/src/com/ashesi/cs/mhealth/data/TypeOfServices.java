package com.ashesi.cs.mhealth.data;

import android.content.Context;

import com.ashesi.cs.mhealth.DataClass;

import java.util.ArrayList;


/**
 * Created by george.assan on 09/03/2016.
 */
public class TypeOfServices extends DataClass {
    public static final String TABLE_TYPE_OF_SERVICES="type_of_services";
    public static final String TYPE_OF_SERVICE_ID = "type_of_service_id";
    public static final String TYPE_OF_SERVICE_NAME = "type_of_service_name";
    private String[] columns={TYPE_OF_SERVICE_ID,TYPE_OF_SERVICE_NAME };
    /**
     * Creates an object of DataClass and calls getWritableDatabase to force database creation if necessary
     *
     * @param context
     */
    public TypeOfServices(Context context) {
        super(context);
    }

    public static String getCreateSQLString(){
        return "create table " + TABLE_TYPE_OF_SERVICES + " ("
                +TYPE_OF_SERVICE_ID + " integer primary key, "
                +TYPE_OF_SERVICE_NAME +" text "
                +")";
    }

    public static String getInsertSQLString(int id, String type_of_service_name){
        return "insert into "+TABLE_TYPE_OF_SERVICES +"("
                +TYPE_OF_SERVICE_ID+", "
                +TYPE_OF_SERVICE_NAME
                +") values("+
                +id+","
                +"'"+type_of_service_name+"'"
                +")";
    }




    public TypeOfService fetch(){
        try
        {

            if(cursor.isBeforeFirst()){
                cursor.moveToFirst();
            }
            int index=cursor.getColumnIndex(TYPE_OF_SERVICE_ID);
            int id=cursor.getInt(index);
            index=cursor.getColumnIndex(TYPE_OF_SERVICE_NAME);
            String name=cursor.getString(index);
            cursor.moveToNext();
            return new TypeOfService(id,name);
        }catch(Exception ex){
            return null;
        }

    }

    public ArrayList<TypeOfService> getTypeOfServices(){
        ArrayList<TypeOfService> list=new ArrayList<TypeOfService>();
        try
        {
            db=getReadableDatabase();
            cursor=db.query(TABLE_TYPE_OF_SERVICES, columns, null, null, null, null,null);
            cursor.moveToFirst();
            TypeOfService obj=fetch();
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
