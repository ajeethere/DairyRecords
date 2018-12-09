package com.example.ajeet.dairyrecords;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class UnpaidViewHolder extends RecyclerView.ViewHolder {
    private View view;
    public UnpaidViewHolder(@NonNull View itemView) {
        super(itemView);
        view=itemView;
    }
    public void bindItems(UnpaidAdaptObject unpaidAdaptObject){
        TextView name = view.findViewById(R.id.unpaid_purchaser_name);
        name.setText(unpaidAdaptObject.getName());

        TextView contact = view.findViewById(R.id.unpaid_contact_no_);
        contact.setText(unpaidAdaptObject.getContactNo());


        TextView serial = view.findViewById(R.id.unpaid_seroial_no_);
        serial.setText(unpaidAdaptObject.getSerialNo());
    }
}
