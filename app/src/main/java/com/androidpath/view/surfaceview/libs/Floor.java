package com.androidpath.view.surfaceview.libs;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;

/**
 * Created by Administrator on 2016/1/25.
 */
public class Floor {
    private static final float FLOOR_HEIGHT_SCALE = 4 / 5F;
    private int x, y;
    private BitmapShader mShader;
    private int gameWidth, gameHeight;

    public Floor(Bitmap mBitmap, int gameWidth, int gameHeight) {
        this.gameWidth = gameWidth;
        this.gameHeight = gameHeight;
        y = (int) (gameHeight * FLOOR_HEIGHT_SCALE);
        mShader = new BitmapShader(mBitmap, TileMode.REPEAT, TileMode.CLAMP);
    }

    public void drawFloor(Canvas canvas, Paint paint) {
        if (-x > gameWidth) {
            x = x % gameWidth;
        }
        //保存图层状态，方便绘制完成之后回滚
        canvas.save(Canvas.MATRIX_SAVE_FLAG);
        //移动画布到指定位置画图
        canvas.translate(x, y);
        paint.setShader(mShader);
        canvas.drawRect(x, 0, gameWidth - x, gameHeight - y, paint);
        //回滚到之前状态
        canvas.restore();
        paint.setShader(null);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
}
