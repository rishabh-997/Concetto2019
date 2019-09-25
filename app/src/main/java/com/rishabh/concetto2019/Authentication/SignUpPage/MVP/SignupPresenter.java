package com.rishabh.concetto2019.Authentication.SignUpPage.MVP;

import com.rishabh.concetto2019.Utilities.Networking.ClientAPI;
import com.rishabh.concetto2019.Utilities.Networking.Utils;

public class SignupPresenter implements SignupContract.presenter
{
    SignupContract.view mvpview;
    ClientAPI clientAPI = Utils.getClientAPI();

    public SignupPresenter(SignupContract.view mvpview) {
        this.mvpview = mvpview;
    }
}
