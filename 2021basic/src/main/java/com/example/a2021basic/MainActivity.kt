package com.example.a2021basic

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.a2021basic.databinding.ActivityMainBinding
import com.example.a2021basic.viewmodel.MainViewModel
import com.example.a2021basic.viewmodel.NumberViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.wuhenzhizao.titlebar.widget.CommonTitleBar

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private val numberViewModel: NumberViewModel by lazy {
        ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(NumberViewModel::class.java)
    }

    companion object {
        fun show(context: Context) {
            var intent = Intent(context, MainActivity::class.java);
            context.startActivity(intent)
        }
    }


    lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main);
//        setContentView(R.layout.activity_main)

//        setSupportActionBar(findViewById(R.id.toolbar))
//        mainBinding.titlebar
        var et1: AppCompatEditText = (mainBinding.main as View).findViewById(R.id.et_1)
        var et2: AppCompatEditText = (mainBinding.main as View)!!.findViewById(R.id.et_2)
        var btnAdd: Button = (mainBinding.main as View)!!.findViewById(R.id.btn_add)

        mainBinding.btnText.setOnClickListener {

        }

        numberViewModel.getA1().observe(this, Observer {
            mainBinding.tvText.text = it.toString();
        })

        btnAdd.setOnClickListener {
//            Toast.makeText(this, "xxxxxxxx", Toast.LENGTH_LONG).show();
            var a1 = et1.text.toString().trim();
            var a2 = et2.text.toString().trim();
            var count = Integer.parseInt(a1) + Integer.parseInt(a2);
            numberViewModel.setA1(count)
        }
        getViewModel();
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            println("xxxxx=FloatingActionButton")
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        val titleBar = findViewById<CommonTitleBar>(R.id.titlebar)
        titleBar.setBackgroundResource(R.drawable.shape_gradient)
        titleBar.setListener { v, action, extra ->
            println("xxxxx=ACTION_CENTER_TEXTaction=${action}")
            if (action == CommonTitleBar.ACTION_RIGHT_TEXT) {
                titleBar.toggleStatusBarMode()
            } else if (action == CommonTitleBar.ACTION_CENTER_TEXT) {
                println("xxxxx=ACTION_CENTER_TEXT")
                var bean = viewModel.login();
                println("xxxxx=login${bean}")
            }
        }

    }

    private fun getViewModel() {
        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(MainViewModel::class.java)
    }
}
