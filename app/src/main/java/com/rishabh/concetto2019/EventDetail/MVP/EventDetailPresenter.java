package com.rishabh.concetto2019.EventDetail.MVP;


import com.rishabh.concetto2019.Utilities.Networking.ClientAPI;
import com.rishabh.concetto2019.Utilities.Networking.Utils;

public class EventDetailPresenter implements EventDetailContract.presenter
{
    EventDetailContract.view mvpview;
    ClientAPI clientAPI = Utils.getClientAPI();

    public EventDetailPresenter(EventDetailContract.view mvpview) {
        this.mvpview = mvpview;
    }
}
