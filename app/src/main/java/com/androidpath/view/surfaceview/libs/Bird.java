package com.androidpath.view.surfaceview.libs;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.TypedValue;

/**
 * Created by Administrator on 2016/1/25.
 */
public class Bird {
    private static final float START_HEIGHT_SCALE = 2 / 3F;
    private static final float BIRD_SIZE = 30;
    private Bitmap mBitmap;
    private Rect mRect = new Rect();
    //鸟的宽高
    private int mWidth;
    private int mHeight;
    //鸟的位置（左上角的点）
    private int x, y;

    public Bird(Bitmap mBitmap, int gameWidth, int gameHeight, Context context) {
        this.mBitmap = mBitmap;
        x = (gameWidth / 2) - (mBitmap.getWidth() / 2);
        y = (int) (gameHeight * START_HEIGHT_SCALE);
        mWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, BIRD_SIZE, context.getResources().getDisplayMetrics());
        mHeight = (int) ((mWidth * 1.0F) / mBitmap.getWidth() * mBitmap.getHeight());

    }


    public void drawBird(Canvas canvas) {
        mRect.set(x, y, x + mWidth, y + mHeight);
        canvas.drawBitmap(mBitmap, null, mRect, null);
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHeight() {
        return mHeight;
    }

    public int getX() {
        return x;
    }

    public int getmWidth() {
        return mWidth;
    }
}
