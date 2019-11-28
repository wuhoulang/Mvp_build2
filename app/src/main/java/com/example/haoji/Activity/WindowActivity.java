package com.example.haoji.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.haoji.FloatView.FloatButton;
import com.example.lang.biao.R;


/**
 * Created by HAOJI on 2019/8/14.
 */

public class WindowActivity extends Activity {
    private Button bt_10;
    private RelativeLayout mRe;
    private Context context=WindowActivity.this;
    private int mRealWinSizeWidth;//手机屏幕真实宽度
    private int mRealWinSizeHeight;//手机屏幕真实高度
    private  RelativeLayout id5_ll;
    private FloatButton floatButton;
    private  Button add_v;
    private  Button remove_v;
    private WindowManager windowManager;
    private WindowManager.LayoutParams windowParams;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main10);
        id5_ll=findViewById(R.id.id5_ll);
        add_v=findViewById(R.id.add_v);
        remove_v=findViewById(R.id.remove_v);
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
        intent.setData(Uri.parse("package:"+getPackageName()));
        startActivity(intent);
         windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        windowParams = new WindowManager.LayoutParams();

        add_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addview();
//                setLayoutParams(floatButton);
            }
        });



    }

    private void setLayoutParams(FloatButton floatButton) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) floatButton.getLayoutParams();
        layoutParams.width=80;
        layoutParams.height=80;
        floatButton.setAlpha(0.6f);
        floatButton.setLayoutParams(layoutParams);
    }

    @NonNull
    private FloatButton addview() {
        floatButton =new FloatButton(context,windowParams);
        floatButton.setScreenWidth(mRealWinSizeWidth);
        floatButton.setScreenHeight(mRealWinSizeHeight);
        floatButton.setBackgroundResource(R.drawable.roundone);
        windowManager.addView(floatButton,windowParams);
        return floatButton;
    }


    private void getSize(){
        Display display = windowManager.getDefaultDisplay();
        Point outPoint = new Point();
        if (Build.VERSION.SDK_INT >= 19) {
            // 可能有虚拟按键的情况
            display.getRealSize(outPoint);
        } else {
            // 不可能有虚拟按键
            display.getSize(outPoint);
        }
        mRealWinSizeHeight = outPoint.y;
        mRealWinSizeWidth = outPoint.x;
    }
}
