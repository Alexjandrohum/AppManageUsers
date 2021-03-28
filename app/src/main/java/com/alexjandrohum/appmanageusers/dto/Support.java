
package com.alexjandrohum.appmanageusers.dto;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Support implements Serializable
{

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("text")
    @Expose
    private String text;
    private final static long serialVersionUID = -7439169482893698544L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Support() {
    }

    /**
     * 
     * @param text
     * @param url
     */
    public Support(String url, String text) {
        super();
        this.url = url;
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Support{" +
                "url='" + url + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
