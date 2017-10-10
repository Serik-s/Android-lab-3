package com.example.serik.lab3;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Serik on 10.10.17.
 */

public class ResponseModel {

    @SerializedName("docs")
    @Expose
    private List<Article> docs = null;


    public List<Article> getArticles() {
        return docs;
    }

    public void setArticles(List<Article> docs) {
        this.docs = docs;
    }

}
