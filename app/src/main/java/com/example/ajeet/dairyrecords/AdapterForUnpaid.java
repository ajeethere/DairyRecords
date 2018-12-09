package com.example.ajeet.dairyrecords;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class AdapterForUnpaid extends RecyclerView.Adapter<UnpaidViewHolder> {
    List<UnpaidAdaptObject> data;

    public AdapterForUnpaid(List<UnpaidAdaptObject> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public UnpaidViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.unpaid_recycler_view_items
                , viewGroup, false);
        return new UnpaidViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UnpaidViewHolder unpaidViewHolder, int i) {
        UnpaidAdaptObject unpaidAdaptObject = data.get(i);
        unpaidViewHolder.bindItems(unpaidAdaptObject);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
