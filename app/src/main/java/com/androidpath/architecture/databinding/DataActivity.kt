package com.androidpath.architecture.databinding

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.androidpath.R

class DataActivity : AppCompatActivity() {

    private lateinit var binding: com.androidpath.databinding.ActivityDataBinding

    private val myName: MyName = MyName("tom", "nick")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_data)

        val textView = binding.tv as TextView
        textView.setOnClickListener {
            binding.myName=myName
            Toast.makeText(this, "This is DataBinding", Toast.LENGTH_SHORT).show()
        }
    }

}




