package com.alexjandrohum.appmanageusers.util;

import com.alexjandrohum.appmanageusers.ws.WebService;

public class Factory {

    public static WebService getWS () {
        return RetrofitClient.getClient().create(WebService.class);
    }
}
