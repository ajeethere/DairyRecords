package com.example.ajeet.dairyrecords;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ajeet.dairyrecords.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewBuyerFragment extends Fragment {
    EditText nameTxt,surNameTxt,fathersNameTxt,addressTxt,phoneTxt;
    Button productNextBtn,paymentNextBtn,orderDoneBtn;
    RadioButton cashRadioBtn,dueRadioBtn;
    LinearLayout buyerDetailsLayout,productDetailsLayout,paymentDetailsLayout,dueLayout;
    View rootView=null;
    DairyDBHelper dairyDBHelper;

    public NewBuyerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.rootView= inflater.inflate(R.layout.fragment_new_buyer, container, false);
        dairyDBHelper=new DairyDBHelper(getActivity());
        String[] arraySpinner = new String[] {
                "Select Product", "Milk", "Meva", "Mishri Meva", "Ghee" ,"Burfi" , "Rasgulla" , "Rasbhari" , "Gulabjamun"
        };
        Spinner s = (Spinner) rootView.findViewById(R.id.product_details_select_product_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        s.setAdapter(adapter);
        buyerDetailsLayout=(LinearLayout)rootView.findViewById(R.id.buyer_details_layout);
        productDetailsLayout=(LinearLayout)rootView.findViewById(R.id.order_detail_layout);
        paymentDetailsLayout=(LinearLayout)rootView.findViewById(R.id.payment_details_layout);
        dueLayout=(LinearLayout)rootView.findViewById(R.id.due_layout);
        nameTxt=(EditText)rootView.findViewById(R.id.newbuyer_buyer_name);
        surNameTxt=(EditText)rootView.findViewById(R.id.newbuyer_buyer_sur_name);
        fathersNameTxt=(EditText)rootView.findViewById(R.id.newbuyer_buyer_fathers_name);
        addressTxt=(EditText)rootView.findViewById(R.id.newbuyer_buyer_address);
        phoneTxt=(EditText)rootView.findViewById(R.id.newbuyer_buyer_phone);
        orderDoneBtn=(Button)rootView.findViewById(R.id.cash_done_btn);
        productNextBtn=(Button)rootView.findViewById(R.id.newbuyer_save_buyer_and_move_to_order_btn);
        cashRadioBtn=(RadioButton)rootView.findViewById(R.id.cash_radio_btn);
        cashRadioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dueLayout.setVisibility(View.GONE);
             orderDoneBtn.setVisibility(View.VISIBLE);
            }
        });
        dueRadioBtn=(RadioButton)rootView.findViewById(R.id.due_radio_btn);
        dueRadioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderDoneBtn.setVisibility(View.GONE);
                dueLayout.setVisibility(View.VISIBLE);
            }
        });
        paymentNextBtn=(Button)rootView.findViewById(R.id.payment_next_btn);
        paymentNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productDetailsLayout.setVisibility(View.GONE);
                paymentDetailsLayout.setVisibility(View.VISIBLE);
            }
        });

        saveData();
        return rootView;
    }
    public void saveData(){
       productNextBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               buyerDetailsLayout.setVisibility(View.GONE);
               productDetailsLayout.setVisibility(View.VISIBLE);
//               String a="paid";
//               boolean inserted=dairyDBHelper.insertData(nameTxt.getText().toString(),surNameTxt.getText().toString(),
//                       fathersNameTxt.getText().toString(),addressTxt.getText().toString(),phoneTxt.getText().toString(),"paid");
//               if (inserted==true){
//                   Toast.makeText(getContext(),"User Saved",Toast.LENGTH_LONG).show();
//               }else Toast.makeText(getContext(),"Data not Saved",Toast.LENGTH_LONG).show();
           }
       });
    }

}
