package com.example.ajeet.dairyrecords;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class PaidViewHolder extends RecyclerView.ViewHolder {
    private View view;
    public PaidViewHolder(@NonNull View itemView) {
        super(itemView);
        view=itemView;
    }
    public void bindItems(PaidAdaptObject paidAdaptObject){
        TextView serialNo=(TextView)view.findViewById(R.id.paidorders_seroial_no_);
        serialNo.setText(paidAdaptObject.getSerialNo());

        TextView name=(TextView)view.findViewById(R.id.paidorder_purchaser_name);
        name.setText(paidAdaptObject.getName());

        TextView contact=(TextView)view.findViewById(R.id.paidorder_contact_no_);
        contact.setText(paidAdaptObject.getContact());
    }
}
