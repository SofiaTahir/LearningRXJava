package com.example.learningrxjava.Retrofit;

import com.example.learningrxjava.Constants;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofitInstance;

    private RetrofitClient() {
    }

    public static Retrofit getInstance() {
        if (retrofitInstance == null)
            retrofitInstance = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        return retrofitInstance;
    }

    private static WebAPI requestApi = getInstance().create(WebAPI.class);

    public static WebAPI getRequestApi(){
        return requestApi;
    }
}
