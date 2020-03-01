package com.example.hackathonproject;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText hcidEditText,passwordEditText;
    Button signinButton;
    TextView forgotPasswordTextView,registerTextView;
    String Email;
    HealthcardAPI healthcardAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        hcidEditText = (EditText)findViewById(R.id.hcidEditText);
        passwordEditText = (EditText)findViewById(R.id.passwordEditText);
        signinButton= (Button) findViewById(R.id.signinButton);
        forgotPasswordTextView = (TextView)findViewById(R.id.forgotPasswordTextView);
        registerTextView = (TextView)findViewById(R.id.registerTextView);

        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPost();
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://hirenmadhu-rest-api-for-healthcard.glitch.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        healthcardAPI = retrofit.create(HealthcardAPI.class);

        forgotPasswordTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n=new Intent(Login.this,Forgotpwd.class);
                startActivity(n);
            }
        });

        registerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n=new Intent(Login.this,Signup.class);
                startActivity(n);
            }
        });
    }

    private void createPost() {
        Post post = new Post(hcidEditText.getText().toString(),passwordEditText.getText().toString());


        Call<Post> call = healthcardAPI.createPost(post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(Login.this,"Please Enter Valid Information", Toast.LENGTH_LONG).show();
                    return;
                }

                if(response.code() == 200){
                    Intent n=new Intent(Login.this,Hackathonnav.class);
                    startActivity(n);
                    Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Login.this, "Please Enter Valid Details!", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(Login.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}