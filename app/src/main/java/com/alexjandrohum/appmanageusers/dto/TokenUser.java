package com.alexjandrohum.appmanageusers.dto;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TokenUser implements Serializable
{

    @SerializedName("token")
    @Expose
    private String token;
    private final static long serialVersionUID = -4257167878843735523L;

    /**
     * No args constructor for use in serialization
     *
     */
    public TokenUser() {
    }

    /**
     *
     * @param token
     */
    public TokenUser(String token) {
        super();
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "TokenUser{" +
                "token='" + token + '\'' +
                '}';
    }
}
