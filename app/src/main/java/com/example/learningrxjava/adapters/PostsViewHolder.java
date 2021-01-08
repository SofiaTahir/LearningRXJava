package com.example.learningrxjava.adapters;

import android.view.View;
import android.widget.TextView;

import com.example.learningrxjava.R;

import androidx.recyclerview.widget.RecyclerView;

public class PostsViewHolder extends RecyclerView.ViewHolder {
    TextView tvTitle, tvContent;

    public PostsViewHolder(View itemView) {
        super(itemView);
        tvTitle = itemView.findViewById(R.id.tv_title);
        tvContent = itemView.findViewById(R.id.tv_content);
    }
}
