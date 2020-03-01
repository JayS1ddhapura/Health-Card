package com.example.hackathonproject.ui.healthhistory;

import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.hackathonproject.Healthhistory;
import com.example.hackathonproject.Labreport;
import com.example.hackathonproject.Medicine;
import com.example.hackathonproject.R;
import com.example.hackathonproject.casesDisplay;

import java.util.ArrayList;

public class healthFragment extends Fragment {

    private HealthViewModel mViewModel;

    Toolbar toolbar;
    public static healthFragment newInstance() {
        return new healthFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.health_fragment, container, false);
        Button caseButton= (Button) v.findViewById(R.id.caseButton);
        Button medicineButton = (Button) v.findViewById(R.id.medicineButton);
        Button labReportButton = (Button) v.findViewById(R.id.labReportButton);

        ArrayList<String> caseList = new ArrayList<>();
        caseList.add("case1 : Cold");
        caseList.add("case2 : Flue");
        caseList.add("case3 : Diarrhea");
        ListView caseListView = v.findViewById(R.id.caseListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_expandable_list_item_1,caseList);
        caseListView.setAdapter(adapter);

        caseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent caseIntent = new Intent(view.getContext(), casesDisplay.class);
                startActivity(caseIntent);
            }
        });
        toolbar=(Toolbar)v.findViewById(R.id.toolbar2);

        caseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentc = new Intent ("Healthhistory");
            }
        });


        medicineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentMedicine = new Intent(getContext(), Medicine.class);
                startActivity(intentMedicine);
                //overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

            }
        });
        labReportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent labReportIntent = new Intent(getContext(),Labreport.class);
                startActivity(labReportIntent);
            }
        });

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HealthViewModel.class);
        // TODO: Use the ViewModel

    }

}
