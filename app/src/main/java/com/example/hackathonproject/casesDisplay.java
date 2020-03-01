package com.example.hackathonproject;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;



public class casesDisplay extends AppCompatActivity {

     HealthcardAPI healthcardAPI;
     TextView detailsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cases_display);

        detailsTextView = findViewById(R.id.detailsTextView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://hirenmadhu-rest-api-for-healthcard.glitch.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        healthcardAPI = retrofit.create(HealthcardAPI.class);

        Call<List<Post>>call = healthcardAPI.getCase();

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
                    details += "\n";
                    details += post.getCID()+"\n\n\n";
                    details += post.getDID()+"\n\n\n";
                    details += post.getHID()+"\n\n\n";
                    details += post.getDate_time()+"\n\n\n";
                    details += post.getProbelm__description()+"\n\n\n";
                    details += post.getEval_and_cure()+"\n\n\n";
                    details += post.getInstruction()+"\n\n\n";
                    details += post.getPrescribed_medicines()+"\n\n\n";
                    details += post.getNextOPDDate()+"\n\n\n";
                    details += post.getViral_disease()+"\n\n\n";
                    detailsTextView.append(details);
                }


            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(casesDisplay.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
