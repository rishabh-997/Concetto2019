package com.rishabh.concetto2019.Profile.Model;

public class ProfileModel
{
    String email,phone,admin,college,name;

    public ProfileModel(String email, String phone, String admin, String college, String name) {
        this.email = email;
        this.phone = phone;
        this.admin = admin;
        this.college = college;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAdmin() {
        return admin;
    }

    public String getCollege() {
        return college;
    }

    public String getName() {
        return name;
    }
}
