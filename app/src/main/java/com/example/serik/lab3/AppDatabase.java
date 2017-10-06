package com.example.serik.lab3;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Serik on 02.10.17.
 */

@Database(entities = {Article.class}, version = 4)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ArticleDao articleDao();
}
