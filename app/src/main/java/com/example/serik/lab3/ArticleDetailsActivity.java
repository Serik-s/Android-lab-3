package com.example.serik.lab3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Serik on 03.10.17.
 */

public class ArticleDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article_details);

        Article article = getIntent().getParcelableExtra("article");

        TextView title = (TextView) findViewById(R.id.articleTitle);
        TextView text = (TextView) findViewById(R.id.articleText);
        TextView date = (TextView) findViewById(R.id.articleDate);
        ImageView image = (ImageView) findViewById(R.id.articleImage);

        image.setImageResource(R.drawable.football);
        title.setText(article.title);
        text.setText(article.text);
        date.setText(article.publishedDate);
    }
}
