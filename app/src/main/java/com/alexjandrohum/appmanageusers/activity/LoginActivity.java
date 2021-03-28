package com.alexjandrohum.appmanageusers.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alexjandrohum.appmanageusers.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        getSupportActionBar().hide();
    }
}