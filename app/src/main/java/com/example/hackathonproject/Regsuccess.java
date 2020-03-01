package com.example.hackathonproject;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Regsuccess extends AppCompatActivity {

    EditText HCIDEditText,passwordEditText;
    Button submitDetailsButton;
    HealthcardAPI healthcardAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regsuccess);

        HCIDEditText = (EditText) findViewById(R.id.HCIDEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        submitDetailsButton = (Button) findViewById(R.id.submitDetailsButton);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://hirenmadhu-rest-api-for-healthcard.glitch.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        healthcardAPI = retrofit.create(HealthcardAPI.class);

        submitDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verify();
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });
    }

    private void verify () {

        Post post = new Post(HCIDEditText.getText().toString(),passwordEditText.getText().toString());
        Call<Post> call =healthcardAPI.verify(post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(Regsuccess.this, "Verification failed", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Toast.makeText(Regsuccess.this, "Verification Successful!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.i("if fails",t.getMessage());
            }
        });
    }
}
