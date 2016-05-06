package com.example.terry.mytianqi.Api;

import com.example.terry.mytianqi.model.Weather;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Terry on 2016/5/6.
 */
public interface MyApiService {

@GET("index")
Call<Weather> weather(@QueryMap Map<String,String> options);
}
