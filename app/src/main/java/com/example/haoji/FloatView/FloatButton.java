package com.example.haoji.FloatView;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.lang.biao.R;


/**
 * Created by HAOJI on 2019/8/19.
 */

@SuppressLint("AppCompatCustomView")
public class FloatButton extends ImageView {

    /**
     * View的宽高
     */
    private int width;
    private int height;

    /**
     * 触摸点相对于View的坐标
     */
    private float touchX;
    private float touchY;

    /**
     * x,y坐标的纠正值
     * 考虑到一些异性屏和非标准的显示区域
     */
    int xCorrection = 0;
    int yCorrection = 0;
    private boolean isleft;
    private boolean isRiht;

    public void setxCorrection(int xCorrection) {
        this.xCorrection = xCorrection;
    }

    public void setyCorrection(int yCorrection) {
        this.yCorrection = yCorrection;
    }

    /**
     * 屏幕的宽高，默认是1024 * 600的屏幕高宽
     * 在使用该类的时候最好设置该值为正确的显示区域宽高
     */
    private int screenWidth = 1024;
    private int screenHeight = 600;
    private WindowManager.LayoutParams mWindowParams;
    private RelativeLayout.LayoutParams layoutParams;

    private WindowManager.LayoutParams windowParams = new WindowManager.LayoutParams();

    private final static int FADE_OUT = 1;
    private final static int MOVE_TO_SIDE = 2;
    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case FADE_OUT:
                    ObjectAnimator.ofFloat(FloatButton.this, "alpha",
                            0.6f, ASSIST_TOUCH_VIEW_ALPHA_RATE)
                            .setDuration(ANIMATION_DURATION)
                            .start();
                    break;
                case MOVE_TO_SIDE:
                    Log.e("MOVE","MOVE_TO_SIDE");
                    if (isleft==true) {
                        setAlpha(0.3f);
                        setBackgroundResource(R.drawable.roundone_left);
//                        setImageResource(R.drawable.roundone_left);
                        setLayoutParams();
                    } else if (isRiht==true) {
                        setAlpha(0.3f);
                        setX(screenWidth-(width/2));
                        setBackgroundResource(R.drawable.roundone_rigt);
//                        setImageResource(R.drawable.roundone_rigt);
                        setLayoutParams();
                    }
                    isleft=false;
                    isRiht=false;
                    break;
                default:
                    break;
            }
            return false;
        }
    }) ;


    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public FloatButton(Context context,WindowManager.LayoutParams windowParams) {
        super(context);
        mWindowParams=windowParams;
//        windowManager();
    }

    private void windowManager() {
        windowParams.type = WindowManager.LayoutParams.LAST_APPLICATION_WINDOW;
        windowParams.format = PixelFormat.RGBA_8888; // 设置图片格式，效果为背景透明
        windowParams.flags = windowParams.flags|
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
        windowParams.gravity = Gravity.TOP;
        windowParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        windowParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
    }

    public FloatButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        width = getWidth();
        height = getHeight();
        Log.e("WH","-----"+width);
        Log.e("WH","-----"+height);
    }

    private float mTouchStartX;
    private float mTouchStartY;
    private static final float TOLERANCE_RANGE = 18.0f;
    private static final float ASSIST_TOUCH_VIEW_ALPHA_RATE = 0.3f;
    private static final int ANIMATION_DURATION = 110;
    private Boolean enterFourty=true;

    private void setLayoutParams() {
        layoutParams= (RelativeLayout.LayoutParams) this.getLayoutParams();
        layoutParams.width = 40;
        layoutParams.height = 80;
        this.setAlpha(0.6f);
        this.setLayoutParams(layoutParams);
        enterFourty=false;
    }

    private void setLayoutParams2() {
        layoutParams= (RelativeLayout.LayoutParams) this.getLayoutParams();
        layoutParams.width = 80;
        layoutParams.height = 80;
        this.setAlpha(0.6f);
        this.setLayoutParams(layoutParams);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                isleft=false;isRiht=false;
                mHandler.removeMessages(FADE_OUT);
                mHandler.removeMessages(MOVE_TO_SIDE);
                if(enterFourty==false){
                    setLayoutParams2();
                }else if(enterFourty=true) {
                    setLayoutParams2();
                }
                setAlpha(0.6f);
                clearAnimation();
                //触摸点相对按钮的坐标
                touchX = event.getX();
                touchY = event.getY();
                //触摸点相对屏幕坐标（x，y）
                mTouchStartX = event.getRawX();
                mTouchStartY = event.getRawY();
                setBackgroundResource(R.drawable.roundone);
                return true;
            case MotionEvent.ACTION_MOVE:
                mHandler.removeMessages(MOVE_TO_SIDE);
                setAlpha(0.5f);
                int xMove= Math.abs((int) (event.getX()-touchX));
                int yMove= Math.abs((int) (event.getY()-touchY));
                if(xMove>5||yMove>5){
                    float nowY = event.getRawY() - touchY - yCorrection;
                    float nowX = event.getRawX() - touchX - xCorrection;
                    nowX = nowX < 0 ? 0 : (nowX + width > screenWidth) ? (screenWidth - width) : nowX;
                    nowY = nowY < 0 ? 0 : (nowY + height > screenHeight) ? (screenHeight - height) : nowY;
                    this.setY(nowY);
                    this.setX(nowX);
                    //重绘
//                windowManager();
                    invalidate();
                    this.bringToFront();
                }

//                if(nowX==0){
//                    Log.e("GH","nox=0:"+"--------");
//                    this.setY(nowY);
//                    this.setX(width/2);
//                    invalidate();
//                }
                return true;
            case MotionEvent.ACTION_UP:
                //这里做动画贴边效果
                setAlpha(0.6f);
                float centerX = getX() + width / 2f;
                int halfOfScreenWidth = screenWidth / 2;
                if (centerX > halfOfScreenWidth) {
                     isRiht=true;
                    ObjectAnimator.ofFloat(this, "translationX",
                            getX(), screenWidth - width)
                            .setDuration(500)
                            .start();
                    mHandler.removeMessages(MOVE_TO_SIDE);
                    mHandler.sendEmptyMessageDelayed(MOVE_TO_SIDE,3000);
                } else {
                     isleft=true;
                    ObjectAnimator.ofFloat(this, "translationX",
                            getX(), 0)
                            .setDuration(500)
                            .start();
                    mHandler.removeMessages(MOVE_TO_SIDE);
                    mHandler.sendEmptyMessageDelayed(MOVE_TO_SIDE,3000);
                }
                mHandler.sendEmptyMessageDelayed(FADE_OUT, 2000);
                touchX = 0;
                touchY = 0;
                setBackgroundResource(R.drawable.roundone);
                float mTouchEndX = event.getRawX();
                float mTouchEndY = event.getRawY();
                if (Math.abs(mTouchEndX - mTouchStartX) < TOLERANCE_RANGE
                        && Math.abs(mTouchEndY - mTouchStartY) < TOLERANCE_RANGE) {
                    performClick();
                    return true;
                }
                return true;
            default:
                return super.onTouchEvent(event);
        }
    }
}

