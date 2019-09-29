package com.rishabh.concetto2019.Profile.MVP;

import com.rishabh.concetto2019.Utilities.Networking.ClientAPI;
import com.rishabh.concetto2019.Utilities.Networking.Utils;

public class ProfilePresenter implements ProfileContract.presenter
{
    ProfileContract.view mvpview;
    ClientAPI clientAPI = Utils.getClientAPI();

    public ProfilePresenter(ProfileContract.view mvpview) {
        this.mvpview = mvpview;
    }
}
