package com.example.learningrxjava.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.learningrxjava.Model.Posts;
import com.example.learningrxjava.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class PostsAdapter extends RecyclerView.Adapter<PostsViewHolder> {
    private Context context;
    private List<Posts> postsList;

    public PostsAdapter(Context context, List<Posts> postsList) {
        this.context = context;
        this.postsList = postsList;
    }

    @Override
    public PostsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_item, parent, false);
        return new PostsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PostsViewHolder holder, int position) {
        Posts post = postsList.get(position);
        holder.tvTitle.setText(post.getTitle());
        holder.tvContent.setText(post.getBody());
    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }
}
