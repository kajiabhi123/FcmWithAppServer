package com.example.designmodal.fcmwithappserver;

/**
 * Created by compware on 6/28/2018.
 */

public class TokenModel
{
    private String fcm_token,status;

    public TokenModel(String fcm_token,String status)
    {
        this.status = status;
        this.fcm_token = fcm_token;
    }

    public String getFcm_token() {
        return fcm_token;
    }

    public void setFcm_token(String fcm_token) {
        this.fcm_token = fcm_token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
