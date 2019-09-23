package com.rishabh.concetto2019.WorkshopPage.MVP;

import com.rishabh.concetto2019.Utilities.Networking.ClientAPI;
import com.rishabh.concetto2019.Utilities.Networking.Utils;

public class WorkshopPresenter implements WorkshopContract.presenter
{
    WorkshopContract.view mvpview;
    ClientAPI clientAPI = Utils.getClientAPI();

    public WorkshopPresenter(WorkshopContract.view mvpview) {
        this.mvpview = mvpview;
    }
}
