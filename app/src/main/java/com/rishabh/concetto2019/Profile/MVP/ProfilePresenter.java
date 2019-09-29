package com.rishabh.concetto2019.Profile.MVP;

import com.rishabh.concetto2019.Profile.Model.ProfileResponse;
import com.rishabh.concetto2019.Utilities.Networking.ClientAPI;
import com.rishabh.concetto2019.Utilities.Networking.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfilePresenter implements ProfileContract.presenter
{
    ProfileContract.view mvpview;
    ClientAPI clientAPI = Utils.getClientAPI();

    public ProfilePresenter(ProfileContract.view mvpview) {
        this.mvpview = mvpview;
    }

    public void getProfile(String email, String access_token){
        clientAPI.getProfile(email, access_token).enqueue(new Callback<ProfileResponse>() {
            @Override
            public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                if(response.isSuccessful())
                {
                    if(response.body().isSuccess())
                    {
                        mvpview.showProfile(response.body().getProfile());
                    }
                    else
                    {
                        mvpview.showToast(response.body().getError());
                    }
                }
                else {
                    mvpview.showToast(response.message());
                }
            }

            @Override
            public void onFailure(Call<ProfileResponse> call, Throwable t) {
                mvpview.showToast(t.getMessage());
            }
        });

    }
}
