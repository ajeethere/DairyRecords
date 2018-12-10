package com.example.ajeet.dairyrecords;


import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomeFragment extends Fragment {
    RecyclerView welFragListView;
    ArrayList<String> buyerListItems;

    public WelcomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_welcome, container, false);
        welFragListView = rootView.findViewById(R.id.recycler_view_main_activity);

        DairyDBHelper myDB = new DairyDBHelper(getActivity());

        final Cursor res=myDB.getAllData();
        Cursor res1=myDB.getAllDataSoldItems();
        List<WelcomeAdaptObject> list = new ArrayList<>();
        while (res.moveToNext()&&res1.moveToNext()){
            list.add(new WelcomeAdaptObject(res.getString(1), res.getString(0), res.getString(5),
                    res1.getDouble(6),getContext()));

        }

        RecyclerView.LayoutManager layoutManager;
        welFragListView.setHasFixedSize(true);
        welFragListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        welFragListView.setAdapter(new AdapterForWel(list));


        welFragListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"clicked" ,Toast.LENGTH_LONG).show();
            }
        });

        return rootView;

    }

}

