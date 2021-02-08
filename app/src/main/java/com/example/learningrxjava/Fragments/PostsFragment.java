package com.example.learningrxjava.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learningrxjava.Model.Posts;
import com.example.learningrxjava.R;
import com.example.learningrxjava.Retrofit.RetrofitClient;
import com.example.learningrxjava.adapters.PostsAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PostsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PostsFragment extends Fragment {

    private static final String ARG_USER_ID = "userID";
    private int userID;
    private CompositeDisposable disposable;
    private Context context;
    private RecyclerView rvPosts;
    private ProgressBar progressBar;
    private TextView tvNoResults;

    public static PostsFragment newInstance(int param1) {
        PostsFragment fragment = new PostsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_USER_ID, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getContext();
        disposable = new CompositeDisposable();
        if (getArguments() != null) {
            userID = getArguments().getInt(ARG_USER_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_posts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        callPostsService();


    }

    private void initViews(View view) {
        progressBar = view.findViewById(R.id.progressBar);
        rvPosts = view.findViewById(R.id.rv_posts);
        tvNoResults = view.findViewById(R.id.tv_no_results);
        progressBar.setVisibility(View.VISIBLE);
        rvPosts.addItemDecoration(new DividerItemDecoration(context,
                DividerItemDecoration.VERTICAL));
        rvPosts.setVisibility(View.GONE);
        tvNoResults.setVisibility(View.GONE);
    }

    private void callPostsService() {
        disposable.add(RetrofitClient.getRequestApi().getPosts(userID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<Posts>>() {
                    @Override
                    public void onNext(@NonNull List<Posts> posts) {
                        progressBar.setVisibility(View.GONE);
                        displayData(posts);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(context, "Error in fetching data", Toast.LENGTH_SHORT);
                    }

                    @Override
                    public void onComplete() {
                        progressBar.setVisibility(View.GONE);
                    }
                }));
    }

    protected void displayData(List<Posts> postsList) {
        if (postsList != null && postsList.size() > 0) {
            PostsAdapter adapter = new PostsAdapter(context, postsList);
            rvPosts.setHasFixedSize(true);
            rvPosts.setLayoutManager(new LinearLayoutManager(context));
            rvPosts.setAdapter(adapter);
            rvPosts.setVisibility(View.VISIBLE);
            tvNoResults.setVisibility(View.GONE);
        } else {
            tvNoResults.setVisibility(View.VISIBLE);
        }
    }
}