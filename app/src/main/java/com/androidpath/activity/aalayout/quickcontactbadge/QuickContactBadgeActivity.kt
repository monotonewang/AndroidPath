package com.androidpath.activity.aalayout.quickcontactbadge

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.androidpath.R
import kotlinx.android.synthetic.main.activity_quick_contact_badge.*

//关联联系人
class QuickContactBadgeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quick_contact_badge)

        quickContactBadge.assignContactFromPhone("13968014361", false)
    }
}
