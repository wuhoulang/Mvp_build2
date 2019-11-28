package com.example.haoji.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.haoji.Popupwindow.ButtonPopupwindow;
import com.example.lang.biao.R;

/**
 * Created by HAOJI on 2019/8/12.
 */

public class PopupWindow extends Activity {
    private RelativeLayout rl_id;
    private Button bt01;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popupwindow);
        rl_id=findViewById(R.id.rl_id);
        bt01=findViewById(R.id.bt01);
        bt01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPopupwindow();
            }
        });
    }

    private void setPopupwindow() {
        ButtonPopupwindow buttonPopupwindow =new ButtonPopupwindow(this);
        buttonPopupwindow.showAtLocation(rl_id,Gravity.BOTTOM,0,-30);
    }
}



