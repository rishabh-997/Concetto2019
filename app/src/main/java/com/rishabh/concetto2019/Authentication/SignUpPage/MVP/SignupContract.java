package com.rishabh.concetto2019.Authentication.SignUpPage.MVP;

public class SignupContract
{
    interface  view{

        void showToast(String results);

        void signedin();
    }

    interface presenter{
        void doSignUp(String email, String name, String password, String phone, String college);
    }
}
