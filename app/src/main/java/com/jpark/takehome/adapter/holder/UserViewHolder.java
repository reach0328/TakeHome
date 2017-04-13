package com.jpark.takehome.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.jpark.takehome.R;

public class UserViewHolder extends RecyclerView.ViewHolder{
    public TextView textView;

    public UserViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.text_id);
    }
}
