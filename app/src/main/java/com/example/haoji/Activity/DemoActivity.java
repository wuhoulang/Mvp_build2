package com.example.haoji.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.lang.biao.R;


/**
 * Created by HAOJI on 2019/9/9.
 */

public class DemoActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_activity);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
