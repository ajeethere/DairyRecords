package com.example.ajeet.dairyrecords;


import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ajeet.dairyrecords.R;

import java.util.Calendar;
import java.util.Date;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewBuyerFragment extends Fragment {
    EditText nameTxt,surNameTxt,fathersNameTxt,addressTxt,phoneTxt,productPrice,productQuantity,dueAmountTxt;
    Button productNextBtn,paymentNextBtn,orderDoneBtn;
    RadioButton cashRadioBtn,dueRadioBtn;
    LinearLayout buyerDetailsLayout,productDetailsLayout,paymentDetailsLayout,dueLayout;
    TextView selectDateText,totalAmountTxt;
    private DatePickerDialog.OnDateSetListener dateSetListener;
    View rootView=null;
    DairyDBHelper dairyDBHelper;
    Spinner spinnerProductName;
    public NewBuyerFragment() {
        // Required empty public constructor
    }


    @SuppressLint("WrongViewCast")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.rootView= inflater.inflate(R.layout.fragment_new_buyer, container, false);
        dairyDBHelper=new DairyDBHelper(getActivity());
        String[] arraySpinner = new String[] {
                "Select Product", "Milk", "Meva", "Mishri Meva", "Ghee" ,"Burfi" , "Rasgulla" , "Rasbhari" , "Gulabjamun"
        };
        spinnerProductName = (Spinner) rootView.findViewById(R.id.product_details_select_product_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinnerProductName.setAdapter(adapter);
        productPrice=(EditText)rootView.findViewById(R.id.product_details_price_txt);
        productQuantity=(EditText)rootView.findViewById(R.id.product_details_quantity_txt);
        dueAmountTxt=(EditText)rootView.findViewById(R.id.enter_due_amount);
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
        totalAmountTxt=(TextView)rootView.findViewById(R.id.total_amount_txt);
        cashRadioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dueLayout.setVisibility(View.GONE);
            }
        });
        dueRadioBtn=(RadioButton)rootView.findViewById(R.id.due_radio_btn);
        dueRadioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dueLayout.setVisibility(View.VISIBLE);
            }
        });
        paymentNextBtn=(Button)rootView.findViewById(R.id.payment_next_btn);
        paymentNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productDetailsLayout.setVisibility(View.GONE);
                paymentDetailsLayout.setVisibility(View.VISIBLE);
                double total=Double.parseDouble(productPrice.getText().toString())*Double.parseDouble(productQuantity.getText().toString());
                totalAmountTxt.setText(Double.toString(total));

            }
        });
        selectDateText=(TextView)rootView.findViewById(R.id.select_commotment_date_txt);
        selectDateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal=Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int date=cal.get(Calendar.DATE);
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,dateSetListener,year,month,date);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();

            }
        });
        dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=month+1;
                Log.d(TAG,"onDateSet: date: "+dayOfMonth+"/"+month+"/"+year);
                String date=dayOfMonth+"/"+month+"/"+year;
                selectDateText.setText(date);
            }
        };

        saveData();
        return rootView;
    }
    public void saveData(){
       productNextBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               buyerDetailsLayout.setVisibility(View.GONE);
               productDetailsLayout.setVisibility(View.VISIBLE);

           }
       });

       orderDoneBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               String date1 = null;
               double dueAmount = 0;

               if (cashRadioBtn.isChecked()){
                   Calendar cal=Calendar.getInstance();
                   int year=cal.get(Calendar.YEAR);
                   int month=cal.get(Calendar.MONTH);
                   int date=cal.get(Calendar.DATE);
                   date1=date+"/"+month+"/"+year;
                   dueAmount=0.0;
               }
               if (dueRadioBtn.isChecked()){
                   dueAmount=Double.parseDouble(dueAmountTxt.getText().toString());
                   date1=selectDateText.getText().toString();
               }

               boolean inserted=dairyDBHelper.insertData(nameTxt.getText().toString(),surNameTxt.getText().toString(),
                       fathersNameTxt.getText().toString(),addressTxt.getText().toString(),phoneTxt.getText().toString());
               boolean inserted1=dairyDBHelper.insertProductData(nameTxt.getText().toString()+" "
                       +surNameTxt.getText().toString(),spinnerProductName.getSelectedItem().toString(),
                       Double.parseDouble(productPrice.getText().toString()),Double.parseDouble(productQuantity.getText().toString()),
                       Double.parseDouble(productPrice.getText().toString())*Double.parseDouble(productQuantity.getText().toString()),
                       dueAmount,
                       date1);
               if (inserted==true){
                   Toast.makeText(getContext(),"User Saved",Toast.LENGTH_LONG).show();
               }else Toast.makeText(getContext(),"User Data Not Saved",Toast.LENGTH_LONG).show();
               if (inserted1==true){
                   Toast.makeText(getContext(),"Order saved",Toast.LENGTH_LONG).show();
               }else Toast.makeText(getContext(),"Order Data Not Saved",Toast.LENGTH_LONG).show();
           }
       });
    }

}
