package com.example.ajeet.dairyrecords;


class WelcomeAdaptObject {

    private String name;
    private String serialNo;
    private String contactNo;
    private double due;

    public WelcomeAdaptObject(String name, String serialNo, String contactNo,double due) {
        this.name = name;
        this.contactNo = contactNo;
        this.serialNo = serialNo;
        this.due=due;
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

}
