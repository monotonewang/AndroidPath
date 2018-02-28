package com.androidpath.view.dragview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

/**
 * Created by zgjxf on 2018/2/16.
 */
class DragView : View{

    var currentX = 40f
    var currentY = 50f

    internal var paint = Paint()

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        val a = 0
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.color = Color.RED
        canvas.drawCircle(currentX, currentY, 15f, paint)

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        currentX = event.x
        currentY = event.y
        invalidate()
        return true
    }
}