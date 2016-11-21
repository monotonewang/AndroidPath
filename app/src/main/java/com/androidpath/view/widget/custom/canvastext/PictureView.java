package com.androidpath.view.widget.custom.canvastext;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.util.AttributeSet;
import android.view.View;

import com.androidpath.R;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/18 17:47 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class PictureView extends View {
    private Picture picture = new Picture();
    private Paint mPaint;

    public PictureView(Context context, AttributeSet attrs) {
        this(context, null, 0);
    }

    public PictureView(Context context) {
        this(context, null);
    }

    public PictureView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        Canvas canvas = picture.beginRecording(500, 500);
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.translate(250, 250);
        canvas.drawCircle(0, 0, 100, mPaint);
        picture.endRecording();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        picture.draw(canvas);
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img01);
//        float top=20;
//        float left=20;
        float right=500;
        float bottom=500;
//        canvas.drawBitmap(bitmap,top,left,mPaint);
        String text = "view test";
        mPaint.setTextSize(90);
        canvas.drawText(text,right,bottom,mPaint);
        Path path=new Path();
        path.lineTo(500,500);
        path.lineTo(700,900);
        path.moveTo(1,1000);
        canvas.drawPath(path,mPaint);
        canvas.drawTextOnPath(text,path,100,100,mPaint);
    }
}
