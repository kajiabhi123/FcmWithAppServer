package com.example.designmodal.fcmwithappserver;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.designmodal.fcmwithappserver.DataManager.ApiClient;
import com.example.designmodal.fcmwithappserver.DataManager.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
{
    Button btn;
    //String app_server_url= "http://192.168.1.85/fcmTest/fcm_insert.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                PushNotification();
            }
        });
    }

    private void PushNotification()
    {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(getString(R.string.FCM_PREF), Context.MODE_PRIVATE);
        String token = sharedPreferences.getString(getString(R.string.FCM_TOKEN),"");
        ApiInterface service = ApiClient.getRetrofit().create(ApiInterface.class);
        Call<List<TokenModel>> call = service.pushNotification(token);
        //Toast.makeText(MainActivity.this, token, Toast.LENGTH_SHORT).show();

        call.enqueue(new Callback<List<TokenModel>>() {
            @Override
            public void onResponse(Call<List<TokenModel>> call, Response<List<TokenModel>> response)
            {
                //Log.d("onResponse", response.message());
                List<TokenModel> pushList = response.body();
                String token_no = response.body().get(0).getFcm_token();
                Toast.makeText(MainActivity.this,token_no, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<List<TokenModel>> call, Throwable t)
            {
                t.printStackTrace();
            }
        });
    }
}
