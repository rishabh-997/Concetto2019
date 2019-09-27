package com.rishabh.concetto2019.Authentication.LogInPage.MVP;

import com.rishabh.concetto2019.Authentication.LogInPage.Model.LogInResponse;

public class LoginContract
{
    interface  view{

        void login(LogInResponse body);

        void showToast(String error);
    }

    interface presenter{

        void doLogin(String email, String password);
    }
}
