package com.rishabh.concetto2019.HomePage.MVP;

import com.rishabh.concetto2019.Utilities.Networking.ClientAPI;
import com.rishabh.concetto2019.Utilities.Networking.Utils;


public class HomePagePresenter implements HomePageContract.presenter
{
    HomePageContract.view mvpview;
    ClientAPI clientAPI = Utils.getClientAPI();

    public HomePagePresenter(HomePageContract.view mvpview) {
        this.mvpview = mvpview;
    }
}
