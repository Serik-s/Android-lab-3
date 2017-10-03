package com.example.serik.lab3;
import android.arch.persistence.room.Ignore;
import android.media.Image;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import java.sql.Date;

/**
 * Created by Serik on 25.09.17.
 */

@Entity(tableName = "news")
public class Article implements Parcelable
{
    @PrimaryKey
    @ColumnInfo(name = "articleID")
    public  int articleID;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "publishedDate")
    public String publishedDate;

    @ColumnInfo(name = "text")
    public String text;

    @ColumnInfo(name = "imageURL")
    public String imageURL;

    @ColumnInfo(name = "category")
    public String category;


    public  Article() {
        title = "The best moments in football in history";
        publishedDate = "3rd of October, 2017";
        text = "There was a big challenge in football history";
        imageURL = "football";
        category = "Sport";
    }

    @Ignore
    public Article(int articleID, String title, String publishedDate, String text, String imageURL, String category) {
        this.articleID = articleID;
        this.title = title;
        this.publishedDate = publishedDate;
        this.text = text;
        this.imageURL = imageURL;
        this.category = category;
    }

    protected Article(Parcel in) {
        articleID = in.readInt();
        title = in.readString();
        publishedDate = in.readString();
        text = in.readString();
        imageURL = in.readString();
        category = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(articleID);
        dest.writeString(title);
        dest.writeString(publishedDate);
        dest.writeString(text);
        dest.writeString(imageURL);
        dest.writeString(category);
    }

    @Override
    public int describeContents() {
        return 0;
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

    String getTitle() {
        return title;
    }

    String getDate() {
        return publishedDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return title + " " + publishedDate + "\n";
    }
}
