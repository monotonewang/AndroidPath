package com.androidpath.view.widget.custom.viewfirst;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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

    private boolean aBoolean;
    private int anInt;
    private Paint mTextPaint,mPiePaint,mShadowPaint;
    private int mTextColor= Color.BLUE;
    private float mTextHeight=20.22f;
    private float mTextWidth=20.22f;

    public PieChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.PieChart, 0, 0);
        aBoolean = typedArray.getBoolean(R.styleable.PieChart_showText, false);
        anInt = typedArray.getInt(R.styleable.PieChart_labelPosition, 0);
        typedArray.recycle();
        init();
    }

    private void init() {
        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(mTextColor);
        if (mTextHeight == 0) {
            mTextHeight = mTextPaint.getTextSize();
        } else {
            mTextPaint.setTextSize(mTextHeight);
        }

        mPiePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPiePaint.setStyle(Paint.Style.FILL);
        mPiePaint.setTextSize(mTextHeight);

        mShadowPaint = new Paint(0);
        mShadowPaint.setColor(0xff101010);
        mShadowPaint.setMaskFilter(new BlurMaskFilter(8, BlurMaskFilter.Blur.NORMAL));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //touchscreen
//        sendAccessibilityEvent();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // Try for a width based on our minimum
        int minw = getPaddingLeft() + getPaddingRight() + getSuggestedMinimumWidth();
        int w = resolveSizeAndState(minw, widthMeasureSpec, 1);

        // Whatever the width ends up being, ask for a height that would let the pie
        // get as big as it can
        int minh = MeasureSpec.getSize(w) - (int)mTextWidth + getPaddingBottom() + getPaddingTop();
        int h = resolveSizeAndState(MeasureSpec.getSize(w) - (int)mTextWidth, heightMeasureSpec, 0);

        setMeasuredDimension(w, h);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        // Account for padding
        float xpad = (float)(getPaddingLeft() + getPaddingRight());
        float ypad = (float)(getPaddingTop() + getPaddingBottom());

        // Account for the label
        if (aBoolean) xpad += mTextWidth;

        float ww = (float)w - xpad;
        float hh = (float)h - ypad;

        // Figure out how big we can make the pie.
        float diameter = Math.min(ww, hh);
    }

    /**
     * 是否展示text
     *
     * @return
     */
    public boolean isShowText() {
        return aBoolean;
    }

    public void setShowText(boolean showText) {
        aBoolean = showText;
        invalidate();
        requestLayout();
    }
}
