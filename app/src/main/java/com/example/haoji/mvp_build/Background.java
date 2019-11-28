package com.example.haoji.mvp_build;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.lang.biao.R;

/**
 * Created by HAOJI on 2019/7/26.
 */

public class Background extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        IntentFilter intentFilter =new IntentFilter();
        intentFilter.addAction("Intent.ACTION_HEADSET_PLUG");
    }


}
