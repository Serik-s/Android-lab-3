package com.example.serik.lab3;
import android.arch.persistence.room.Ignore;
import android.media.Image;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Date;

/**
 * Created by Serik on 25.09.17.
 */

//@Entity(tableName = "news")
public class Article implements Parcelable
{
    @SerializedName("articleID")
    @Expose
//    @PrimaryKey
    public  int articleID;

    @SerializedName("headline")
    @Expose
    public Headline title;

    @SerializedName("pub_date")
    @Expose
    public String publishedDate;

    @SerializedName("snippet")
    @Expose
    public String text;

    @SerializedName("uri")
    public String imageURL;

    @SerializedName("section_name")
    @Expose
    public String category;


    public  Article() {
//        articleID = 12;
//        title = "The best moments in football in history";
//        publishedDate = "3rd of October, 2017";
//        text = "There was a big challenge in football history";
//        imageURL = "football";
//        category = "Sport";
    }

    @Ignore
    public Article(int articleID, Headline title, String publishedDate, String text, String imageURL, String category) {
        this.articleID = articleID;
        this.title = title;
        this.publishedDate = publishedDate;
        this.text = text;
        this.imageURL = imageURL;
        this.category = category;
    }


    protected Article(Parcel in) {
        articleID = in.readInt();
        title = in.readParcelable(Headline.class.getClassLoader());
        publishedDate = in.readString();
        text = in.readString();
        imageURL = in.readString();
        category = in.readString();
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    Headline getTitle() {
        return title;
    }

    String getDate() {
        return publishedDate;
    }

    String getText() {return text;}

    public void setTitle(Headline title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(String date) { this.publishedDate =  date; }
    @Override
    public String toString() {
        return title + " " + publishedDate + "\n";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(articleID);
        parcel.writeParcelable(title, i);
        parcel.writeString(publishedDate);
        parcel.writeString(text);
        parcel.writeString(imageURL);
        parcel.writeString(category);
    }
}
