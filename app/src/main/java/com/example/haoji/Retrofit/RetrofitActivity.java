package com.example.haoji.Retrofit;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lang.biao.R;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HAOJI on 2019/11/21.
 */

public class RetrofitActivity extends Activity implements View.OnClickListener {
    private TextView tv_success,tv_fail;
    private Button bt_click;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_layout);
        tv_success = findViewById(R.id.tv_success);
        tv_fail = findViewById(R.id.tv_fail);
        bt_click = findViewById(R.id.bt_click);
        bt_click.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.bt_click){
            getRetrofit();
        }
    }

    public void getRetrofit() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10,TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor())
                .retryOnConnectionFailure(true)
                .build();

        Retrofit retrofit =new Retrofit.Builder()
                .client(client)
                .baseUrl("http://120.78.186.81/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiUrl api = retrofit.create(ApiUrl.class);
        Call<NewBean> demo =api.getRetrofit();
        demo.enqueue(new Callback<NewBean>() {
            @Override
            public void onResponse(Call<NewBean> call, Response<NewBean> response) {
                Log.e("DJ", "请求成功信息: "+response.body().toString());
                tv_success.setText(response.body().toString());
                NewBean newBean =new NewBean();
                int res_code = newBean.getRes_code();
                Log.e("DJ", "res_code: "+res_code);
            }

            @Override
            public void onFailure(Call<NewBean> call, Throwable t) {
                Log.e("DJ", "请求失败信息: " +t.getMessage());
                tv_fail.setText(t.getMessage());
            }
        });

    }

}
