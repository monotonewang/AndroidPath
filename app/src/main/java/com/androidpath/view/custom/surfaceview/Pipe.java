package com.androidpath.view.custom.surfaceview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.TypedValue;

import java.util.Random;

/**
 * Created by Administrator on 2016/1/26.
 */
public class Pipe {
    //管道宽度
    private static final int PIPE_WIDTH = 60;
    private int mPipeWidth;
    /**
     * 上下管道间的距离
     */
    private static final float RADIO_BETWEEN_UP_DOWN = 1 / 5F;
    /**
     * 上管道的最大高度
     */
    private static final float RADIO_MAX_HEIGHT = 2 / 5F;
    /**
     * 上管道的最小高度
     */
    private static final float RADIO_MIN_HEIGHT = 1 / 5F;
    //管道横坐标
    private int x;
    //上管道高度
    private int height;
    //上下管道之间的距离
    private int margin;
    //上下管道图片
    private Bitmap topBitmap, bottomBitmap;
    private static Random random = new Random();
    private Rect rect;

    public Pipe(Context context, int gameWidth, int gameHeight, Bitmap bottomBitmap, Bitmap topBitmap) {
        this.bottomBitmap = bottomBitmap;
        this.topBitmap = topBitmap;
        x = gameWidth;
        margin = (int) (gameHeight * RADIO_BETWEEN_UP_DOWN);
        randomHeight(gameHeight);
        mPipeWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, PIPE_WIDTH, context.getResources().getDisplayMetrics());
        rect = new Rect(0, 0, mPipeWidth, gameHeight);
    }

    private void randomHeight(int gameHeight) {
        height = (int) (random.nextInt((int) (gameHeight * (RADIO_MAX_HEIGHT - RADIO_MIN_HEIGHT))) + gameHeight * RADIO_MIN_HEIGHT);
    }

    public void drawPipe(Canvas canvas) {
        canvas.save(Canvas.MATRIX_SAVE_FLAG);
        //移动画布到指定位置，假设完整管道为100，需要绘制20，则向上偏移80
        canvas.translate(x, -(rect.bottom - height));
        canvas.drawBitmap(topBitmap, null, rect, null);
        //因为第一次偏移 所以先偏移回来再偏移管道高度加上间距
        canvas.translate(0, (rect.bottom - height) + height + margin);
        canvas.drawBitmap(bottomBitmap, null, rect, null);
        canvas.restore();

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getmPipeWidth() {
        return mPipeWidth;
    }
    public boolean touchBird(Bird bird){
        if(bird.getX()+bird.getmWidth()>x&&(bird.getY()<height||bird.getY()+bird.getHeight()>height+margin)){
            return true;
        }
        return false;
    }
}
