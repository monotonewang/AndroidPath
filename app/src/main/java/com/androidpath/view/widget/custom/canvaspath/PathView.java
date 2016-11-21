package com.androidpath.view.widget.custom.canvaspath;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/21 10:55 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class PathView extends View {

    private int mHeight;
    private int mWidth;
    private Paint mPaint;

    public PathView(Context context) {
        this(context, null);
    }

    public PathView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PathView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(10);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(mWidth / 2, mHeight / 2);
        Path path = new Path();
//        path.lineTo(200, 200);
//        path.setLastPoint(200,100);
//        path.moveTo(200,100);
//        path.lineTo(200, 0);
//        path.close();
        mPaint.setStyle(Paint.Style.STROKE);
//        path.addRect(-100,-100,200,200, Path.Direction.CW);
//        path.addCircle(0,100,100, Path.Direction.CW);
//        path.setLastPoint(-300,300);
        canvas.scale(1,-1);                         // <-- 注意 翻转y坐标轴

//        Path path = new Path();
        path.lineTo(100,100);

        RectF oval = new RectF(0,0,300,300);

        path.addArc(oval,0,270);
// path.arcTo(oval,0,270,true);
        canvas.drawPath(path, mPaint);
    }
}
