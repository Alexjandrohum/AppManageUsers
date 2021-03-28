package com.alexjandrohum.appmanageusers.dao;

import android.util.Log;

import com.alexjandrohum.appmanageusers.contract.LoginUserContract;
import com.alexjandrohum.appmanageusers.dto.LoginUser;
import com.alexjandrohum.appmanageusers.dto.TokenUser;
import com.alexjandrohum.appmanageusers.util.Factory;
import com.alexjandrohum.appmanageusers.ws.WebService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginUserDao implements LoginUserContract.LoginDao {

    private final WebService ws;

    public LoginUserDao() {
        this.ws = Factory.getWS();
    }

    @Override
    public void login(LoginUser loginUser, OnFinishedListener onFinishedListener) {
        Call<TokenUser> call = ws.getLoginUser(loginUser);
        call.enqueue(new Callback<TokenUser>() {
            @Override
            public void onResponse(Call<TokenUser> call, Response<TokenUser> response) {
                if (response.isSuccessful()){
                    onFinishedListener.onFinishedLogin(response.body());
                }else {
                    Log.e("LOG", response.message());
                    onFinishedListener.onFinishedError("Error al conectar con el servicio!");
                }
            }

            @Override
            public void onFailure(Call<TokenUser> call, Throwable t) {
                Log.e("LOG",t.getMessage());
                onFinishedListener.onFinishedError("El servicio fallo");
            }
        });

    }
}
