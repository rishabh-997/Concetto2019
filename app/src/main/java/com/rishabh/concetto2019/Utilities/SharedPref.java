package com.rishabh.concetto2019.Utilities;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Rishabh Agarwal on 23/09/2019
 */

public class SharedPref
{
    private static final String PREF_NAME = "welcome";
    private static final String KEY_ACCESS_TOKEN = "access_token";
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

    public String getAccessToken() {
        return pref.getString(KEY_ACCESS_TOKEN, "");
    }
    public void setAccessToken(String accessToken) {
        editor.putString(KEY_ACCESS_TOKEN, accessToken);
        editor.commit();
    }

}
