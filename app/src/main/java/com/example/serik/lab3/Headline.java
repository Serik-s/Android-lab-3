package com.example.serik.lab3;

import android.arch.persistence.room.Entity;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Serik on 10.10.17.
 */

public class Headline implements Parcelable{

    @SerializedName("main")
    @Expose
    private String main;
    @SerializedName("print_headline")
    @Expose
    private String printHeadline;

    protected Headline(Parcel in) {
        main = in.readString();
        printHeadline = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(main);
        dest.writeString(printHeadline);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Headline> CREATOR = new Creator<Headline>() {
        @Override
        public Headline createFromParcel(Parcel in) {
            return new Headline(in);
        }

        @Override
        public Headline[] newArray(int size) {
            return new Headline[size];
        }
    };

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getPrintHeadline() {
        return printHeadline;
    }

    public void setPrintHeadline(String printHeadline) {
        this.printHeadline = printHeadline;
    }

}
