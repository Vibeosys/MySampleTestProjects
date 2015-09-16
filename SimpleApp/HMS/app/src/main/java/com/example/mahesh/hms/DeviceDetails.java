package com.example.mahesh.hms;

/**
 * Created by mahesh on 9/16/2015.
 */
public class DeviceDetails {
    private String _customer_id;
    private String _password;


    DeviceDetails(){

 }

    DeviceDetails(String customer_id,String password,String mac_Addr){
        this._customer_id=customer_id;
        this._password=password;

    }
    public String get_customer_id() {
        return _customer_id;
    }

    public void set_customer_id(String customer_id) {
        this._customer_id = customer_id;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String password) {
        this._password = password;
    }




}
