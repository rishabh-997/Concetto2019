package com.rishabh.concetto2019.Contactus;

public class ContactusModel{

    String d_name;
    String d_telephone_number;
    String d_mail_id;
    int id  ;

    public ContactusModel(String d_name, String d_telephone_number, String d_mail_id, int id) {
        this.d_name = d_name;
        this.d_telephone_number = d_telephone_number;
        this.d_mail_id = d_mail_id;
        this.id = id;
    }
    public String getD_name() {
         return d_name;
        }
    public String getD_telephone_number() {
        return d_telephone_number;
    }
    public String getD_mail_id() {
        return d_mail_id;
    }
    public int getId() {
        return id;
    }
}
