package com.rishabh.concetto2019.SignupPage.MVP;

import com.rishabh.concetto2019.EventPage.MVP.EventContract;
import com.rishabh.concetto2019.LoginPage.MVP.LoginContract;
import com.rishabh.concetto2019.Utilities.Networking.ClientAPI;
import com.rishabh.concetto2019.Utilities.Networking.Utils;

import org.jetbrains.annotations.Contract;

public class SignupPresenter implements SignupContract.presenter
{
    SignupContract.view mvpview;
    ClientAPI clientAPI = Utils.getClientAPI();

    public SignupPresenter(SignupContract.view mvpview) {
        this.mvpview = mvpview;
    }
}
