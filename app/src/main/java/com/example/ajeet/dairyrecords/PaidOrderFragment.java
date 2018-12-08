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
public class PaidOrderFragment extends Fragment {
    RecyclerView paidFragRecyclerView;

    public PaidOrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_paid_order, container, false);

        paidFragRecyclerView=(RecyclerView)rootView.findViewById(R.id.paid_orders_recycler_view);
        DairyDBHelper dairyDBHelper=new DairyDBHelper(getActivity());
        Cursor res=dairyDBHelper.getAllData();
        Cursor res1=dairyDBHelper.getAllDataSoldItems();
        List<PaidAdaptObject> list = new ArrayList<>();
        while (res.moveToNext()){
//            double a=res1.getDouble(6);
  //          if (a==0){
            list.add(new PaidAdaptObject(res.getString(0),res.getString(1),res.getString(5)));}
    //    }
        RecyclerView.LayoutManager layoutManager;
        paidFragRecyclerView.setHasFixedSize(true);
        paidFragRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        paidFragRecyclerView.setAdapter(new AdapterPaidFrag(list));

        return rootView;
    }

}
