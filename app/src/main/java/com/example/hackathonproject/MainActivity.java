package com.example.hackathonproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(getApplicationContext(),Login.class);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent n =new Intent(MainActivity.this,Login.class);
                startActivity(n);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
