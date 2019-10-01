package com.rishabh.concetto2019.Profile.Model;

import com.rishabh.concetto2019.Authentication.LogInPage.Model.LoginResult;

import java.util.List;

public class ProfileResponse
{
    boolean success;
    String error;
    List<ProfileModel> profile;

    public ProfileResponse(boolean success, String error, List<ProfileModel> profile) {
        this.success = success;
        this.error = error;
        this.profile = profile;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getError() {
        return error;
    }

    public List<ProfileModel> getProfile() {
        return profile;
    }
}
