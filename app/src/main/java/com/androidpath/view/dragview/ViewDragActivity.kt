package com.androidpath.view.dragview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.androidpath.R
import kotlinx.android.synthetic.main.activity_view_drag.*

class ViewDragActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_drag)

        val dragView = DragView(this)
        dragView.minimumHeight=300
        dragView.minimumWidth=400

        constraint.addView(dragView)

    }
}
