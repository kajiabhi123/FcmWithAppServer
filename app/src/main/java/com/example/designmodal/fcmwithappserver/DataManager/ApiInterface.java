package com.example.designmodal.fcmwithappserver.DataManager;

import com.example.designmodal.fcmwithappserver.TokenModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by compware on 6/28/2018.
 */

public interface ApiInterface
{
    @POST("fcm_insert.php")
    @FormUrlEncoded
    public Call<List<TokenModel>> pushNotification(@Field("fcm_token") String token);

}
