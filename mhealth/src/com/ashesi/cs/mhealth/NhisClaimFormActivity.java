package com.ashesi.cs.mhealth;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
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

import com.ashesi.cs.mhealth.data.Bundles;
import com.ashesi.cs.mhealth.data.ClaimRecords;
import com.ashesi.cs.mhealth.data.CommunityMembers;
import com.ashesi.cs.mhealth.data.Investigation;
import com.ashesi.cs.mhealth.data.InvestigationRecord;
import com.ashesi.cs.mhealth.data.InvestigationRecords;
import com.ashesi.cs.mhealth.data.Investigations;
import com.ashesi.cs.mhealth.data.Medicine;
import com.ashesi.cs.mhealth.data.MedicineRecord;
import com.ashesi.cs.mhealth.data.MedicineRecords;
import com.ashesi.cs.mhealth.data.Medicines;
import com.ashesi.cs.mhealth.data.OPDCase;
import com.ashesi.cs.mhealth.data.OPDCaseRecord;
import com.ashesi.cs.mhealth.data.OPDCases;
import com.ashesi.cs.mhealth.data.Outcome;
import com.ashesi.cs.mhealth.data.Outcomes;
import com.ashesi.cs.mhealth.data.Procedure;
import com.ashesi.cs.mhealth.data.ProcedureRecord;
import com.ashesi.cs.mhealth.data.ProcedureRecords;
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
    ArrayList<OPDCase> listOfOPDCases;
    ArrayList<Procedure> listOfProcedures;
    ArrayList<TypeOfAttendance> listOfTypeOfAttendance;
    ArrayList<TypeOfService> listOfTypeOfService;
    ArrayList<ProcedureRecord> procedureStringList;
    ArrayList<InvestigationRecord> investigationStringList;
    ArrayList<MedicineRecord>  medicineStringList;
    ArrayList<OPDCaseRecord> diagnosisStringList;
    ArrayAdapter<ProcedureRecord> procedureAdapter;
    ArrayAdapter<InvestigationRecord> investigationAdapter;
    ArrayAdapter<MedicineRecord> medicineAdapter;
    ArrayAdapter<OPDCaseRecord> diagnosisAdapter;

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
    private Button diagnosisAddBtn;
    private Button claimAddBtn;

    private ListView procedureListView;
    private ListView investigationListView;
    private ListView medicineListView;
    private ListView diagnosisListView;

    private Spinner spinnerAttendance;
    private Spinner spinnerProcedure;
    private Spinner spinnerInvestigation;
    private Spinner spinnerMedicines;
    private Spinner spinnerTypeOfServices;
    private Spinner spinnerOutcomes;
    private Spinner spinnerOPDcases;
    private String newBundleDate;
    private int justAddedBundleId;
    private int justAddedClaimId;

    private float totalProcedureCharge;
    private float totalDiagnosisCharge;
    private float totalInvestigationCharge;
    private float totalMedicinesCharge;

    int communityMemberId=0;
    int communityId;
    int state=0;
    int choId=0;

    SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd", Locale.UK);
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhis_claim_form_activity);
        Intent intent=getIntent();
        choId = intent.getIntExtra("choId",0);
        communityMemberId = intent.getIntExtra("communityMemberId",0);

        justAddedBundleId = 0;
        justAddedClaimId = 0;
         totalProcedureCharge = 0;
         totalDiagnosisCharge = 0;
         totalInvestigationCharge = 0;
         totalMedicinesCharge = 0;

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
        diagnosisStringList = new ArrayList<>();

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
        spinnerOPDcases = (Spinner) findViewById(R.id.spinnerDiagnosis);

        procedureAddBtn =(Button)findViewById(R.id.addProcedureBtn);
        procedureAddBtn.setOnClickListener(this);

        investigationAddBtn =(Button)findViewById(R.id.addInvestigationBtn);
        investigationAddBtn.setOnClickListener(this);

        medicineAddBtn =(Button)findViewById(R.id.addMedicineBtn);
        medicineAddBtn.setOnClickListener(this);

        claimAddBtn = (Button)findViewById(R.id.add_claim);
        claimAddBtn.setOnClickListener(this);

        diagnosisAddBtn = (Button)findViewById(R.id.addDiagnosisBtn);
        diagnosisAddBtn.setOnClickListener(this);

        procedureListView = (ListView) findViewById(R.id.proceduresListView);
        procedureAdapter = new ArrayAdapter<ProcedureRecord>(this,android.R.layout.simple_list_item_1, procedureStringList);
        procedureListView.setAdapter(procedureAdapter);

        investigationListView = (ListView) findViewById(R.id.investigationListView);
        investigationAdapter = new ArrayAdapter<InvestigationRecord>(this,android.R.layout.simple_list_item_1, investigationStringList);
        investigationListView.setAdapter(investigationAdapter);

        medicineListView = (ListView) findViewById(R.id.medicineListView);
        medicineAdapter = new ArrayAdapter<MedicineRecord>(this,android.R.layout.simple_list_item_1, medicineStringList);
        medicineListView.setAdapter(medicineAdapter);

        diagnosisListView = (ListView) findViewById(R.id.diagnosisListView);
        diagnosisAdapter = new ArrayAdapter<OPDCaseRecord>(this,android.R.layout.simple_list_item_1, diagnosisStringList);
        diagnosisListView.setAdapter(diagnosisAdapter);




        //spinnerTypeOfServices.setAdapter(adapter);
        fillTypeOfServiceSpinner();
        fillInvestigationSpinner();
        fillMedicinesSpinner();
        fillOutcomesSpinner();
        fillProceduresSpinner();
        fillTypeOfAttendanceSpinner();
        fillDiagnosisSpinners();
    }

    public boolean fillDiagnosisSpinners(){
        OPDCases opdCases = new OPDCases(this.getApplicationContext());
        listOfOPDCases = opdCases.getOPDcases();
        listOfOPDCases.add(0,new OPDCase(0,"Select case"));
        ArrayAdapter<OPDCase> adapter = new ArrayAdapter<OPDCase>(this,android.R.layout.simple_list_item_1, listOfOPDCases);
        spinnerOPDcases.setAdapter(adapter);
        spinnerOPDcases.setOnItemSelectedListener(this);
        return true;
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
        if(view == diagnosisAddBtn){
            addDiagnosisRecord();

        }
        if(view == investigationAddBtn){
            addInvestigationRecord();
        }
        if(view == medicineAddBtn){
            addMedicineRecord();
        }
        if(view == claimAddBtn){
            saveClaim();
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

    private void addDiagnosisRecord(){
        OPDCase p = new OPDCase();
        p = (OPDCase)spinnerOPDcases.getSelectedItem();
        totalDiagnosisCharge+=p.getCharge();
        OPDCaseRecord prec = new OPDCaseRecord(communityMemberId,p.getID(),p.getOPDCaseName(),getLastVisitDate(),choId,p.getCharge());
        diagnosisStringList.add(prec);
        diagnosisAdapter.notifyDataSetChanged();
        ViewGroup.LayoutParams params = diagnosisListView.getLayoutParams();
        params.height = getItemHeightOfListView(diagnosisListView);
        diagnosisListView.setLayoutParams(params);
        diagnosisListView.requestLayout();

    }

    private void addProcedureRecord(){
        //procedureListView.
        Procedure p = new Procedure();
        p = (Procedure)spinnerProcedure.getSelectedItem();
        totalProcedureCharge+=p.getCharge();
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
        totalInvestigationCharge+=i.getCharge();
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
        totalMedicinesCharge+=medicineCharge;
       MedicineRecord irec = new MedicineRecord(m.getId(),m.getMedicine(),getLastVisitDate(),quantity,medicineCharge);
       medicineStringList.add(irec);
        medicineAdapter.notifyDataSetChanged();
        ViewGroup.LayoutParams params = medicineListView.getLayoutParams();
        params.height = getItemHeightOfListView(medicineListView);
        medicineListView.setLayoutParams(params);
        medicineListView.requestLayout();

    }
     //once the add claim is called, if new bundle is selected  the setNewbundle method is called which
    //in turn calls the add new bundle
    public void saveClaim(){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Add to new or existing bundle?" );
            builder.setPositiveButton("New bundle", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    setNewBundleDate();

                    dialog.dismiss();
                }
            });
        builder.setNegativeButton("Existing bundle", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });

            AlertDialog dialog = builder.create();
            dialog.show();

    }
    //method opens a datepicker dialog for setting the date for a new bundle
    //On date set it calls addNewbundle() which creates a new bundle and retrieves the id of th newly created bundle
    public void  setNewBundleDate(){
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog dpd = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        c.set(year, monthOfYear, dayOfMonth);
                        newBundleDate = dateFormat.format(c.getTime())+"";
                        addNewBundle();
                    }
                }, mYear, mMonth, mDay);
        dpd.show();
        //addNewBundle();
    }

    public void addNewBundle(){
        Bundles bundle = new Bundles(this.getApplicationContext());
        if(bundle.addOrUpdate(newBundleDate)){
           justAddedBundleId = bundle.getJustAddedId();
            addClaimRecord();
        }
    }

    public float computeTotalClaimCharge(){
         return totalDiagnosisCharge + totalInvestigationCharge + totalMedicinesCharge + totalProcedureCharge;

    }
    public void addClaimRecord(){
        ClaimRecords claim = new ClaimRecords((this.getApplicationContext()));
        claim.addOrUpdate(spinnerTypeOfServices.getSelectedItem().toString(), spinnerOutcomes.getSelectedItem().toString(),
                visitOne.getText()+"",visitTwo.getText()+"",visitThree.getText()+"",visitThree.getText()+"",computeTotalClaimCharge(),
                justAddedBundleId);
        justAddedClaimId =claim.getClaimRecordId();
        addProcedures();
        addInvestigations();
        addMedicines();
        addDiagnosis();
    }

    public void addProcedures(){
        ProcedureRecords precords = new ProcedureRecords(this.getApplicationContext());

        for(int i =0 ;i<procedureStringList.size(); i++){
            precords.addOrUpdate(procedureStringList.get(i).getProcedureId(),procedureStringList.get(i).getRecDate(),
                    justAddedClaimId,procedureStringList.get(i).getCharge());
        }
    }

    public void addInvestigations(){
        InvestigationRecords irecords = new InvestigationRecords(this.getApplicationContext());

        for(int i=0 ; i<investigationStringList.size(); i++){
            irecords.addOrUpdate(investigationStringList.get(i).getInvestigationId(),investigationStringList.get(i).getRecDate(),
                    justAddedClaimId,investigationStringList.get(i).getCharge());

        }

    }

    public void addMedicines(){
        MedicineRecords mrecords = new MedicineRecords(this.getApplicationContext());

        for(int i=0; i<medicineStringList.size(); i++){
            mrecords.addOrUpdate(medicineStringList.get(i).getMedicineId(),medicineStringList.get(i).getRecDate(),
                    justAddedClaimId,medicineStringList.get(i).getQuantity(),medicineStringList.get(i).getCharge());

        }

    }
    public void addDiagnosis(){
        CommunityMembers members = new CommunityMembers(this.getApplicationContext());
        //recordOPDCase(int communityMemberId, int opdCaseId, String date, int choId)


        for(int i=0 ; i<diagnosisStringList.size(); i++){
           members.recordOPDCase(communityMemberId,diagnosisStringList.get(i).getOPDCaseId(),diagnosisStringList.get(i).getRecDate(),
                   choId,justAddedClaimId);

        }

    }





}

