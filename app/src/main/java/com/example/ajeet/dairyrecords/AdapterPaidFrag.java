package com.example.ajeet.dairyrecords;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class AdapterPaidFrag extends RecyclerView.Adapter<PaidViewHolder> {
    List<PaidAdaptObject> data;
    
    public AdapterPaidFrag(List<PaidAdaptObject> data){
        this.data=data;
    }
    
    @NonNull
    @Override
    public PaidViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.paid_recycler_view_items,viewGroup,false);
        return new PaidViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PaidViewHolder paidViewHolder, int i) {
          PaidAdaptObject paidAdaptObject=data.get(i);
          paidViewHolder.bindItems(paidAdaptObject);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
