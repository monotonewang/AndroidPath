package com.example.a2021basic

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.a2021basic.viewmodel.MainViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.wuhenzhizao.titlebar.widget.CommonTitleBar

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel;

    companion object {
        fun show(context: Context) {
            var intent = Intent(context, MainActivity::class.java);
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setSupportActionBar(findViewById(R.id.toolbar))

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
