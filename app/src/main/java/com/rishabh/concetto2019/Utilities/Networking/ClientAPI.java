package com.rishabh.concetto2019.Utilities.Networking;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Rishabh Agarwal on 23/09/2019
 */

public interface ClientAPI
{
    /**
        @POST("url/")
        @FormUrlEncoded
        Call<ResponseModel> function_name(
                //queries to send
                @Field("field") String field
        );
    */
}
