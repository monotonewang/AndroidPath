package com.androidpath.view.widget.custom.canvastext;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.util.AttributeSet;
import android.view.View;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/18 17:47 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class PictureView extends View {
    private Picture picture=new Picture();
    public PictureView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PictureView(Context context) {
        this(context, null);
    }

    public PictureView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        Canvas canvas=picture.beginRecording(500,500);
        Paint paint=new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        canvas.translate(250,250);
        canvas.drawCircle(0,0,100,paint);
        picture.endRecording();
    }
}
