package com.androidpath.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidpath.R;

/**
 * Created by ubuntu on 17-9-14.
 */

public class MyHandView extends LinearLayout {

    private String TAG = getClass().getSimpleName();
    private Paint paint;

    public MyHandView(Context context) {
        super(context);
        initialise(context);
    }

    public MyHandView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialise(context);
    }

    public MyHandView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialise(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyHandView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialise(context);
    }

    TextView bubble;
    ImageView handle;

    private void initialise(Context context) {
        setOrientation(HORIZONTAL);
        setClipChildren(false);
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.recyclerview_fastscroller, this, true);

        bubble = (TextView) findViewById(R.id.fastscroller_bubble);
        handle = (ImageView) findViewById(R.id.fastscroller_handle);
//        bubble.setVisibility(VISIBLE);
        paint = new Paint();
        paint.setColor(getContext().getResources().getColor(R.color.colorAccent));
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(2);
        setWillNotDraw(false);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.e(TAG, "onFinishInflate: ");
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.e(TAG, "onAttachedToWindow: ");
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        Log.e(TAG, "onWindowVisibilityChanged: ");
    }

    @Override
    protected void onVisibilityChanged(@NonNull View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        Log.e(TAG, "onVisibilityChanged: ");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.e(TAG, "onMeasure: ");
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        int resultWidth = 0;
//        int resultHeight = 0;
//
//        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
//        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
//        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);
//        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
//
////        int widthPixels = getContext().getResources().getDisplayMetrics().widthPixels;
//
//        Log.e(TAG, "onMeasure: " + sizeWidth);
//        switch (modeWidth) {
//            case MeasureSpec.AT_MOST:
//                Log.e(TAG, "onMeasure: AT_MOST");
//                resultWidth = 500;
//                break;
//            case MeasureSpec.UNSPECIFIED:
//                Log.e(TAG, "onMeasure: UNSPECIFIED");
//                break;
//            case MeasureSpec.EXACTLY:
//                resultWidth = sizeWidth;
//                Log.e(TAG, "onMeasure: EXACTLY");
//                break;
//        }
//        switch (modeHeight) {
//            case MeasureSpec.AT_MOST:
//                Log.e(TAG, "onMeasure: AT_MOST");
//                resultHeight = 500;
//                break;
//            case MeasureSpec.UNSPECIFIED:
//                Log.e(TAG, "onMeasure: UNSPECIFIED");
//                break;
//            case MeasureSpec.EXACTLY:
//                resultHeight = sizeHeight;
//                Log.e(TAG, "onMeasure: EXACTLY");
//                break;
//        }
//        setMeasuredDimension(Math.max(sizeWidth, resultWidth), Math.max(sizeWidth, resultHeight));
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.e(TAG, "onSizeChanged: ");
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        Log.e(TAG, "onLayout: ");
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        Log.e(TAG, "onWindowFocusChanged: ");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e(TAG, "onDraw: ");
        int left = getLeft();
        int right = getRight();
        int top = getTop();
        int bottom = getBottom();
        Log.e(TAG, "onDraw: left=" + left + "right=" + right + "top=" + top + "bottom=" + bottom);
//        canvas.drawRect(left, top, right, bottom, paint);
        canvas.drawText("画圆：", 10, 20, paint);// 画文本
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.e(TAG, "onDetachedFromWindow: ");
    }

    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, @Nullable Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        Log.e(TAG, "onFocusChanged: ");
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "onTouchEvent: ");
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "onTouchEvent: ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "onTouchEvent: ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "onTouchEvent: ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e(TAG, "onTouchEvent: ACTION_CANCEL");

                break;
        }
        return super.onTouchEvent(event);
    }
}

