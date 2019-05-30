package com.androidpath.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.androidpath.R
import com.androidpath.util.FileUtilssss
import com.androidpath.view.dragview.ViewDragActivity
import com.androidpath.view.flowlayout.libs.FlowLayout
import com.androidpath.view.flowlayout.libs.TagAdapter
import com.androidpath.view.flowlayout.libs.TagFlowLayout
import com.androidpath.view.hostarea.HotAreaActivity
import kotlinx.android.synthetic.main.activity_view.*

class ViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        val inflater = LayoutInflater.from(this)
        val arrayList = FileUtilssss.getArrayList(this, R.raw.view)


//        val strings = arrayList.toTypedArray() as Array<String>
//        val stringsx = arrayList.toArray() as Array<String>

        val stringArray = arrayListOf<String>()

        for (String in arrayList) {
            stringArray.add(String)
        }

        view_flowlayout!!.adapter = object : TagAdapter<String>(stringArray) {
            override fun getView(parent: FlowLayout?, position: Int, t: String?): View {
                val tv = inflater.inflate(R.layout.activity_flowlayout_tv,
                        view_flowlayout, false) as TextView
                tv.text = t
                return tv
            }
        }

        view_flowlayout.setOnTagClickListener(object : TagFlowLayout.OnTagClickListener {
            override fun onTagClick(view: View?, position: Int, parent: FlowLayout?): Boolean {
                when (position) {
                    0 -> startActivity(Intent(this@ViewActivity, HotAreaActivity::class.java))
                    1 -> startActivity(Intent(this@ViewActivity, ViewDragActivity::class.java))
                }
                return true
            }
        })

    }
}
