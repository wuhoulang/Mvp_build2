package com.example.haoji.MVC_Build;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.lang.biao.R;


/**
 * Created by HAOJI on 2019/9/10.
 */

public class ViewActivity extends Activity implements CallBack{
    private Context context =ViewActivity.this;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        WheatherModel.getWeather(context);
    }

    @Override
    public void success(Bean bean) {

    }

    @Override
    public void failed() {

    }
}
