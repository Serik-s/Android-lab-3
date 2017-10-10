package com.example.serik.lab3;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Serik on 10.10.17.
 */

public class JSONmodel {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("response")
    @Expose
    private ResponseModel response;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public ResponseModel getResponse() {
        return response;
    }

    public void setResponse(ResponseModel response) {
        this.response = response;
    }

}
