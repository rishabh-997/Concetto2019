package com.rishabh.concetto2019.Authentication.LogInPage.Model;

public class LoginResult
{
    String email;
    String access_token;

    public LoginResult(String email, String access_token) {
        this.email = email;
        this.access_token = access_token;
    }

    public String getEmail() {
        return email;
    }

    public String getAccess_token() {
        return access_token;
    }
}
