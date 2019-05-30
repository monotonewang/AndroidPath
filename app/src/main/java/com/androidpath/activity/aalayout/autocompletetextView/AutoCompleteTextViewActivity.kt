package com.androidpath.activity.aalayout.autocompletetextView

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.MultiAutoCompleteTextView
import com.androidpath.R
import kotlinx.android.synthetic.main.activity_auto_complete_text_view.*

class AutoCompleteTextViewActivity : AppCompatActivity() {

    val stringArray = arrayListOf<String>("疯狂的java讲义", "疯狂的Android讲义", "疯狂的xml讲义", "疯狂workFlow讲义")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auto_complete_text_view)
        val adapterx = ArrayAdapter<String>(this, R.layout.simple_drop_down_item_line, stringArray)

        auto.setAdapter(adapterx)

        mAuto.setAdapter(adapterx)
        mAuto.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
    }
}
