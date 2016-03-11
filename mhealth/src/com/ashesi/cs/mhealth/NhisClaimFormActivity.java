package com.ashesi.cs.mhealth;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class NhisClaimFormActivity extends Activity implements AdapterView.OnItemSelectedListener,View.OnClickListener {

    ArrayList<Medicine> listOfMedicines;
    ArrayList<Investigation> listOfInvestigations;
    ArrayList<OPDCases> listOfOPDCases;
    ArrayList<Procedure> listOfProcedures;
    ArrayList<TypeOfAttendance> listOfTypeOfAttendance;
    ArrayList<TypeOfService> listOfTypeOfService;
    ArrayList<Outcome> listOfOutcomes;
    private DatePicker visitingDate;
    private TextView visitOne;
    private TextView visitTwo;
    private TextView visitThree;
    private TextView visitFour;
    private Button visitOneSetBtn;
    private Button visitOneUnSetBtn;
    private Button visitTwoSetBtn;
    private Button visitTwoUnSetBtn;
    private Button visitThreeSetBtn;
    private Button visitThreeUnSetBtn;
    private Button visitFourSetBtn;
    private Button visitFourUnSetBtn;

    SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd", Locale.UK);
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

        visitingDate = (DatePicker) findViewById(R.id.dpBirthDate);
        visitOneSetBtn = (Button) findViewById(R.id.setButtonForVisitOne);
        visitOneUnSetBtn = (Button) findViewById(R.id.unsetButtonForVisitOne);
        visitOneSetBtn.setOnClickListener(this);
        visitOneUnSetBtn.setOnClickListener(this);

        visitTwoSetBtn = (Button) findViewById(R.id.setButtonForVisitTwo);
        visitTwoUnSetBtn = (Button) findViewById(R.id.unsetButtonForVisitTwo);
        visitTwoSetBtn.setOnClickListener(this);
        visitTwoUnSetBtn.setOnClickListener(this);

        visitThreeSetBtn = (Button) findViewById(R.id.setButtonForVisitThree);
        visitThreeUnSetBtn = (Button) findViewById(R.id.unsetButtonForVisitThree);
        visitThreeSetBtn.setOnClickListener(this);
        visitThreeUnSetBtn.setOnClickListener(this);

        visitFourSetBtn = (Button) findViewById(R.id.setButtonForVisitFour);
        visitFourUnSetBtn = (Button) findViewById(R.id.unsetButtonForVisitFour);
        visitFourSetBtn.setOnClickListener(this);
        visitFourUnSetBtn.setOnClickListener(this);

        visitOne = (TextView) findViewById(R.id.visitOneTextView);
        visitTwo = (TextView) findViewById(R.id.visitTwoTextView);
        visitThree = (TextView) findViewById(R.id.visitThreeTextView);
        visitFour = (TextView) findViewById(R.id.visitFourTextView);

        fillTypeOfServiceSpinner();
        fillInvestigationSpinner();
        fillMedicinesSpinner();
        fillOutcomesSpinner();
        fillProceduresSpinner();
        fillTypeOfAttendanceSpinner();

    }

    public boolean fillTypeOfServiceSpinner() {
        Spinner spinner = (Spinner) findViewById(R.id.spinnerTypeOfServices);
        TypeOfServices services = new TypeOfServices(this.getApplicationContext());
        listOfTypeOfService = services.getTypeOfServices();
        listOfTypeOfService.add(0, new TypeOfService(0, "Select services"));
        ArrayAdapter<TypeOfService> adapter = new ArrayAdapter<TypeOfService>(this, android.R.layout.simple_list_item_1, listOfTypeOfService);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        return true;
    }

    public boolean fillOutcomesSpinner() {
        Spinner spinner = (Spinner) findViewById(R.id.spinnerOutcomes);
        Outcomes outcomes = new Outcomes(this.getApplicationContext());
        listOfOutcomes = outcomes.getOutcomes();
        listOfOutcomes.add(0, new Outcome(0, "Select outcome"));
        ArrayAdapter<Outcome> adapter = new ArrayAdapter<Outcome>(this, android.R.layout.simple_list_item_1, listOfOutcomes);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        return true;
    }

    public boolean fillTypeOfAttendanceSpinner() {
        Spinner spinner = (Spinner) findViewById(R.id.spinnerAttendance);
        TypeOfAttendances attendances = new TypeOfAttendances(this.getApplicationContext());
        listOfTypeOfAttendance = attendances.getTypeOfAttendances();
        listOfTypeOfAttendance.add(0, new TypeOfAttendance(0, "Select attendance"));
        ArrayAdapter<TypeOfAttendance> adapter = new ArrayAdapter<TypeOfAttendance>(this, android.R.layout.simple_list_item_1, listOfTypeOfAttendance);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        return true;
    }

    public boolean fillProceduresSpinner() {
        Spinner spinner = (Spinner) findViewById(R.id.spinnerProcedure);
        Procedures procedures = new Procedures(this.getApplicationContext());
        listOfProcedures = procedures.getProcedures();
        listOfProcedures.add(0, new Procedure(0, "Select procedures"));
        ArrayAdapter<Procedure> adapter = new ArrayAdapter<Procedure>(this, android.R.layout.simple_list_item_1, listOfProcedures);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        return true;

    }

    public boolean fillInvestigationSpinner() {
        Spinner spinner = (Spinner) findViewById(R.id.spinnerInvestigation);
        Investigations investigations = new Investigations(this.getApplicationContext());
        listOfInvestigations = investigations.getInvestigations();
        listOfInvestigations.add(0, new Investigation(0, "Select investigations"));
        ArrayAdapter<Investigation> adapter = new ArrayAdapter<Investigation>(this, android.R.layout.simple_list_item_1, listOfInvestigations);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        return true;
    }

    public boolean fillMedicinesSpinner() {
        Spinner spinner = (Spinner) findViewById(R.id.spinnerMedicines);
        Medicines medicines = new Medicines(this.getApplicationContext());
        listOfMedicines = medicines.getMedicines();
        listOfMedicines.add(0, new Medicine(0, "Select medicines"));
        ArrayAdapter<Medicine> adapter = new ArrayAdapter<Medicine>(this, android.R.layout.simple_list_item_1, listOfMedicines);
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

    @Override
    public void onClick(View view) {
        if (view == visitOneSetBtn) {
            //   visitOne.setText(visitingDate.getYear()+"-"+visitingDate.getMonth()+"-"+visitingDate.getDayOfMonth());
            visitOne.setText(dateFormat.format(getVisitingDate()));
        }
        if(view == visitOneUnSetBtn){
            visitOne.setText("--/--/--");
        }
        if (view == visitTwoSetBtn) {

            visitTwo.setText(dateFormat.format(getVisitingDate()));
        }
        if(view == visitTwoUnSetBtn){
            visitTwo.setText("--/--/--");
        }
        if (view == visitThreeSetBtn) {

            visitThree.setText(dateFormat.format(getVisitingDate()));
        }
        if(view == visitThreeUnSetBtn){
            visitThree.setText("--/--/--");
        }
        if (view == visitFourSetBtn) {

            visitFour.setText(dateFormat.format(getVisitingDate()));
        }
        if(view == visitFourUnSetBtn){
            visitFour.setText("--/--/--");
        }


    }

    protected java.util.Date getVisitingDate() {

        try {
            Calendar c = Calendar.getInstance();
            c.set(visitingDate.getYear(), visitingDate.getMonth(), visitingDate.getDayOfMonth());

            return c.getTime();
        } catch (Exception ex) {
            return null;
        }
    }
}

