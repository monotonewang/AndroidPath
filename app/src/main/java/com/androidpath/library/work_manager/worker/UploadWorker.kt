package com.androidpath.library.work_manager.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class UploadWorker(appContext: Context, workerParams: WorkerParameters) :
        Worker(appContext, workerParams) {

    //不是主线程
    override fun doWork(): Result {

        // Do the work here--in this case, upload the images.
//            uploadImages()
        println("UploadWorker doWork" + Thread.currentThread().name)

        // Indicate whether the work finished successfully with the Result
        return Result.success()
    }

}
