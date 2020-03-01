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

public class Labreport extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labreport);

        Button caseButton = (Button)findViewById(R.id.caseButton);
        Button medicineButton = (Button)findViewById(R.id.medicineButton);
        Button labReportButton = (Button)findViewById(R.id.labReportButton);

        ArrayList<String> labReportList = new ArrayList<>();
        labReportList.add("Report 1 : high BP");
        labReportList.add("Report 2 : high sugar");
        labReportList.add("Report 3 : low BP");
        ListView labReportListView = (ListView) findViewById(R.id.labReportListView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,labReportList);
        labReportListView.setAdapter(adapter);

        labReportListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent labReportIntent = new Intent(getApplicationContext(), labReportDisplay.class);
                startActivity(labReportIntent);
            }
        });

        toolbar=(Toolbar)findViewById(R.id.toolbar2);
        toolbar.setTitle("Health history");
        
        TextView backButtonTextView=(TextView)findViewById(R.id.backButtonTextView);

        backButtonTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n=new Intent(Labreport.this,Hackathonnav.class);
                startActivity(n);
            }
        });



        caseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHealthHistory = new Intent(Labreport.this, Healthhistory.class);
                startActivity(intentHealthHistory);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

        medicineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMedicine = new Intent(Labreport.this, Medicine.class);
                startActivity(intentMedicine);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }

        });

    }
}
