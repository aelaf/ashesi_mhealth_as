package com.ashesi.cs.mhealth;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.ashesi.cs.mhealth.data.Investigation;
import com.ashesi.cs.mhealth.data.Investigations;
import com.ashesi.cs.mhealth.data.Medicine;
import com.ashesi.cs.mhealth.data.Medicines;
import com.ashesi.cs.mhealth.data.OPDCases;
import com.ashesi.cs.mhealth.data.Outcome;
import com.ashesi.cs.mhealth.data.Outcomes;
import com.ashesi.cs.mhealth.data.Procedure;
import com.ashesi.cs.mhealth.data.Procedures;
import com.ashesi.cs.mhealth.data.R;
import com.ashesi.cs.mhealth.data.TypeOfAttendance;
import com.ashesi.cs.mhealth.data.TypeOfAttendances;
import com.ashesi.cs.mhealth.data.TypeOfService;
import com.ashesi.cs.mhealth.data.TypeOfServices;

import java.util.ArrayList;

public class NhisClaimFormActivity extends Activity implements AdapterView.OnItemSelectedListener {

    ArrayList<Medicine> listOfMedicines;
    ArrayList<Investigation> listOfInvestigations;
    ArrayList<OPDCases> listOfOPDCases;
    ArrayList<Procedure> listOfProcedures;
    ArrayList<TypeOfAttendance> listOfTypeOfAttendance;
    ArrayList<TypeOfService> listOfTypeOfService;
    ArrayList<Outcome> listOfOutcomes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhis_claim_form_activity);
        listOfTypeOfService = new ArrayList<>();
        listOfInvestigations = new ArrayList<>();
        listOfMedicines = new ArrayList<>();
        listOfProcedures = new ArrayList<>();
        listOfTypeOfAttendance = new ArrayList<>();
        listOfOPDCases = new ArrayList<>();
        listOfOutcomes = new ArrayList<>();

        fillTypeOfServiceSpinner();
        fillInvestigationSpinner();
        fillMedicinesSpinner();
        fillOutcomesSpinner();
        fillProceduresSpinner();
        fillTypeOfAttendanceSpinner();

    }

    public boolean fillTypeOfServiceSpinner(){
        Spinner spinner=(Spinner)findViewById(R.id.spinnerTypeOfServices);
        TypeOfServices services = new TypeOfServices(this.getApplicationContext());
        listOfTypeOfService = services.getTypeOfServices();
        listOfTypeOfService.add(0,new TypeOfService(0,"Select services"));
        ArrayAdapter<TypeOfService> adapter=new ArrayAdapter<TypeOfService>(this,android.R.layout.simple_list_item_1,listOfTypeOfService);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        return true;
    }

    public boolean fillOutcomesSpinner(){
        Spinner spinner=(Spinner)findViewById(R.id.spinnerOutcomes);
        Outcomes outcomes = new Outcomes(this.getApplicationContext());
        listOfOutcomes = outcomes.getOutcomes();
        listOfOutcomes.add(0,new Outcome(0,"Select outcome"));
        ArrayAdapter<Outcome> adapter=new ArrayAdapter<Outcome>(this,android.R.layout.simple_list_item_1,listOfOutcomes);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        return true;
    }

    public boolean fillTypeOfAttendanceSpinner(){
        Spinner spinner=(Spinner)findViewById(R.id.spinnerAttendance);
        TypeOfAttendances attendances = new TypeOfAttendances(this.getApplicationContext());
        listOfTypeOfAttendance = attendances.getTypeOfAttendances();
        listOfTypeOfAttendance.add(0,new TypeOfAttendance(0,"Select attendance"));
        ArrayAdapter<TypeOfAttendance> adapter=new ArrayAdapter<TypeOfAttendance>(this,android.R.layout.simple_list_item_1, listOfTypeOfAttendance);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        return true;
    }
    public boolean fillProceduresSpinner(){
        Spinner spinner=(Spinner)findViewById(R.id.spinnerProcedure);
        Procedures procedures = new Procedures(this.getApplicationContext());
        listOfProcedures = procedures.getProcedures();
        listOfProcedures.add(0,new Procedure(0,"Select procedures"));
        ArrayAdapter<Procedure> adapter=new ArrayAdapter<Procedure>(this,android.R.layout.simple_list_item_1,listOfProcedures);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        return true;

    }
    public boolean fillInvestigationSpinner(){
        Spinner spinner=(Spinner)findViewById(R.id.spinnerInvestigation);
        Investigations investigations = new Investigations(this.getApplicationContext());
        listOfInvestigations = investigations.getInvestigations();
        listOfInvestigations.add(0,new Investigation(0,"Select investigations"));
        ArrayAdapter<Investigation> adapter=new ArrayAdapter<Investigation>(this,android.R.layout.simple_list_item_1,listOfInvestigations);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        return true;
    }
    public boolean fillMedicinesSpinner(){
        Spinner spinner=(Spinner)findViewById(R.id.spinnerMedicines);
        Medicines medicines = new Medicines(this.getApplicationContext());
        listOfMedicines = medicines.getMedicines();
        listOfMedicines.add(0,new Medicine(0,"Select medicines"));
        ArrayAdapter<Medicine> adapter=new ArrayAdapter<Medicine>(this,android.R.layout.simple_list_item_1,listOfMedicines);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

