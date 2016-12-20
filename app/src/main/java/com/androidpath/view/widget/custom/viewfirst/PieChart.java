package com.androidpath.view.widget.custom.viewfirst;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import com.androidpath.R;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/12/20 16:59 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class PieChart extends View {

    private final boolean aBoolean;
    private final int anInt;

    public PieChart(Context context, AttributeSet attrs) {
        super(context,attrs);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.PieChart, 0, 0);
        aBoolean = typedArray.getBoolean(R.styleable.PieChart_showText, false);
        anInt = typedArray.getInt(R.styleable.PieChart_labelPosition, 0);
        typedArray.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}
