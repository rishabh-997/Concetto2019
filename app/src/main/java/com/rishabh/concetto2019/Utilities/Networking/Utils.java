package com.rishabh.concetto2019.Utilities.Networking;

/**
 * Created by Rishabh Agarwal on 23/09/2019
 */

public class Utils
{
    private Utils(){}

    public static String BaseUrl="url";

    public static ClientAPI getClientAPI()
    {
        return RetrofitClient.getClient(BaseUrl).create(ClientAPI.class);
    }
}
