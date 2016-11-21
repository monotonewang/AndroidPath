package com.androidpath.view.widget.custom.canvasmesure;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import static android.content.ContentValues.TAG;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/21 14:48 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class PathMesureView extends View {

    private Paint mPaint;
    private int mHeight;
    private int mWidth;
    private String TAG="PathMesureView";

    public PathMesureView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public PathMesureView(Context context) {
        this(context, null);
    }

    public PathMesureView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    private void initView() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setTextSize(18);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mHeight = h;
        mWidth = w;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(mWidth / 2, mHeight / 2);
        Path path = new Path();
        path.lineTo(0, 200);
        path.lineTo(200, 200);
        path.lineTo(200, 0);
        PathMeasure pathMeasure=new PathMeasure(path,false);
        PathMeasure pathMeasure2=new PathMeasure(path,true);
        float length = pathMeasure.getLength();
        float length2 = pathMeasure2.getLength();
        Log.e(TAG, "onDraw: "+length );
        Log.e(TAG, "onDraw: "+length2 );
        canvas.drawPath(path, mPaint);
    }
}
