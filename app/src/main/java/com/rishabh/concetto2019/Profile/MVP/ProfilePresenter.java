package com.rishabh.concetto2019.Profile.MVP;

import com.rishabh.concetto2019.Profile.Model.ProfileResponse;
import com.rishabh.concetto2019.Utilities.Networking.ClientAPI;
import com.rishabh.concetto2019.Utilities.Networking.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfilePresenter implements ProfileContract.presenter
{
    ProfileContract.view mvpview;
    ClientAPI clientAPI = Utils.getClientAPI();

    public ProfilePresenter(ProfileContract.view mvpview) {
        this.mvpview = mvpview;
    }

}
