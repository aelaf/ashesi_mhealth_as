package com.ashesi.cs.mhealth;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.ashesi.cs.mhealth.data.CHO;
import com.ashesi.cs.mhealth.data.CHOs;
import com.ashesi.cs.mhealth.data.Community;
import com.ashesi.cs.mhealth.data.R;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by deincrediblelowkey on 04/02/16.
 */
public class ChildWelfareActivity extends Activity implements View.OnClickListener, AdapterView.OnItemSelectedListener,AdapterView.OnItemClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_childwelfare);

        Button b=(Button)findViewById(R.id.buttonAddNewChild);
        b.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch(id){
            case R.id.buttonAddNewChild:
                //page=0;			//new search
                addnewchild();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void addnewchild(){
        //int commmunityId=getSelectedCommunityId();
        //EditText txtCommunityName=(EditText)findViewById(R.id.editCommunityMemberSearchName);
        //String communityMemberName=txtCommunityName.getText().toString();
        Intent intent=new Intent(this,ChildWelfareRecordActivity.class);
        //intent.putExtra("state", CommunityMemberRecordActivity.STATE_NEW_MEMBER);
        //intent.putExtra("communityId",commmunityId);
        //intent.putExtra("name", communityMemberName);
        //intent.putExtra("choId", currentCHO.getId());
        startActivity(intent);
    }
}

