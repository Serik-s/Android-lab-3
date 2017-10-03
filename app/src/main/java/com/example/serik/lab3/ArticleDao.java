package com.example.serik.lab3;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Serik on 02.10.17.
 */

@Dao
public interface ArticleDao {

    @Query("SELECT * FROM news")
    List<Article> getAll();

    @Insert
    void insert(Article article);

    @Delete
    void delete(Article article);
}
