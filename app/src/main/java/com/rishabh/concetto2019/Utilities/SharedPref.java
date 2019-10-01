package com.rishabh.concetto2019.Utilities;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Rishabh Agarwal on 23/09/2019
 */

public class SharedPref
{
    private static final String PREF_NAME = "welcome";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_COLLEGE = "college";
    private static final String KEY_SETUP = "setup";

    int Private_mode=0;

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;

    public SharedPref(Context context)
    {
        this.context=context;
        pref=context.getSharedPreferences(PREF_NAME,Private_mode);
        editor=pref.edit();
    }


    public String getEmail() {
        return pref.getString(KEY_EMAIL, "");
    }
    public void setEmail(String email) {
        editor.putString(KEY_EMAIL, email);
        editor.commit();
    }


    public String getName() {
        return pref.getString(KEY_NAME, "");
    }
    public void setName(String name) {
        editor.putString(KEY_NAME, name);
        editor.commit();
    }


    public String getCollege() {
        return pref.getString(KEY_COLLEGE, "");
    }
    public void setCollege(String college) {
        editor.putString(KEY_COLLEGE, college);
        editor.commit();
    }

    public String getPhone() {
        return pref.getString(KEY_PHONE, "");
    }
    public void setPhone(String phone) {
        editor.putString(KEY_PHONE, phone);
        editor.commit();
    }

    public String getSetup() {
        return pref.getString(KEY_SETUP, "");
    }
    public void setSetup(String setup) {
        editor.putString(KEY_SETUP, setup);
        editor.commit();
    }



}
