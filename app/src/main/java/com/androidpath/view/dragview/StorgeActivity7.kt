package com.androidpath.view.dragview

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.androidpath.R
import com.androidpath.activity.aabase.BaseActivity
import com.androidpath.activity.agstorge.asstes195.MainActivity195
import com.androidpath.activity.agstorge.contentResolverContacts161.MainActivity161
import com.androidpath.activity.agstorge.contentobserver160.MainActivity160
import com.androidpath.activity.agstorge.fileStorgetwo132.MainActivity132
import com.androidpath.activity.agstorge.filestorge131.MainActivity131
import com.androidpath.activity.agstorge.loadimage172.MainActivity172
import com.androidpath.activity.agstorge.loadmanagercontact171.MainActivity171
import com.androidpath.activity.agstorge.loadmanger170.MainActivity170
import com.androidpath.activity.agstorge.sharedproference130.MainActivity130
import com.androidpath.activity.agstorge.sql.simplecusoradapter155.MainActivity155
import com.androidpath.activity.agstorge.sql.sql140.MainActivity140
import com.androidpath.activity.agstorge.sql.sqlclientone150.MainActivity150
import com.androidpath.activity.agstorge.sql.sqlclienttwo152.MainActivity152
import com.androidpath.activity.agstorge.sql.sqldemo154.MainActivity154
import com.androidpath.activity.agstorge.sql.sqlserverone151.MainActivity151
import com.androidpath.activity.agstorge.sql.sqlservertwo153.MainActivity153
import com.androidpath.util.FileUtilssss
import com.androidpath.view.flowlayout.libs.FlowLayout
import com.androidpath.view.flowlayout.libs.TagAdapter
import com.androidpath.view.flowlayout.libs.TagFlowLayout

class StorgeActivity7 : BaseActivity(), TagFlowLayout.OnTagClickListener {
    private var mAdapter: TagAdapter<String>? = null
    private var mFlowLayout: TagFlowLayout? = null
    private var mVals: Array<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storge7)

        val mInflater = LayoutInflater.from(this)
        val arrayList = FileUtilssss.getArrayList(this, R.raw.storgedemo)
        mVals = arrayList!!.toTypedArray() as Array<String>
        mFlowLayout = findViewById(R.id.storge_flowlayout) as TagFlowLayout
        mFlowLayout!!.adapter = object : TagAdapter<String>(mVals) {
            override fun getView(parent: FlowLayout, position: Int, s: String): View {
                val tv = mInflater.inflate(R.layout.activity_flowlayout_tv,
                        mFlowLayout, false) as TextView
                tv.text = s
                return tv
            }
        }
        mFlowLayout!!.setOnTagClickListener(this)
    }

    override fun onTagClick(view: View, position: Int, parent: FlowLayout): Boolean {
        when (position) {
            0 -> startActivity(Intent(this@StorgeActivity7, MainActivity130::class.java))
            1 -> startActivity(Intent(this@StorgeActivity7, MainActivity131::class.java))
            2 -> startActivity(Intent(this@StorgeActivity7, MainActivity132::class.java))
            3 -> startActivity(Intent(this@StorgeActivity7, MainActivity140::class.java))
            4 -> startActivity(Intent(this@StorgeActivity7, MainActivity150::class.java))
            5 -> startActivity(Intent(this@StorgeActivity7, MainActivity151::class.java))
            6 -> startActivity(Intent(this@StorgeActivity7, MainActivity152::class.java))
            7 -> startActivity(Intent(this@StorgeActivity7, MainActivity153::class.java))
            8 -> startActivity(Intent(this@StorgeActivity7, MainActivity154::class.java))
            9 -> startActivity(Intent(this@StorgeActivity7, MainActivity155::class.java))
            10 -> startActivity(Intent(this@StorgeActivity7, MainActivity160::class.java))
            11 -> startActivity(Intent(this@StorgeActivity7, MainActivity161::class.java))
            12 -> startActivity(Intent(this@StorgeActivity7, MainActivity170::class.java))
            13 -> startActivity(Intent(this@StorgeActivity7, MainActivity171::class.java))
            14 -> startActivity(Intent(this@StorgeActivity7, MainActivity172::class.java))
            15 -> startActivity(Intent(this@StorgeActivity7, MainActivity195::class.java))
        }
        return true

    }
}
