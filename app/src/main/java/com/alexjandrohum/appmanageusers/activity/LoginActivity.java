package com.alexjandrohum.appmanageusers.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alexjandrohum.appmanageusers.R;
import com.alexjandrohum.appmanageusers.contract.LoginUserContract;
import com.alexjandrohum.appmanageusers.dao.LoginUserDao;
import com.alexjandrohum.appmanageusers.dto.LoginUser;
import com.alexjandrohum.appmanageusers.dto.TokenUser;
import com.alexjandrohum.appmanageusers.presenter.LoginUserPresenterImpl;
import com.alexjandrohum.appmanageusers.util.Factory;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginUserContract.LoginView {

    private Button btnIniciarSesion;
    private LoginUserPresenterImpl userPresenter;
    private TextInputLayout textInputLayoutUser, textInputLayoutPassword;
    private TextInputEditText textInputEditTextUser, textInputEditTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        getSupportActionBar().hide();
        userPresenter = new LoginUserPresenterImpl(this, new LoginUserDao());
        textInputLayoutUser = findViewById(R.id.outlinedTextFieldUser);
        textInputLayoutPassword = findViewById(R.id.outlinedTextFieldPassword);
        textInputEditTextUser = findViewById(R.id.inputTextUser);
        textInputEditTextPassword = findViewById(R.id.inputTextPassword);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);


        btnIniciarSesion.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnIniciarSesion:
                login();
                break;
        }
    }

    private void login() {
        String user = textInputEditTextUser.getText().toString();
        String password = textInputEditTextPassword.getText().toString();
        if(user.isEmpty() || user.equals("")){
            textInputLayoutUser.setError("Campo necesario");
        } else if (password.isEmpty() || password.equals("")){
            textInputLayoutPassword.setError("Campo necesario");
        } else {
            userPresenter.login(new LoginUser(user, password));
        }
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void obtenerToken(TokenUser tokenUser) {
        Log.i("LOG",tokenUser.toString());
        Toast.makeText(this, "Succefull!!", Toast.LENGTH_SHORT).show();
    }
}