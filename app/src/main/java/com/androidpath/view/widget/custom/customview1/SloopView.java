package com.androidpath.view.widget.custom.customview1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * http://www.gcssloop.com/customview/Canvas_BasicGraphics
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/17 16:37 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class SloopView extends View {
    private final String TAG = "SloopView";
    private Paint mPaint;

    public SloopView(Context context) {
        this(context, null);
        Log.d(TAG, "SloopView:1 ");
        initPaint();
    }

    public SloopView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        Log.d(TAG, "SloopView:2");
    }

    public SloopView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.d(TAG, "SloopView:3 ");
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
//        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(10f);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        Log.d(TAG, "onMeasure: ");
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.d(TAG, "onSizeChanged: ");
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.d(TAG, "onLayout: ");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(TAG, "onDraw: ");
//        canvas.drawColor(Color.BLUE);
//        canvas.drawPoint(200, 200, mPaint);//在坐标(200,200)位置绘制一个点
//        canvas.drawPoints(new float[]{500, 500, 500, 600, 500, 700}, mPaint);//绘制一组点，坐标位置由float数组指定
//        canvas.drawLine(300, 300, 500, 600, mPaint);    // 在坐标(300,300)(500,600)之间绘制一条直线
//        canvas.drawLines(new float[]{               // 绘制一组线 每四数字(两个点的坐标)确定一条线
//                100, 200, 200, 200,
//                100, 300, 200, 300
//        }, mPaint);
        // 矩形第一种
//        canvas.drawRect(100, 100, 800, 400, mPaint);
// 第二种
//        Rect rect = new Rect(100, 100, 800, 400);
//        canvas.drawRect(rect, mPaint);
// 第三种
//        RectF rectF = new RectF(100, 100, 800, 400);
//        canvas.drawRect(rectF, mPaint);

        // 圆角矩形第一种
//        RectF rectFx = new RectF(100, 100, 800, 400);
//        canvas.drawRoundRect(rectFx, 30, 30, mPaint);
// 第二种
//        canvas.drawRoundRect(100,100,800,400,30,30,mPaint); need api 21

        // 椭圆第一种
//        RectF rectFY = new RectF(100, 100, 800, 400);
//        canvas.drawOval(rectFY, mPaint);
// 第二种
        //  canvas.drawOval(100, 100, 800, 400, mPaint); //need api 21
        //圆
//        canvas.drawCircle(500, 500, 400, mPaint);  // 绘制一个圆心坐标在(500,500)，半径为400 的圆。
//        RectF rectF = new RectF(100, 100, 800, 400);
//        // 绘制背景矩形
//        mPaint.setColor(Color.GRAY);
//        canvas.drawRect(rectF, mPaint);
//        mPaint.setColor(Color.BLUE);
//        // 圆弧第一种
//        RectF rectFY = new RectF(100, 100, 800, 400);
//        canvas.drawArc(rectF, 0, 90, true, mPaint);

        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(40);     //为了实验效果明显，特地设置描边宽度非常大

// 描边
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(200,200,100,paint);

// 填充
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(200,500,100,paint);

// 描边加填充
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawCircle(200, 800, 100, paint);


    }

    //public SloopView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    //super(context, attrs, defStyleAttr, defStyleRes);
    //}
}
