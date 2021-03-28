package com.alexjandrohum.appmanageusers.util;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit = null;

    static Retrofit getClient() {
        if (retrofit == null) {
            try {
                OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
                builder.connectTimeout(Constant.TIME_OUT_READ_HTTP, TimeUnit.MILLISECONDS)
                        .readTimeout(Constant.TIME_OUT_READ_HTTP, TimeUnit.MILLISECONDS)
                        .writeTimeout(Constant.TIME_OUT_READ_HTTP, TimeUnit.MILLISECONDS);
                retrofit = new Retrofit.Builder()
                        .baseUrl(Constant.URL)
                        .addConverterFactory(ScalarsConverterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(builder.build())
                        .build();
            } catch (Exception e) {
                Log.e("LOG", "RetrofitClient.class => .getClient(): " + e.getMessage());
            }
        }
        return retrofit;
    }

    static void destroyCLient() {
        retrofit = null;
    }
}
