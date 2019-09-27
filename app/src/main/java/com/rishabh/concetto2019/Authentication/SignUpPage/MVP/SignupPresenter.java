package com.rishabh.concetto2019.Authentication.SignUpPage.MVP;

import com.rishabh.concetto2019.Authentication.SignUpPage.Model.SignUpResponse;
import com.rishabh.concetto2019.Utilities.Networking.ClientAPI;
import com.rishabh.concetto2019.Utilities.Networking.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupPresenter implements SignupContract.presenter
{
    SignupContract.view mvpview;
    ClientAPI clientAPI = Utils.getClientAPI();

    public SignupPresenter(SignupContract.view mvpview) {
        this.mvpview = mvpview;
    }


    @Override
    public void doSignUp(String email, String name, String password, String phone, String college) {

        clientAPI.signup(email, name, password, phone, college).enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                if(response.isSuccessful())
                {
                    if(response.body().getResults().equals("Account created. Please activate your account from the email sent"))
                    {
                        mvpview.signedin();
                    }
                    else
                    {
                        mvpview.showToast(response.body().getResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {
                mvpview.showToast(t.getMessage());
            }
        });
    }
}
