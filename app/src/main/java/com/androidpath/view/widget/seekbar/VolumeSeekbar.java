package com.androidpath.view.widget.seekbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.SeekBar;

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
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        Path path = new Path();
//        path.moveTo(0, heightPixels);
//        path.lineTo(widthPixels, heightPixels);
//        path.lineTo(widthPixels, heightPixels - 100);
//        path.close();
        Path path2 = new Path();
        path2.moveTo(90, 330);
        path2.lineTo(150, 330);
        path2.lineTo(120, 270);
        path2.close();
        canvas.drawPath(path2, paint);


//        Bitmap bitmap = Bitmap.createBitmap(widthPixels, 200, Bitmap.Config.ARGB_8888);
//        canvas.setBitmap(bitmap);
//        if(bitmap!=null){
//            Drawable drawable = new BitmapDrawable(context.getResources(), bitmap);
////            this.setProgressDrawable(drawable);
//        }else{
//            Log.e(TAG, "onDraw: " + "drawable is null");
//        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        return super.onTouchEvent(event);

    }
}

