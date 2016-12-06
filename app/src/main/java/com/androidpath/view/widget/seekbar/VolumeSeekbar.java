package com.androidpath.view.widget.seekbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.SeekBar;

import com.androidpath.R;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/12/6 13:46 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class VolumeSeekbar extends SeekBar {

    private Context context;
    private String TAG = "VolumeSeekbar";
    private int widthPixels;
    private int heightPixels;
    private Paint paint;
    private int width;
    private int height;

    public VolumeSeekbar(Context context) {
        this(context, null);
    }

    public VolumeSeekbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initView(context);
    }

    public VolumeSeekbar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    private void initView(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        widthPixels = displayMetrics.widthPixels;
        heightPixels = displayMetrics.heightPixels;
        Log.e(TAG, "initView: widthPixels=" + widthPixels + "heightPixels=" + heightPixels);
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(3);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
//        Log.e(TAG, "onMeasure: width=" + width + "height=" + height);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.volume);
        Drawable drawable = new BitmapDrawable(getResources(), bitmap);
        setProgressDrawable(drawable);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        return super.onTouchEvent(event);

    }
}

