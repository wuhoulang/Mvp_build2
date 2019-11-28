package com.example.haoji.FloatView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by HAOJI on 2019/9/5.
 */

public class CircleView extends View{

    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK);
        float radius=50;
        float cx =50;
        float cy =50;
        Paint paint =new Paint();
        paint.setColor(Color.GRAY);
        canvas.drawCircle(cx,cy,radius,paint);
    }
}
