package com.example.haoji.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.haoji.utils.AssetUtils;
import com.example.lang.biao.R;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HAOJI on 2019/8/13.
 */

public class GsonActivity extends Activity {
    private Context context=GsonActivity.this;
    private Button success;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        success=findViewById(R.id.success);
        success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String assetText = AssetUtils.getAssetText(context);
                Log.e("bbbbbb","assetText:"+assetText);
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        String name = getJson("name.json", context);
//                        AboutBean aboutBean = JsonToObject(name, AboutBean.class);
//                        Log.e("bbbbbb","--1-:"+aboutBean);
//                        Log.e("bbbbbb","--llll-:"+aboutBean);
//                        String url = aboutBean.getUrl();
//                        Log.e("bbbbbb","--llll-:"+url);
//                    }
//                }).start();
            }
        });
    }


    public  String getJson(String fileName, Context context){
        Log.e("bbbbbb","--rntre-:");
        //这个用来保存JSON格式字符串
        StringBuilder stringBuilder = new StringBuilder();
        AssetManager assetManager = context.getAssets();
        try{
            Log.e("bbbbbb","--rntre-2:");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    assetManager.open(fileName),"utf-8"));
            String line;
            while ((line=bufferedReader.readLine())!=null){
                stringBuilder.append(line);
                Log.e("bbbbbb","--rntre-3:");
                Log.e("bbbbbb","---"+stringBuilder.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();

    }

    public <T> T JsonToObject(String json, Class<T> type) {
        Gson gson =new Gson();
        return gson.fromJson(json, type);
    }

}
