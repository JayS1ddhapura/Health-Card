package com.example.hackathonproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;

public class Newhealth extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newhealth);
        Button medicineButton = (Button)findViewById(R.id.medicineButton);
        Button labReportButton = (Button)findViewById(R.id.labReportButton);

        ArrayList<String> caseList = new ArrayList<>();
        caseList.add("case1 : Cold");
        caseList.add("case2 : Flue");
        caseList.add("case3 : Diarrhea");
        ListView caseListView = (ListView) findViewById(R.id.caseListView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,caseList);
        caseListView.setAdapter(adapter);

        caseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent caseIntent = new Intent(getApplicationContext(), casesDisplay.class);
                startActivity(caseIntent);
            }
        });

        TextView backButtonTextView = (TextView)findViewById(R.id.backButtonTextView);
        toolbar=(Toolbar)findViewById(R.id.toolbar2);
        toolbar.setTitle("Health history");

        backButtonTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n=new Intent(getApplicationContext(),Hackathonnav.class);
                startActivity(n);
            }
        });

        medicineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentMedicine = new Intent(getApplicationContext(), Medicine.class);
                startActivity(intentMedicine);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

        labReportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentLabReport = new Intent(getApplicationContext(),Labreport.class);
                startActivity(intentLabReport);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        }); Button caseButton = (Button)findViewById(R.id.caseButton);



    }
    }
