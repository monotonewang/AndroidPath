package com.androidpath.library.work_manager

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*
import com.androidpath.R
import com.androidpath.library.work_manager.worker.UploadWorker

/**
 * 2021年02月21日19:16:51
 * https://developer.android.google.cn/topic/libraries/architecture/workmanager
 * https://developer.android.google.cn/topic/libraries/architecture/workmanager/basics
 */
class WorkManagerActivity : AppCompatActivity() {

    lateinit var tv: TextView;


    companion object {
        @JvmStatic
        fun show(context: Context) {
            context.startActivity(Intent(context, WorkManagerActivity::class.java))
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_work_manager)

        tv = findViewById<TextView>(R.id.tv_text)
        tv.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                println("xxxxxxxxxx 1 setOnClickListener" + Thread.currentThread().name)
            }
        })
        tv.setOnClickListener {
//                val uploadWorkRequest = OneTimeWorkRequest.from(UploadWorker::class.java);
            val uploadWorkRequest: WorkRequest =
                    OneTimeWorkRequestBuilder<UploadWorker>()
                            .build()
//        Submit the WorkRequest to the system
            WorkManager
                    .getInstance(applicationContext)
                    .enqueue(uploadWorkRequest)
        }
    }

//    inner class UploadWorker(appContext: Context, workerParams: WorkerParameters) :
//            Worker(appContext, workerParams) {
//        override fun doWork(): Result {
//
//            // Do the work here--in this case, upload the images.
////            uploadImages()
//            println("xxxxxxxxxx UploadWorker doWork" + Thread.currentThread().name)
////            tv.text = "yes success"
//
////            Toast.makeText(applicationContext, "do work", Toast.LENGTH_LONG).show()
//            // Indicate whether the work finished successfully with the Result
//            return Result.success()
//        }
//    }

}