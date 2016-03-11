package com.ashesi.cs.mhealth.data;

/**
 * Created by george.assan on 09/03/2016.
 */
public class TypeOfService {

    private int id;
    private String typeOfService;

    public TypeOfService(int id, String typeOfService) {
        this.id = id;
        this.typeOfService = typeOfService;
    }

    public String getTypeOfService() {
        return typeOfService;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return typeOfService;
    }
}
