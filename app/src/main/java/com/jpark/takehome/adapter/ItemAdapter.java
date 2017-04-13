package com.jpark.takehome.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jpark.takehome.adapter.holder.ItemViewHolder;
import com.jpark.takehome.model.Item;
import com.jpark.takehome.R;

import java.util.List;

/**
 * Created by JH on 2017-04-13.
 */

public class ItemAdapter extends BaseAdapter {
    private Context context;
    List<Item> datas;

    public ItemAdapter(Context context, List<Item> datas) {
        this.context = context;
        this.datas = datas;

    }
    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemViewHolder holder = null;
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.user_item,parent,false);
            holder = new ItemViewHolder();
            holder.textView = (TextView) convertView.findViewById(R.id.text_id);
            convertView.setTag(holder);
        } else {
            holder = (ItemViewHolder) convertView.getTag();
        }
        Item item = datas.get(position);
        holder.textView.setText(item.getItemName());
        return convertView;
    }
}
