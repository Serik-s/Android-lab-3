package com.example.serik.lab3;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import org.json.JSONArray;
import org.json.JSONException;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.R.id.list;

/**
 * Created by Serik on 25.09.17.
 */

public class RecentNewsFragment extends Fragment {
        // Store instance variables
        private String title;
        private int page;
        ListAdapter listAdapter;
        List<Article> newsList = new ArrayList<>();
//        AppDatabase database;

    // newInstance constructor for creating fragment with arguments
        public static RecentNewsFragment newInstance(int page, String title) {
            RecentNewsFragment recentNews = new RecentNewsFragment();
            Bundle args = new Bundle();
            args.putInt("someInt", page);
            args.putString("someTitle", title);
            recentNews.setArguments(args);
            return recentNews;
        }

        // Store instance variables based on arguments passed
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            page = getArguments().getInt("someInt", 0);
            title = getArguments().getString("someTitle");
//            database = Room.databaseBuilder(getContext().getApplicationContext(),
//                    AppDatabase.class, "news.db").build();

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder().
                    readTimeout(60, TimeUnit.SECONDS).
                    connectTimeout(60, TimeUnit.SECONDS);
            okHttpClient.addInterceptor(interceptor);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.nytimes.com/svc/search/v2/")
                    .client(okHttpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            NetworkAPI service = retrofit.create(NetworkAPI.class);

            Call<JSONmodel> articlesCall = service.getArticles("9308d554d0b745d2bae3f8dfc445e767");

            articlesCall.enqueue(new Callback<JSONmodel>() {
                @Override
                public void onResponse(Call<JSONmodel> call, Response<JSONmodel> response) {
                    if (response.isSuccessful()) {
                        Log.e("THIS IS RESPONSE", response.toString());
//                        Log.e("Response", response.body().toString());
                        JSONmodel jsoNmodel = response.body();
                        List<Article> articles = jsoNmodel.getResponse().getArticles();
                        System.out.println(response.body());
                        for (Article article : articles) {
//                            Log.e("Article", article.getTitle().getPrintHeadline());
                            if (article.imageURL.isEmpty() == false){
                                Log.d("Image URL", article.getMultimedium().get(0).getUrl());
                            }
                        }
                        newsList.clear();
                        newsList.addAll(articles);
                        listAdapter.notifyDataSetChanged();
                    }
                    else {
                        Log.e("Not response", response.toString());
                    }
                }

                @Override
                public void onFailure(Call<JSONmodel> call, Throwable t) {
                    Log.e("onFailure", t.getMessage());
                }

            });

        }

        // Inflate the view for the fragment based on layout XML
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.recent_news_content, container, false);
            TextView tvLabel = (TextView) view.findViewById(R.id.newsID);
            tvLabel.setText(page + " -- " + title);

//            Date currentTime;
//            currentTime = new Date(30123123);
//            for (int i = 1; i < 11; i++) {
//
//                Article article = new Article(i, "title #" + i, currentTime, "Some text", "some url", "some category");
//                newsList.add(article);
//            }

            //        Implementing Recycler View

//
//            Intent intent = getActivity().getIntent();
//            String jsondata = intent.getStringExtra("jsondata");
//
//            JSONArray friendslist;
//            ArrayList<String> friends = new ArrayList<String>();
//
//            try {
//                friendslist = new JSONArray(jsondata);
//                for (int l=0; l < friendslist.length(); l++) {
//                    friends.add(friendslist.getJSONObject(l).getString("name"));
//                    Log.e("Friend_Tag", friendslist.getJSONObject(l).getString("name"));
//                    System.out.println(friendslist.getJSONObject(l).getString("name"));
//
//                }
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }


            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
            listAdapter = new ListAdapter(getActivity(), newsList);
            LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(llm);
            recyclerView.setAdapter(listAdapter);

//            new DatabaseAsync().execute();
            return view;
        }



//    private class DatabaseAsync extends AsyncTask<Void, Void, Void> {
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//
//            //Perform pre-adding operation here.
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
////                Article article = new Article(
////                        1,
////                        "Some title",
////                        "The 2nd of October, 2017",
////                        "lorem ipsum dolor text is a some text that is not familiar to usual users",
////                        "imagename",
////                        "football"
////                );
//            Article article = new Article();
//            database.articleDao().insert(article);
//
//
//            List<Article> articles = database.articleDao().getAll();
//            newsList.addAll(articles);
//            listAdapter.notifyDataSetChanged();
////            newsList = articles;
//            for (Article newArticle: articles){
//                Log.e("New is ", newArticle.getTitle() + " " + newArticle.getDate());
//            }
//
//
//
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
//
//            //To after addition operation here.
//        }
//    }
}