package com.androidpath.view.dragview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by zgjxf on 2018/2/16.
 */

public class DragViews extends View {
    public DragViews(Context context) {
        super(context);
    }

    public DragViews(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        int a=0;
    }

    public DragViews(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public DragViews(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public float currentX=40;
    public float currentY=50;

    Paint paint=new Paint();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.RED);
        canvas.drawCircle(currentX,currentY,15,paint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        currentX =event.getX();
        currentX =event.getY();
        invalidate();
        return true;
    }
}
