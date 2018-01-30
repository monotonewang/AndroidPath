package com.androidpath.activity.aalayout.ratingbar20180130

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.androidpath.R
import kotlinx.android.synthetic.main.activity_rating_bar.*

class RatingBar20180130Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating_bar)
        ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            println("xx"+rating)
        }
    }
}
