package com.rishabh.concetto2019.Contactus;

public class ContactusModel{

    String d_name;
    String d_telephone_number;
    String d_mail_id;
    int imgUrl;
    String d_post;

    public ContactusModel(String d_name,String d_post, String d_telephone_number, String d_mail_id, int imgUrl) {
        this.d_name = d_name;
        this.d_post=d_post;
        this.d_telephone_number = d_telephone_number;
        this.d_mail_id = d_mail_id;
        this.imgUrl =imgUrl ;
    }
    public String getD_name() {
         return d_name;
        }
    public String getD_post() { return d_post; }
    public String getD_telephone_number() {
        return d_telephone_number;
    }
    public String getD_mail_id() {
        return d_mail_id;
    }
    public int getImgUrl() { return imgUrl; }
}
