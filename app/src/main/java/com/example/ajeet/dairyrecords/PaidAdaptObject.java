package com.example.ajeet.dairyrecords;

public class PaidAdaptObject {
    private String serialNo,name,contact;
    public PaidAdaptObject(String serialNo,String name,String contact){
        this.serialNo=serialNo;
        this.name=name;
        this.contact=contact;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
