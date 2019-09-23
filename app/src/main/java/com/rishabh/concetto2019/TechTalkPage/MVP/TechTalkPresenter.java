package com.rishabh.concetto2019.TechTalkPage.MVP;

import com.rishabh.concetto2019.Utilities.Networking.ClientAPI;
import com.rishabh.concetto2019.Utilities.Networking.Utils;

public class TechTalkPresenter implements TechTalkContract.presenter
{
    TechTalkContract.view mvpview;
    ClientAPI clientAPI = Utils.getClientAPI();

    public TechTalkPresenter(TechTalkContract.view mvpview) {
        this.mvpview = mvpview;
    }
}
