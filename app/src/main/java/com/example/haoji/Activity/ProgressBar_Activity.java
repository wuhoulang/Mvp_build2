package com.example.haoji.Activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.example.haoji.Dialog.LoginDialog;
import com.example.lang.biao.R;

/**
 * Created by HAOJI on 2019/8/14.
 */

public class ProgressBar_Activity extends Activity {
    private Handler handler =new Handler();
    private Context context=ProgressBar_Activity.this;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.round);
       handler.postDelayed(new Runnable() {
           @Override
           public void run() {
               LoginDialog loginDialog =new LoginDialog(context);
               loginDialog.setCanceledOnTouchOutside(false);
               loginDialog.show();
           }
       },5000);
    }
}
