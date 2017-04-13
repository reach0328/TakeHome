package com.jpark.takehome.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.jpark.takehome.adapter.ItemAdapter;
import com.jpark.takehome.model.Item;
import com.jpark.takehome.R;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {
    private View view = null;
    private ListView listview;
    private Context context;
    private List<Item> list;
    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(view == null)
            view = inflater.inflate(R.layout.fragment_list, container, false);
        listview = (ListView) view.findViewById(R.id.listview);
        list = new ArrayList<>();

        for(int i =0 ; i<1000 ; i++) {
            Item item = new Item("test"+i);
            list.add(item);
        }
        listview.setAdapter(new ItemAdapter(context,list));
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
