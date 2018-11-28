package com.example.ajeet.dairyrecords;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class AdapterForWel extends RecyclerView.Adapter<MyViewHolder> {

    List<TestObject> data;

    public AdapterForWel(List<TestObject> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.welcome_listview_items, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        TestObject object = data.get(i);
        myViewHolder.bindItems(object);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
