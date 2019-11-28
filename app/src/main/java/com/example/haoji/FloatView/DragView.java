package com.example.haoji.FloatView;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.haoji.utils.ScreenUtil;

import static android.view.FrameMetrics.ANIMATION_DURATION;

/**
 * Created by HAOJI on 2019/8/16.
 */

@SuppressLint("AppCompatCustomView")
public class DragView extends ImageView{

    private int width;
    private int height;
    private int screenWidth;
    private int screenHeight;
    private int KscreenWidth;
    private int KscreenHeight;
    private Context context;

    //是否拖动
    private boolean isDrag=false;

    public boolean isDrag() {
        return isDrag;
    }


    public DragView(Context context) {
        super(context);
        this.context=context;
    }
    public DragView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width=getMeasuredWidth();
        height=getMeasuredHeight();
        screenWidth= ScreenUtil.getScreenWidth(context);
        screenHeight=ScreenUtil.getScreenHeight(context)-getStatusBarHeight();

    }
    public int getStatusBarHeight(){
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        return getResources().getDimensionPixelSize(resourceId);
    }


    private float downX;
    private float downY;
    private float mTouchStartX;
    private float mTouchStartY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        if (this.isEnabled()) {
            KscreenWidth= (int) event.getRawX();
            KscreenHeight= (int) event.getRawY();
            Log.e("Kscreen","KscreenWidth:"+KscreenWidth);
            Log.e("Kscreen","KscreenHeight:"+KscreenHeight);
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    isDrag=false;
                    downX = event.getX();
                    downY = event.getY();
                    mTouchStartX = event.getRawX();
                    mTouchStartY = event.getRawY();
                    Log.e("kid","ACTION_MOVE");
                    break;
                case MotionEvent.ACTION_MOVE:
                    setAlpha(0.5f);
                    Log.e("kid","ACTION_MOVE");
                    final float xDistance = event.getX() - downX;
                    final float yDistance = event.getY() - downY;
                    int l,r,t,b;
                    //当水平或者垂直滑动距离大于10,才算拖动事件
                    if (Math.abs(xDistance) >10 ||Math.abs(yDistance)>10) {
                        Log.e("kid","Drag");
                        isDrag=true;
                        l = (int) (getLeft() + xDistance);
                        r = l+width;
                        t = (int) (getTop() + yDistance);
                        b = t+height;
                        //不划出边界判断,此处应按照项目实际情况,因为本项目需求移动的位置是手机全屏,
                        // 所以才能这么写,如果是固定区域,要得到父控件的宽高位置后再做处理
                        if(l<0){
                            l=0;
                            r=l+width;
                        }else if(r>screenWidth){
                            r=screenWidth;
                            l=r-width;
                        }
                        if(t<0){
                            t=0;
                            b=t+height;
                        }else if(b>screenHeight){
                            b=screenHeight;
                            t=b-height;
                        }

                        this.layout(l, t, r, b);

                    }
                    break;
                case MotionEvent.ACTION_UP:
                    setAlpha(1.0f);
                    Log.e("Kscreen","screenWidth:"+screenWidth/2);
                    if(KscreenWidth<screenWidth/2){
                        ObjectAnimator.ofFloat(this,"translationX",KscreenWidth-downX,0).setDuration(500).start();
                    }
//                    setPressed(false);
                    break;
                case MotionEvent.ACTION_CANCEL:
                    setPressed(false);
                    break;
            }
            return true;
        }
        return false;
    }


}
