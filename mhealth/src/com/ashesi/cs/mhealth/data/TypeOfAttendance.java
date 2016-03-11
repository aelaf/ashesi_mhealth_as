package com.ashesi.cs.mhealth.data;

/**
 * Created by george.assan on 09/03/2016.
 */
public class TypeOfAttendance {
    private int id;
    private String typeOfAttendance;

    public TypeOfAttendance(int id, String typeOfAttendance) {
        this.id = id;
        this.typeOfAttendance = typeOfAttendance;
    }

    public int getId() {
        return id;
    }

    public String getTypeOfAttendance() {
        return typeOfAttendance;
    }

    @Override
    public String toString(){
        return this.typeOfAttendance;
    }
}
