package com.androidpath.widget.view;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;

import com.androidpath.R;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/3 16:49 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class DrawDemo2 extends View {

    // 声明起点坐标
    private int mov_x;
    private int mov_y;
    // 声明画笔
    private Paint paint;
    // 声明画布
    private Canvas canvas;
    // 声明位图
    private Bitmap bitmap;

    private int count;
    private String TAG = "DrawDemo2";
    private final Bitmap bitmapx;

    public DrawDemo2(Context context) {
        super(context);

        bitmapx = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher);
        // 创建画笔对象
        paint = new Paint();
        // 获取屏幕的宽高
        Display display = ((Activity) context).getWindowManager()
                .getDefaultDisplay();
        // 设置位图的宽高
        bitmap = Bitmap.createBitmap(display.getWidth(), display.getHeight(),
                Bitmap.Config.ARGB_8888);
        // 创建Canvas对象
        canvas = new Canvas();
        canvas.setBitmap(bitmap);

        // 设置非填充
        paint.setStyle(Paint.Style.STROKE);
        // 画笔宽5像素
        paint.setStrokeWidth(5);

        // 设置画笔为红色
        paint.setColor(Color.RED);
        // 设置锯齿不显示
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e(TAG, "onDraw: ");
        canvas.drawColor(Color.GRAY);
        canvas.drawBitmap(bitmap, 0, 0, null);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.e(TAG, "onLayout: ");

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e(TAG, "onMeasure: ");

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            mov_x = (int) event.getX();
            mov_y = (int) event.getY();
            Log.e(TAG, "onTouchEvent: " + "mov_x=" + mov_x + "mov_y =" + mov_y);
            int width = bitmapx.getWidth() / 2;
            int height = bitmapx.getHeight() / 2;
            if (count < 30) {
                canvas.drawBitmap(bitmapx, mov_x - width, mov_y - height, paint);
            }
            count++;
//            canvas.drawPoint(mov_x, mov_y, paint);
            invalidate();
        }

//        if (event.getAction() == MotionEvent.ACTION_MOVE) {

//            canvas.drawBitmap(bitmap, event.getX(), event.getY(), paint);
////            canvas.drawLine(mov_x, mov_y, event.getX(), event.getY(), paint);
//            invalidate();
//        }
        mov_x = (int) event.getX();
        mov_y = (int) event.getY();

        // return值必须为true，才能画连续曲线
        return true;
    }
}
