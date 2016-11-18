package com.androidpath.view.widget.custom.customview1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/18 15:03 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class PieView extends View {
    private int mColors[] = {Color.BLUE, Color.CYAN, Color.RED, Color.GREEN, Color.YELLOW, Color.GRAY};
    private float mStartAngle = 0;
    private Paint mPaint;
    private String TAG = "PieView";
    private int mWidth;
    private int mHeight;
    private float mLeftAngle;
    private float mRightAngle;
    private ArrayList<PieData> mDatas;

    public PieView(Context context) {
        this(context, null);
    }

    public PieView(Context context, AttributeSet attrs) {
        this(context, null, 0);
    }

    public PieView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        intPaint();
    }

    private void intPaint() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;//MI-4C-->1080
        mHeight = h;//MI-4C-->1766
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float r = (float) (Math.min(mWidth, mHeight) / 2 * 0.5);
        canvas.translate(mWidth / 2, mHeight / 2);
        RectF rectF = new RectF(-r, -r, r, r);
        for (PieData pieData2 : mDatas) {
            mPaint.setColor(pieData2.getColor());
            canvas.drawArc(rectF, mStartAngle, pieData2.getAngle(), true, mPaint);
            mStartAngle += pieData2.getAngle();//获取开始角度

//            canvas.save();
//            canvas.translate(-mWidth / 2, -mHeight / 2);
//            RectF colorRect = new RectF(mCurrentPoint.x, mCurrentPoint.y, mCurrentPoint.x + mColorRectSideLength, mCurrentPoint.y + mColorRectSideLength);
//
//
//            canvas.restore();
        }
    }


    public void setDatas(ArrayList<PieData> arrayList) {
        this.mDatas = arrayList;
        initDatas();
        invalidate();
    }

    private void initDatas() {
        if (mDatas.size() == 0 && mDatas == null) {
            return;
        }
        float sumPer = 0;
        float sumAngle = 0;
        for (PieData pieData2 : mDatas) {
            int colorIndex = pieData2.getColorIndex();
            int per = pieData2.getPer();
            int colorSample = colorIndex % mColors.length;
            pieData2.color = mColors[colorSample];
//            pieData2.color = mColors[colorIndex];
            sumPer += per;

        }
        for (PieData pieData2 : mDatas) {
            int per = pieData2.getPer();
            float perCentage = per / sumPer;
            pieData2.perCentage = perCentage;//获取百分比
            pieData2.angle = perCentage * 360;//获取角度
            sumAngle += pieData2.angle;
        }


    }
}
