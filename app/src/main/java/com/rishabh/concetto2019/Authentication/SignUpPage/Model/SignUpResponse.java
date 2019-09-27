package com.rishabh.concetto2019.Authentication.SignUpPage.Model;

public class SignUpResponse
{
    boolean success;
    String error;
    String results;

    public SignUpResponse(boolean success, String error, String results) {
        this.success = success;
        this.error = error;
        this.results = results;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getError() {
        return error;
    }

    public String getResults() {
        return results;
    }
}
