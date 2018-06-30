package com.example.designmodal.fcmwithappserver;

/**
 * Created by compware on 6/29/2018.
 */

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MySingleton {
    private static  MySingleton mInstance;
    private static Context mctx;
    private RequestQueue requestQueue;

    private  MySingleton (Context context){
        mctx = context;
        requestQueue = getRequestQueue();
    }

    private RequestQueue getRequestQueue(){
        if (requestQueue==null){
            requestQueue = Volley.newRequestQueue(mctx.getApplicationContext());

        }
        return requestQueue;
    }
    public static  synchronized MySingleton getmInstance(Context context){
        if(mInstance==null) {
            mInstance = new MySingleton(context);
        }
        return mInstance;
    }
    public <T>  void  addToRequestQueue(com.android.volley.Request<T>request){
        getRequestQueue().add(request);
    }


}
