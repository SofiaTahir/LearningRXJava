package com.example.learningrxjava.Retrofit;

import com.example.learningrxjava.Model.Posts;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface WebAPI {
    @GET("posts")
    Observable<List<Posts>> getPosts();
}
