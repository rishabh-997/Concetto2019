package com.rishabh.concetto2019.EventPage.MVP;

import com.rishabh.concetto2019.Utilities.Networking.ClientAPI;
import com.rishabh.concetto2019.Utilities.Networking.Utils;

public class EventPresenter implements EventContract.presenter
{
    EventContract.view mvpview;
    ClientAPI clientAPI = Utils.getClientAPI();

    public EventPresenter(EventContract.view mvpview) {
        this.mvpview = mvpview;
    }
}
