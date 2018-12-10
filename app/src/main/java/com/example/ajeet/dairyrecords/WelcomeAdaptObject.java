package com.example.ajeet.dairyrecords;


import android.content.Context;
import android.widget.Toast;

class WelcomeAdaptObject {

    private String name;
    private String serialNo;
    private String contactNo;
    private double due;
    Context context;

    public WelcomeAdaptObject(String name, String serialNo, String contactNo, double due, Context context) {
        this.name = name;
        this.contactNo = contactNo;
        this.serialNo = serialNo;
        this.due=due;
        this.context=context;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public double getDue() {
        return due;
    }
    public void setDue(double due) {
        this.due = due;
    }

    public Context getContext(){
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
