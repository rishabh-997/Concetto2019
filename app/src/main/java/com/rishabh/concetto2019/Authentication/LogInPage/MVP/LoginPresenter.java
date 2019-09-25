package com.rishabh.concetto2019.Authentication.LogInPage.MVP;

import com.rishabh.concetto2019.Utilities.Networking.ClientAPI;
import com.rishabh.concetto2019.Utilities.Networking.Utils;

public class LoginPresenter implements LoginContract.presenter
{
    LoginContract.view mvpview;
    ClientAPI clientAPI = Utils.getClientAPI();

    public LoginPresenter(LoginContract.view mvpview) {
        this.mvpview = mvpview;
    }
}
