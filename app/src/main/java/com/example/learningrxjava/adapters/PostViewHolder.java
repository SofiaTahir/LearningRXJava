package com.example.learningrxjava.adapters;

import android.view.View;
import android.widget.TextView;

import com.example.learningrxjava.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostViewHolder extends RecyclerView.ViewHolder {
    TextView tvTitle, tvContent;

    public PostViewHolder(@NonNull View itemView) {
        super(itemView);

        tvTitle = itemView.findViewById(R.id.tv_title);
        tvContent = itemView.findViewById(R.id.tv_content);
    }
}
