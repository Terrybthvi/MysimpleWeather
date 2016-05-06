package com.example.terry.mytianqi.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Terry on 2016/5/6.
 */
public class MyApiClient {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://v.juhe.cn/weather/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    public MyApiService service = retrofit.create(MyApiService.class);
}
