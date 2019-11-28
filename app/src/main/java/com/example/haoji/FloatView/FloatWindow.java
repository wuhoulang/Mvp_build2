package com.example.haoji.FloatView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class FloatWindow extends View {
    private Paint mPaint;
    private int lastX;
    private int lastY;

    public FloatWindow(Context context) {
        super(context);
    }

    public FloatWindow(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public FloatWindow(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint=new Paint();
        mPaint.setColor(Color.parseColor("#121212"));
        mPaint.setStyle(Paint.Style.FILL);

        mPaint.setColor(Color.parseColor("#91bef0"));
        canvas.drawCircle(0.5f*getWidth(),0.5f*getWidth(),0.5f*getWidth(),mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int[] location =new int[2];
        this.getLocationOnScreen(location);
//        this.getLocationInWindow(location);
        int x =location[0];
        int y =location[1];
        if(event.getX()<x||event.getX()>(x+this.getWidth())||event.getY()<y||event.getY()>(y+this.getHeight())){
            int xx = (int) event.getX();
            int yy = (int) event.getY();
            Log.e("event10","getX():"+xx+",getY():"+yy);
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    lastX = xx;
                    lastY = yy;
                    break;
                case MotionEvent.ACTION_MOVE:
                    int offX = xx - lastX;
                    int offY = yy - lastY;
                    Log.e("event2","offX:"+offX+",offY:"+offY);
                    offsetLeftAndRight(offX);
                    offsetTopAndBottom(offY);

                    break;
                case MotionEvent.ACTION_UP:

                    break;
            }
            return true;
        }else {
            return super.onTouchEvent(event);
        }
    }
}
