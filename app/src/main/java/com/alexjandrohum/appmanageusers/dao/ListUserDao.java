package com.alexjandrohum.appmanageusers.dao;

import android.util.Log;

import com.alexjandrohum.appmanageusers.contract.ListUserContract;
import com.alexjandrohum.appmanageusers.dto.ListUsers;
import com.alexjandrohum.appmanageusers.util.Factory;
import com.alexjandrohum.appmanageusers.ws.WebService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;

public class ListUserDao implements ListUserContract.ListUserContractDao {

    private final WebService webService;

    public ListUserDao() {
        this.webService = Factory.getWS();
    }

    @Override
    public void getListUser(OnFinishedListener onFinishedListener) {
        Call<ListUsers> listUsersCall =  webService.getListUsers();

        listUsersCall.enqueue(new Callback<ListUsers>() {
            @Override
            public void onResponse(Call<ListUsers> call, Response<ListUsers> response) {
                if (response.isSuccessful()){
                    onFinishedListener.onFinishedListenerShowList(response.body().getData());
                } else {
                    Log.e("LOG", response.message());
                    onFinishedListener.onFinishedListenerShowMessage("Bad REquest");
                }
            }

            @Override
            public void onFailure(Call<ListUsers> call, Throwable t) {
                Log.e("LOG", t.getMessage());
                onFinishedListener.onFinishedListenerShowMessage("Error al conectar con el servicio");
            }
        });
    }
}
