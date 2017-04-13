package com.jpark.takehome.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jpark.takehome.adapter.holder.UserViewHolder;
import com.jpark.takehome.model.UserModel;
import com.jpark.takehome.R;

import java.util.List;

/**
 * Created by JH on 2017-04-13.
 */

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder>{
    List<UserModel> datas;

    public UserAdapter(List<UserModel> datas){
        this.datas = datas;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        UserModel user = datas.get(position);
        holder.textView.setText(user.getLogin());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
}
