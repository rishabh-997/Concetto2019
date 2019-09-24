package com.rishabh.concetto2019.LoginPage.MVP;

import com.rishabh.concetto2019.EventPage.MVP.EventContract;
import com.rishabh.concetto2019.LoginPage.MVP.LoginContract;
import com.rishabh.concetto2019.Utilities.Networking.ClientAPI;
import com.rishabh.concetto2019.Utilities.Networking.Utils;

import org.jetbrains.annotations.Contract;

public class LoginPresenter implements LoginContract.presenter
{
    LoginContract.view mvpview;
    ClientAPI clientAPI = Utils.getClientAPI();

    public LoginPresenter(LoginContract.view mvpview) {
        this.mvpview = mvpview;
    }
}
