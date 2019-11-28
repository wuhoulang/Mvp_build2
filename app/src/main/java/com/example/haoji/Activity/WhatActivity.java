package com.example.haoji.Activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
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

public class WhatActivity extends Activity {
    private Button bt_10;
    private RelativeLayout mRe;
    private Context context = WhatActivity.this;
    private int mRealWinSizeWidth;//手机屏幕真实宽度
    private int mRealWinSizeHeight;//手机屏幕真实高度
    private RelativeLayout id5_ll;
    private FloatButton floatButton;
    private Button add_v;
    private Button remove_v;
    private WindowManager windowManager;
    private WindowManager.LayoutParams windowParams;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main10);
        id5_ll = findViewById(R.id.id5_ll);
        add_v = findViewById(R.id.add_v);
        remove_v = findViewById(R.id.remove_v);
        windowManager = (WindowManager) getApplication().getSystemService(Context.WINDOW_SERVICE);
        windowParams = new WindowManager.LayoutParams();
        add_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addview();
                setLayoutParams(floatButton);
            }
        });
    }

    private void setLayoutParams(FloatButton floatButton) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) floatButton.getLayoutParams();
        layoutParams.width = 80;
        layoutParams.height = 80;
        floatButton.setAlpha(0.6f);
        floatButton.setLayoutParams(layoutParams);
    }

    @NonNull
    private FloatButton addview() {

        floatButton = new FloatButton(context, windowParams);
        getSize();
        floatButton.setScreenWidth(mRealWinSizeWidth);
        floatButton.setScreenHeight(mRealWinSizeHeight);
        floatButton.setBackgroundResource(R.drawable.roundone);
        floatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("LB", "---");
//                ObjectAnimator.ofFloat(add_v,"rotation",0f,360f).setDuration(3000).start();
//                float dis = add_v.getTranslationX();
//                // after(Animator anim)   将现有动画插入到传入的动画之后执行
//                // after(long delay)   将现有动画延迟指定毫秒后执行
//                // before(Animator anim)   将现有动画插入到传入的动画之前执行
//                // with(Animator anim)   将现有动画和传入的动画同时执行
//                ObjectAnimator move = ObjectAnimator.ofFloat(add_v, "translationX", dis, -500f, dis);
//                ObjectAnimator rotate = ObjectAnimator.ofFloat(add_v, "rotation", 0f, -45f);
//                ObjectAnimator fade = ObjectAnimator.ofFloat(add_v, "alpha", 1f, 0f, 1f);
//                AnimatorSet animatorSet = new AnimatorSet();
//                //顺序执行
//                //animatorSet.playSequentially(move,rotate,fade);
//                //执行顺序：move -> rotate -> fade
//                animatorSet.play(move).before(fade).after(rotate);
//                animatorSet.setDuration(5000);
//                animatorSet.start();
            }
        });
        id5_ll.addView(floatButton);
        return floatButton;
    }


    private void getSize() {
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
