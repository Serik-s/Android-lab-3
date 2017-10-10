package com.example.serik.lab3;

import java.util.List;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Serik on 10.10.17.
 */

public interface NetworkAPI {

    @GET("articlesearch.json")
    Call<JSONmodel> getArticles(@Query("api-key") String key);

    @GET("articles")
    Call<List<Article>> getPostsById(@Query("articleID") int articleID);


}
