package com.example.learningrxjava.Retrofit;

import com.example.learningrxjava.Model.Comments;
import com.example.learningrxjava.Model.Posts;
import com.example.learningrxjava.Model.Users;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WebAPI {
    @GET("posts")
    Observable<List<Posts>> getPosts(@Query("userId") int id);

    @GET("users/{id}")
    Flowable<Users> getUsers(@Path("id") int id);

    @GET("posts/{postId}/comments")
    Observable<List<Comments>> getPostComments(@Path("postId") int postId);

}
