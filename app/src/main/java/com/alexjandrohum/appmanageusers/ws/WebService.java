package com.alexjandrohum.appmanageusers.ws;

import com.alexjandrohum.appmanageusers.dto.ListUsers;
import com.alexjandrohum.appmanageusers.dto.LoginUser;
import com.alexjandrohum.appmanageusers.dto.TokenUser;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface WebService {

    @GET("users?page=2")
    Call<ListUsers> getListUsers();

    @POST("login")
    Call<TokenUser> getLoginUser(@Body LoginUser loginUser);

}
