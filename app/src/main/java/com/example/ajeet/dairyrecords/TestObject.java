package com.example.ajeet.dairyrecords;

class TestObject {

    private String name;
    private String serialNo;
    private String contactNo;

    public TestObject(String name, String serialNo, String contactNo) {
        this.name = name;
        this.contactNo = contactNo;
        this.serialNo = serialNo;
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
}
