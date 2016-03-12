package com.ashesi.cs.mhealth;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;

import com.ashesi.cs.mhealth.data.Investigation;
import com.ashesi.cs.mhealth.data.InvestigationRecord;
import com.ashesi.cs.mhealth.data.Investigations;
import com.ashesi.cs.mhealth.data.Medicine;
import com.ashesi.cs.mhealth.data.MedicineRecord;
import com.ashesi.cs.mhealth.data.Medicines;
import com.ashesi.cs.mhealth.data.OPDCases;
import com.ashesi.cs.mhealth.data.Outcome;
import com.ashesi.cs.mhealth.data.Outcomes;
import com.ashesi.cs.mhealth.data.Procedure;
import com.ashesi.cs.mhealth.data.ProcedureRecord;
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
    ArrayList<ProcedureRecord> procedureStringList;
    ArrayList<InvestigationRecord> investigationStringList;
    ArrayList<MedicineRecord>  medicineStringList;
    ArrayAdapter<ProcedureRecord> procedureAdapter;
    ArrayAdapter<InvestigationRecord> investigationAdapter;
    ArrayAdapter<MedicineRecord> medicineAdapter;
    ArrayList<Outcome> listOfOutcomes;
    private DatePicker visitingDate;
    private TextView visitOne;
    private TextView visitTwo;
    private TextView visitThree;
    private TextView visitFour;
    private EditText editQuantity;
    private Button visitOneSetBtn;
    private Button visitOneUnSetBtn;
    private Button visitTwoSetBtn;
    private Button visitTwoUnSetBtn;
    private Button visitThreeSetBtn;
    private Button visitThreeUnSetBtn;
    private Button visitFourSetBtn;
    private Button visitFourUnSetBtn;
    private Button procedureAddBtn;
    private Button investigationAddBtn;
    private Button medicineAddBtn;
    private ListView procedureListView;
    private ListView investigationListView;
    private ListView medicineListView;
    private Spinner spinnerAttendance;
    private Spinner spinnerProcedure;
    private Spinner spinnerInvestigation;
    private Spinner spinnerMedicines;
    private Spinner spinnerTypeOfServices;
    private Spinner spinnerOutcomes;


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
        procedureStringList = new ArrayList<>();
        investigationStringList = new ArrayList<>();
        medicineStringList = new ArrayList<>();

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

        editQuantity = (EditText)findViewById(R.id.quantityMedicine);

        spinnerTypeOfServices = (Spinner) findViewById(R.id.spinnerTypeOfServices);
        spinnerOutcomes = (Spinner) findViewById(R.id.spinnerOutcomes);
        spinnerAttendance = (Spinner) findViewById(R.id.spinnerAttendance);
        spinnerProcedure = (Spinner) findViewById(R.id.spinnerProcedure);
        spinnerInvestigation = (Spinner) findViewById(R.id.spinnerInvestigation);
        spinnerMedicines = (Spinner) findViewById(R.id.spinnerMedicines);

        procedureAddBtn =(Button)findViewById(R.id.addProcedureBtn);
        procedureAddBtn.setOnClickListener(this);

        investigationAddBtn =(Button)findViewById(R.id.addInvestigationBtn);
        investigationAddBtn.setOnClickListener(this);

        medicineAddBtn =(Button)findViewById(R.id.addMedicineBtn);
        medicineAddBtn.setOnClickListener(this);

        procedureListView = (ListView) findViewById(R.id.proceduresListView);
        procedureAdapter = new ArrayAdapter<ProcedureRecord>(this,android.R.layout.simple_list_item_1, procedureStringList);
        procedureListView.setAdapter(procedureAdapter);

        investigationListView = (ListView) findViewById(R.id.investigationListView);
        investigationAdapter = new ArrayAdapter<InvestigationRecord>(this,android.R.layout.simple_list_item_1, investigationStringList);
        investigationListView.setAdapter(investigationAdapter);

        medicineListView = (ListView) findViewById(R.id.medicineListView);
        medicineAdapter = new ArrayAdapter<MedicineRecord>(this,android.R.layout.simple_list_item_1, medicineStringList);
        medicineListView.setAdapter(medicineAdapter);

        //spinnerTypeOfServices.setAdapter(adapter);
        fillTypeOfServiceSpinner();
        fillInvestigationSpinner();
        fillMedicinesSpinner();
        fillOutcomesSpinner();
        fillProceduresSpinner();
        fillTypeOfAttendanceSpinner();

    }

    public boolean fillTypeOfServiceSpinner() {
        TypeOfServices services = new TypeOfServices(this.getApplicationContext());
        listOfTypeOfService = services.getTypeOfServices();
        listOfTypeOfService.add(0, new TypeOfService(0, "Select services"));
        ArrayAdapter<TypeOfService> adapter = new ArrayAdapter<TypeOfService>(this, android.R.layout.simple_list_item_1, listOfTypeOfService);
        spinnerTypeOfServices.setAdapter(adapter);
        spinnerTypeOfServices.setOnItemSelectedListener(this);
        return true;
    }

    public boolean fillOutcomesSpinner() {
        Outcomes outcomes = new Outcomes(this.getApplicationContext());
        listOfOutcomes = outcomes.getOutcomes();
        listOfOutcomes.add(0, new Outcome(0, "Select outcome"));
        ArrayAdapter<Outcome> adapter = new ArrayAdapter<Outcome>(this, android.R.layout.simple_list_item_1, listOfOutcomes);
        spinnerOutcomes.setAdapter(adapter);
        spinnerOutcomes.setOnItemSelectedListener(this);
        return true;
    }

    public boolean fillTypeOfAttendanceSpinner() {
        TypeOfAttendances attendances = new TypeOfAttendances(this.getApplicationContext());
        listOfTypeOfAttendance = attendances.getTypeOfAttendances();
        listOfTypeOfAttendance.add(0, new TypeOfAttendance(0, "Select attendance"));
        ArrayAdapter<TypeOfAttendance> adapter = new ArrayAdapter<TypeOfAttendance>(this, android.R.layout.simple_list_item_1, listOfTypeOfAttendance);
        spinnerAttendance.setAdapter(adapter);
        spinnerAttendance.setOnItemSelectedListener(this);
        return true;
    }

    public boolean fillProceduresSpinner() {
        Procedures procedures = new Procedures(this.getApplicationContext());
        listOfProcedures = procedures.getProcedures();
        listOfProcedures.add(0, new Procedure(0, "Select procedures"));
        ArrayAdapter<Procedure> adapter = new ArrayAdapter<Procedure>(this, android.R.layout.simple_list_item_1, listOfProcedures);
        spinnerProcedure.setAdapter(adapter);
        spinnerProcedure.setOnItemSelectedListener(this);
        return true;

    }

    public boolean fillInvestigationSpinner() {
        Investigations investigations = new Investigations(this.getApplicationContext());
        listOfInvestigations = investigations.getInvestigations();
        listOfInvestigations.add(0, new Investigation(0, "Select investigations"));
        ArrayAdapter<Investigation> adapter = new ArrayAdapter<Investigation>(this, android.R.layout.simple_list_item_1, listOfInvestigations);
        spinnerInvestigation.setAdapter(adapter);
        spinnerInvestigation.setOnItemSelectedListener(this);
        return true;
    }

    public boolean fillMedicinesSpinner() {
        Medicines medicines = new Medicines(this.getApplicationContext());
        listOfMedicines = medicines.getMedicines();
        listOfMedicines.add(0, new Medicine(0, "Select medicines"));
        ArrayAdapter<Medicine> adapter = new ArrayAdapter<Medicine>(this, android.R.layout.simple_list_item_1, listOfMedicines);
        spinnerMedicines.setAdapter(adapter);
        spinnerMedicines.setOnItemSelectedListener(this);
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
        if(view == procedureAddBtn){
            addProcedureRecord();

        }
        if(view == investigationAddBtn){
            addInvestigationRecord();
        }
        if(view == medicineAddBtn){
            addMedicineRecord();
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

    private String getLastVisitDate(){
        String lastVisitDate = visitOne.getText()+"";
        String visitTwoString = visitTwo.getText()+"";
        String visitThreeString =visitThree.getText()+"";
        String visitFourString =visitFour.getText()+"";
        if(!visitTwoString.equals("- -/- -/- -")){
            lastVisitDate = visitTwo.getText()+"";

        }
        if(!visitThreeString.equals("- -/- -/- -")){
            lastVisitDate = visitThree.getText()+"";

        }
        if(!visitFourString.equals("- -/- -/- -")){
            lastVisitDate = visitFour.getText()+"";

        }
        return lastVisitDate;

    }


    public static int getItemHeightOfListView(ListView listview){
      int height = 0;
        for(int i = 0;i < listview.getCount(); i++){
            View childview = listview.getAdapter().getView(i,null,listview);
            childview.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
                height+=childview.getMeasuredHeight();
        }
        //dividers height;
        height += listview.getDividerHeight()* listview.getCount();

        return height;

    }

    private void addProcedureRecord(){
        //procedureListView.
        Procedure p = new Procedure();
        p = (Procedure)spinnerProcedure.getSelectedItem();
        ProcedureRecord prec = new ProcedureRecord(p.getId(),p.getProcedure(),getLastVisitDate(),p.getCharge());
        procedureStringList.add(prec);
        procedureAdapter.notifyDataSetChanged();
        ViewGroup.LayoutParams params = procedureListView.getLayoutParams();
        params.height = getItemHeightOfListView(procedureListView);
        procedureListView.setLayoutParams(params);
        procedureListView.requestLayout();

        // visitFour.setText(procedureStringList.size()+""+prec);

    }


    private void addInvestigationRecord(){
        //procedureListView.
        Investigation i = new Investigation();
        i = (Investigation)spinnerInvestigation.getSelectedItem();
        InvestigationRecord irec = new InvestigationRecord(i.getId(),i.getInvestigationName(),getLastVisitDate(),i.getCharge());
        investigationStringList.add(irec);
        investigationAdapter.notifyDataSetChanged();
        ViewGroup.LayoutParams params = investigationListView.getLayoutParams();
        params.height = getItemHeightOfListView(investigationListView);
        investigationListView.setLayoutParams(params);
        investigationListView.requestLayout();

    }

    private void addMedicineRecord(){
        //procedureListView.
        Medicine m = new Medicine();
        m = (Medicine)spinnerMedicines.getSelectedItem();
        int quantity = Integer.parseInt(editQuantity.getText() + "");
        float medicineCharge = m.getCharge()*quantity ;
       MedicineRecord irec = new MedicineRecord(m.getId(),m.getMedicine(),getLastVisitDate(),quantity,medicineCharge);
       medicineStringList.add(irec);
        medicineAdapter.notifyDataSetChanged();
        ViewGroup.LayoutParams params = medicineListView.getLayoutParams();
        params.height = getItemHeightOfListView(medicineListView);
        medicineListView.setLayoutParams(params);
        medicineListView.requestLayout();

    }
}

