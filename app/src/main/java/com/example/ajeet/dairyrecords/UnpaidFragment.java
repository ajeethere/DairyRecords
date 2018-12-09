package com.example.ajeet.dairyrecords;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class UnpaidFragment extends Fragment {
RecyclerView unpaidRecyclerView;

    public UnpaidFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_unpaid, container, false);
        unpaidRecyclerView = rootView.findViewById(R.id.recycler_view_unpaid_fragment);

        DairyDBHelper myDB = new DairyDBHelper(getActivity());

        Cursor res=myDB.getAllData();
        Cursor res1=myDB.getAllDataSoldItems();
        List<UnpaidAdaptObject> list = new ArrayList<>();
        while (res.moveToNext()&&res1.moveToNext()){
            double a=res1.getDouble(6);
            if (a>0){
                list.add(new UnpaidAdaptObject(res.getString(0), res.getString(1), res.getString(5)));

            }

        }

        RecyclerView.LayoutManager layoutManager;
        unpaidRecyclerView.setHasFixedSize(true);
        unpaidRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        unpaidRecyclerView.setAdapter(new AdapterForUnpaid(list));

        return rootView;
    }

}
