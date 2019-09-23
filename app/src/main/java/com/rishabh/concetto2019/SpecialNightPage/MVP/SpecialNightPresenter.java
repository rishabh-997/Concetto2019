package com.rishabh.concetto2019.SpecialNightPage.MVP;

import com.rishabh.concetto2019.Utilities.Networking.ClientAPI;
import com.rishabh.concetto2019.Utilities.Networking.Utils;

public class SpecialNightPresenter implements SpecialNightContract.presenter
{
    SpecialNightContract.view mvpview;
    ClientAPI clientAPI = Utils.getClientAPI();

    public SpecialNightPresenter(SpecialNightContract.view mvpview) {
        this.mvpview = mvpview;
    }
}
