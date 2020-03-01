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

public class Medicine extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);
        Button caseButton = (Button)findViewById(R.id.caseButton);
        Button medicineButton = (Button)findViewById(R.id.medicineButton);
        Button labReportButton = (Button)findViewById(R.id.labReportButton);

        ArrayList<String> medicineList = new ArrayList<>();
        medicineList.add("medicine1 : paracetamol");
        medicineList.add("medicine2 : aspirine");
        medicineList.add("medicine3 : acetomol");
        ListView medicineListView = (ListView) findViewById(R.id.medicineListView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,medicineList);
        medicineListView.setAdapter(adapter);

        medicineListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent medicineIntent = new Intent(getApplicationContext(), medicineDisplay.class);
                startActivity(medicineIntent);
            }
        });

        toolbar=(Toolbar)findViewById(R.id.toolbar2);
        toolbar.setTitle("Health history");
        TextView backButtonTextView = (TextView)findViewById(R.id.backButtonTextView);


        backButtonTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n=new Intent(Medicine.this,Hackathonnav.class);
                startActivity(n);
            }
        });

        caseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n=new Intent(Medicine.this,Healthhistory.class);
                startActivity(n);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

        labReportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLabReport=new Intent(getApplicationContext(),Labreport.class);
                startActivity(intentLabReport);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });
    }
}
