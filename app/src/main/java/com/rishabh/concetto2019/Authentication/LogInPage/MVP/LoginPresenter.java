package com.rishabh.concetto2019.Authentication.LogInPage.MVP;

import com.rishabh.concetto2019.Authentication.LogInPage.Model.LogInResponse;
import com.rishabh.concetto2019.Utilities.Networking.ClientAPI;
import com.rishabh.concetto2019.Utilities.Networking.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements LoginContract.presenter
{
    LoginContract.view mvpview;
    ClientAPI clientAPI = Utils.getClientAPI();



    public LoginPresenter(LoginContract.view mvpview) {
        this.mvpview = mvpview;
    }

    @Override
    public void doLogin(String email, String password) {
        clientAPI.login(email, password).enqueue(new Callback<LogInResponse>() {
            @Override
            public void onResponse(Call<LogInResponse> call, Response<LogInResponse> response) {
                if(response.isSuccessful())
                {
                    if(response.body().isSuccess())
                    {
                        mvpview.login(response.body());
                    }
                    else
                    {
                        mvpview.showToast(response.body().getError());
                    }
                }
                else
                {
                    mvpview.showToast(response.message());
                }
            }

            @Override
            public void onFailure(Call<LogInResponse> call, Throwable t) {

                mvpview.showToast(t.getMessage());
            }
        });
    }
}
