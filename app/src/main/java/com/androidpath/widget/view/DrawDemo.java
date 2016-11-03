package com.androidpath.widget.view;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/3 16:49 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class DrawDemo extends View {

    // 声明起点坐标
    private int mov_x;
    private int mov_y;
    // 声明画笔
    private Paint paint;
    // 声明画布
    private Canvas canvas;
    // 声明位图
    private Bitmap bitmap;

    public DrawDemo(Context context) {

        super(context);
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

    // 画位图
    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        canvas.drawColor(Color.GRAY);

        canvas.drawBitmap(bitmap, 0, 0, null);
    }

    // 触摸事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        // 如果按下
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            mov_x = (int) event.getX();
            mov_y = (int) event.getY();
            // 画点
            canvas.drawPoint(mov_x, mov_y, paint);
            invalidate();
        }

        // 如果拖动
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            canvas.drawLine(mov_x, mov_y, event.getX(), event.getY(), paint);
            invalidate();
        }
        mov_x = (int) event.getX();
        mov_y = (int) event.getY();

        // return值必须为true，才能画连续曲线
        return true;
    }
}
