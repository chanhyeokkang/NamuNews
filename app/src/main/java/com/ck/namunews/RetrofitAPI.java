package com.ck.namunews;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitAPI {

    @GET("jabistar/data/main/data.json")
    Call<NewsPojo> getNews();
}