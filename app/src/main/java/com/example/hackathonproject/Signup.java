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
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Signup extends AppCompatActivity {
    private EditText firstNameEditText,lastNameEditText,phoneNumberEditText,cityEditText,address1EditText,address2EditText,stateEditTex,postalCodeEditText,districtEditText,emailEditText,aadharCardNumberEditText,weightEditText,heightEditText,bloodGroupEditText,dateOfBirthedittext;
    private Button submitButton;
    String exp="[a-zA-Z]+";
    TextView backButton;
    private HealthcardAPI healthcardAPI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        firstNameEditText = (EditText)findViewById(R.id.firstNameEditText);
        lastNameEditText = (EditText)findViewById(R.id.lastNameEditText);
        phoneNumberEditText = (EditText)findViewById(R.id.phoneNumberEditText);
        cityEditText = (EditText)findViewById(R.id.cityEditText);
        address1EditText = (EditText)findViewById(R.id.address1EditText);
        address2EditText=(EditText)findViewById(R.id.address2EditText);
        stateEditTex= (EditText)findViewById(R.id.stateEditText);
        postalCodeEditText = (EditText)findViewById(R.id.postalCodeEditText);
        districtEditText = (EditText)findViewById(R.id.districtEditText);
        emailEditText = (EditText)findViewById(R.id.emailEditText);
        aadharCardNumberEditText = (EditText)findViewById(R.id.aadharcardEditText);
        weightEditText = (EditText) findViewById(R.id.weightEditText);
        heightEditText = (EditText) findViewById(R.id.heightEditText);
        bloodGroupEditText = (EditText) findViewById(R.id.bloodGroupEditText);
        dateOfBirthedittext=(EditText)findViewById(R.id.dateOfBirthEditText);
        submitButton = (Button)findViewById(R.id.submitButton);
        backButton =(TextView)findViewById(R.id.back);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://hirenmadhu-rest-api-for-healthcard.glitch.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        healthcardAPI = retrofit.create(HealthcardAPI.class);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                register();
                if(validatefinal())
                {
                    Toast.makeText(Signup.this, "done", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),Regsuccess.class);
                    startActivity(intent);
                }

            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Regsuccess.class);
                startActivity(intent);
            }
        });
    }



    public boolean validatefinal()
    {
        String firstname=firstNameEditText.getText().toString();
        CharSequence firstnameseq=firstname;
        String lastname=lastNameEditText.getText().toString();
        CharSequence lastnameseq=firstname;
        String mobile=phoneNumberEditText.getText().toString();
        String mobexp="[0-9]{10}";
        String aadharexp="[0-9]{12}";
        String aadharstring=aadharCardNumberEditText.getText().toString();
        String aadharwithoutspace=aadharstring.replace(" ","");
        String pinexp="[0-9]{6}";
        String pinstring=postalCodeEditText.getText().toString();
        String pinwithoutspace=pinstring.replace(" ","");
        String emailexp="[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+";

        if(firstNameEditText.length()==0 || lastNameEditText.length()==0 || phoneNumberEditText.length()==0|| address1EditText.length()==0 || address2EditText.length()==0 || cityEditText.length()==0 || districtEditText.length()==0 || postalCodeEditText.length()==0 || stateEditTex.length()==0 || emailEditText.length()==0 || aadharCardNumberEditText.length()==0 || weightEditText.length()==0 || heightEditText.length()==0 || bloodGroupEditText.length()==0 || dateOfBirthedittext.length()==0 )
         if(!firstnameseq.toString().matches("[a-zA-Z]+"))
        {
         // Toast.makeText(Signup.this,"username contains characters only",Toast.LENGTH_SHORT).show();
            firstNameEditText.setError("firstname contains characters only");
            return false;
        }
        else if(!lastnameseq.toString().matches("[a-zA-Z]+"))
        {
            // Toast.makeText(Signup.this,"username contains characters only",Toast.LENGTH_SHORT).show();
            lastNameEditText.setError("lastname contains characters only");
            return false;
        }else if(!phoneNumberEditText.getText().toString().matches(mobexp))
        {
            phoneNumberEditText.setError("mobile number should contain 10 digits only");
            return false;
        }else if(!aadharwithoutspace.matches(aadharexp))
         {
             aadharCardNumberEditText.setError("aadhar number should contain 12 digits only");
             return false;
         }
         else if(!pinwithoutspace.matches(pinexp))
         {
             postalCodeEditText.setError("pin code should contain 6 digits only");
             return false;
         }else if(!emailEditText.getText().toString().matches(emailexp))
         {
             emailEditText.setError("invalid email");
             return false;
         }
        return true;
    }


    private void register() {


        final Post post = new Post(firstNameEditText.getText().toString(), lastNameEditText.getText().toString(),phoneNumberEditText.getText().toString(),
                             address1EditText.getText().toString(),address2EditText.getText().toString(),cityEditText.getText().toString(),
                                districtEditText.getText().toString(),postalCodeEditText.getText().toString(),stateEditTex.getText().toString(),
                                emailEditText.getText().toString(),aadharCardNumberEditText.getText().toString());

        Call<Post> call = healthcardAPI.register(post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(!response.isSuccessful()){
                    Log.i("server error",Integer.toString(response.code()));
                    return;
                }

                Post postResponce = response.body();
                Log.i("anything",postResponce.getCID());
                Log.i("anything",postResponce.getDID());
                Log.i("anything",postResponce.getHID());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });


    }
}

