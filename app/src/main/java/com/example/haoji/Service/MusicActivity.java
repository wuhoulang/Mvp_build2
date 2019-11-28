package com.example.haoji.Service;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.example.lang.biao.R;


/**
 * Created by HAOJI on 2019/9/7.
 */

public class MusicActivity extends Activity {

    private MusicServices services;
    private Button exception;

    private ServiceConnection con =new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MusicServices.MyBinder binder= (MusicServices.MyBinder) iBinder;
             services = binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        exception=findViewById(R.id.exception);
        Intent intent =new Intent(this,MusicServices.class);
        bindService(intent,con,BIND_AUTO_CREATE);
        Handler mhandler =new Handler();
        mhandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                services.play();
            }
        },2000);
//        exception.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                services.play();
//            }
//        });

    }

}
