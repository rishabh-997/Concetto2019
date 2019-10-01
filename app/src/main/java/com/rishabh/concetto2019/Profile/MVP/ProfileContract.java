package com.rishabh.concetto2019.Profile.MVP;

import com.rishabh.concetto2019.Profile.Model.ProfileModel;

import java.util.List;

public class ProfileContract
{
    interface view
    {

        void showToast(String error);

        void showProfile(List<ProfileModel> profile);
    }
    interface presenter
    {

    }
}
