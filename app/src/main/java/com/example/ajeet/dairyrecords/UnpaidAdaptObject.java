package com.example.ajeet.dairyrecords;

public class UnpaidAdaptObject {
    private String serialNo;
    private String name;
    private String contactNo;

    public UnpaidAdaptObject(String serialNo, String name, String contactNo){
        this.name = name;
        this.contactNo = contactNo;
        this.serialNo = serialNo;

    }
    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }


}
