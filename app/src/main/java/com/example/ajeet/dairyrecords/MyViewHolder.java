package com.example.ajeet.dairyrecords;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    private View view;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView;
    }

    public void bindItems(TestObject object) {
        TextView name = view.findViewById(R.id.welcome_purchaser_name);
        name.setText(object.getName());

        TextView contact = view.findViewById(R.id.welcome_contact_no_);
        contact.setText(object.getContactNo());


        TextView serial = view.findViewById(R.id.welcome_seroial_no_);
        serial.setText(object.getSerialNo());
    }
}
