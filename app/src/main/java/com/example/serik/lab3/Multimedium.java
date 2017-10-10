package com.example.serik.lab3;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Serik on 10.10.17.
 */

public class Multimedium implements Parcelable {
    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("subtype")
    @Expose
    private String subtype;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("height")
    @Expose
    private Integer height;

    @SerializedName("width")
    @Expose
    private Integer width;

    @SerializedName("rank")
    @Expose
    private Integer rank;

    protected Multimedium(Parcel in) {
        type = in.readString();
        subtype = in.readString();
        url = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(type);
        dest.writeString(subtype);
        dest.writeString(url);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Multimedium> CREATOR = new Creator<Multimedium>() {
        @Override
        public Multimedium createFromParcel(Parcel in) {
            return new Multimedium(in);
        }

        @Override
        public Multimedium[] newArray(int size) {
            return new Multimedium[size];
        }
    };

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

}
