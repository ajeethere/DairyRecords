package com.example.ajeet.dairyrecords;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

public class AdapterForWel extends RecyclerView.Adapter<WelcomeViewHolder> {

    List<WelcomeAdaptObject> data;

    public AdapterForWel(List<WelcomeAdaptObject> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public WelcomeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.welcome_listview_items, viewGroup, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(v.getContext(),"clicked",Toast.LENGTH_LONG).show();
            }
        });
        return new WelcomeViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull WelcomeViewHolder welcomeViewHolder, int i) {
        WelcomeAdaptObject object = data.get(i);
        welcomeViewHolder.bindItems(object);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}
