package com.example.hackathonproject;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class labReportDisplay extends AppCompatActivity {

    TextView detailsTextView;
    HealthcardAPI healthcardAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_report_display);

        detailsTextView = findViewById(R.id.detailsTextView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://hirenmadhu-rest-api-for-healthcard.glitch.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        healthcardAPI = retrofit.create(HealthcardAPI.class);
        Call<List<Post>> call = healthcardAPI.getLabReport();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()) {
                    detailsTextView.setText("Code:" + response.code());
                    return;
                }

                List<Post> posts = response.body();

                for(Post post : posts){
                    String details = "";

                    details += post.getLRID()+"\n\n\n";
                    details += post.getLID()+"\n\n\n";
                    details += post.getLDID()+"\n\n\n";
                    details += post.getDate_time()+"\n\n\n";
                    details += post.getByReferenceOf()+"\n\n\n";

                    detailsTextView.append(details);
                }

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}
