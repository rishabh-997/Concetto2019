package com.rishabh.concetto2019.Authentication.LogInPage.Model;

import java.util.List;

public class LogInResponse
{
    boolean success;
    String error;
    List<LoginResult> results;

    public LogInResponse(boolean success, String error, List<LoginResult> results) {
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

    public List<LoginResult> getResult() {
        return results;
    }
}
