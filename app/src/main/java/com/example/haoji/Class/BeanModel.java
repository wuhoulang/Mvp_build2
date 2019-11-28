package com.example.haoji.Class;

import android.content.Context;
import android.util.Log;

import com.example.haoji.Interface.ModelCallback;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by HAOJI on 2019/11/25.
 */

public class BeanModel {



    public static void getModel(Context context, String url,ModelCallback modelCallback) {

        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, okhttp3.Response response) throws IOException {
                if (response.isSuccessful()) {
                    String string = response.body().string();
                    Log.e("string", string);
                    modelCallback.onSuccess(string);

                }
            }
        });
    }

    public static void requestPostOKhttp(Context context, String url,String account ,String password,ModelCallback modelCallback){
        OkHttpClient client =new OkHttpClient();
        FormBody.Builder formBody =new FormBody.Builder();
        formBody.add("name",account);
        formBody.add("password",password);
        Request request =new Request.Builder().url(url).post(formBody.build()).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()) {//回调的方法执行在子线程。
                    String responseData = response.body().string();
                    modelCallback.onSuccess(responseData);
                    Log.e("responseData", "responseData:"+responseData);
                }
            }
        });
    }


}
