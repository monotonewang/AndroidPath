package com.androidpath.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by ubuntu on 17-9-14.
 */

public class MyTextView extends View {

    private String TAG = getClass().getSimpleName();

    public MyTextView(Context context) {
        super(context);
        init();
    }


    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        if (modeWidth == MeasureSpec.AT_MOST && modeHeight == MeasureSpec.AT_MOST) {
            setMeasuredDimension(300, 650);
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e(TAG, "onDraw: ");
        canvas.drawRGB(0, 0, 0);
        String text = "我是小傅";
        float v = mPaint.measureText(text);
        float v1 = getWidth() - v;

        Paint.FontMetrics fontMetrics = mPaint.getFontMetrics();
        float ascent = fontMetrics.ascent;
        float bottom = fontMetrics.bottom;
        float top = fontMetrics.top;
        float leading = fontMetrics.leading;
        float descent = fontMetrics.descent;

        Log.e(TAG, "onDraw: ascent=" + ascent + "leading=" + leading + "top=" + top + "bottom=" + bottom + "descent=" + descent);

        // 计算Baseline绘制的Y坐标 ，计算方式：画布高度的一半 - 文字总高度的一半
        float v2 = getHeight() / 2 - (ascent/2+descent/2);
        Log.e(TAG, "onDraw: "+v2 );
        canvas.drawText(text, v1 / 2, v2, mPaint);
    }

    Paint mPaint;

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.parseColor("#FF4081"));
        mPaint.setTextSize(70f);
    }

}
