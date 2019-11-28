package com.example.haoji.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.lang.biao.R;


/**
 * Created by HAOJI on 2019/8/13.
 */

public class DelayActivity extends Activity {
    private Handler mhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Log.e("main","-1-");
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       new Thread(new Runnable() {
           @Override
           public void run() {
             Message msg =new Message();
             msg.what=1;
             mhandler.sendMessage(msg);
           }
       }).start();
    }
}
