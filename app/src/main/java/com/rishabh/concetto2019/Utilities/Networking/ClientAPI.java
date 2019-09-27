package com.rishabh.concetto2019.Utilities.Networking;

import com.rishabh.concetto2019.Authentication.LogInPage.Model.LogInResponse;
import com.rishabh.concetto2019.Authentication.SignUpPage.Model.SignUpResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Rishabh Agarwal on 23/09/2019
 */

public interface ClientAPI
{
    @POST("auth/signup/")
    @FormUrlEncoded
    Call<SignUpResponse> signup(
            @Field("email") String email,
            @Field("name") String name,
            @Field("password") String password,
            @Field("phone") String phone,
            @Field("college") String college
    );

    @POST("auth/login")
    @FormUrlEncoded
    Call<LogInResponse> login(
            @Field("email") String email,
            @Field("password") String password
    );
}
