package com.alexjandrohum.appmanageusers.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alexjandrohum.appmanageusers.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputLayout textInputLayoutEmailRegister, textInputLayoutPasswordResgister1, textInputLayoutPasswordRegister2;
    private TextInputEditText editTextEmailRegister, editTextPasswordRegister1, editTextPasswordRegister2;
    private Button buttonRegister;
    private TextView textViewCancelarRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().hide();

        textInputLayoutEmailRegister = findViewById(R.id.textInputLayoutEmailRegister);
        textInputLayoutPasswordResgister1 = findViewById(R.id.textInputLayoutPassword1);
        textInputLayoutPasswordRegister2 = findViewById(R.id.textInputLayoutPassword2);
        editTextEmailRegister = findViewById(R.id.textinputEditTextEmailRegister);
        editTextPasswordRegister1 = findViewById(R.id.textInputEditTextPassword1);
        editTextPasswordRegister2 = findViewById(R.id.textInputEditTextPassword2);
        buttonRegister = findViewById(R.id.btnRegister);
        textViewCancelarRegister = findViewById(R.id.textViewCancelarRegister);

        buttonRegister.setOnClickListener(this);
        textViewCancelarRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRegister:
                registerUser();
                break;
            case R.id.textViewCancelarRegister:
                Intent intentBackLogin = new Intent(this, LoginActivity.class);
                startActivity(intentBackLogin);
                break;
        }
    }

    private void registerUser() {
        textInputLayoutEmailRegister.setError("");
        textInputLayoutPasswordResgister1.setError("");
        textInputLayoutPasswordRegister2.setError("");
        String email = editTextEmailRegister.getText().toString();
        String password1 = editTextPasswordRegister1.getText().toString();
        String password2 = editTextPasswordRegister2.getText().toString();
        if (email.isEmpty() || email.equals("")){
            textInputLayoutEmailRegister.setError("El campo es requerido");
        } else if(password1.isEmpty() || password1.equals("")){
            textInputLayoutPasswordResgister1.setError("El campo es requerido");
        } else if (password2.isEmpty() || password2.equals("")){
            textInputLayoutPasswordRegister2.setError("El campo es requerido");
        } else if( !password1.equals(password2)){
            textInputLayoutPasswordResgister1.setError("No coincide");
            textInputLayoutPasswordRegister2.setError("No coincide");
        } else {
            Intent intentRegister = new Intent(this, LoginActivity.class);
            startActivity(intentRegister);
        }
    }
}