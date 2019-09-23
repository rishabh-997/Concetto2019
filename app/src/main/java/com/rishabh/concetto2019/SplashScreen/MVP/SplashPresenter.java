package com.rishabh.concetto2019.SplashScreen.MVP;

import com.rishabh.concetto2019.Utilities.Networking.ClientAPI;
import com.rishabh.concetto2019.Utilities.Networking.Utils;

public class SplashPresenter implements SplashContract.presenter
{
    SplashContract.view mvpview;
    ClientAPI clientAPI = Utils.getClientAPI();

    public SplashPresenter(SplashContract.view mvpview) {
        this.mvpview = mvpview;
    }
}
