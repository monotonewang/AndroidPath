package com.androidpath.activity.akservice.servicedemo241

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.androidpath.R

class StartService : Service() {
    /**
     * 初始化方法 -- 该方法只会被调用一次
     */
    override fun onCreate() {
        super.onCreate()
        println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" + "--->onCreate" + Thread.currentThread().name)
    }

    var isRunning = true
    var last = System.currentTimeMillis()
    var notificationId = 328989
    var CHANNEL_ID = "CHANNEL_ID"

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                    getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    /**
     * 该方法会被调用多次 -- 每启动一次service，该方法就会被调用一次
     */
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        var name = ""
        if (intent != null) name = intent.getStringExtra("name").toString()
        println("xxxxxxxxxxxxx begin thread run")

        val thread: Thread = object : Thread() {
            override fun run() {
                super.run()
                println("xxxxxxxxxxxxx StartService thread run")

                var url = "http://mp3.9ku.com/hot/2009/01-14/179021.mp3"
                val mediaPlayer = MediaPlayer()
                mediaPlayer.setDataSource(url)
                mediaPlayer.prepareAsync()
                mediaPlayer.setOnPreparedListener {
                    println("xxxxxxxxxxxxx setOnPreparedListener thread run")
                    it.start()
                }

                var flagss = 0;
                // Create an explicit intent for an Activity in your app
                val intent = Intent(this@StartService, MainActivity241::class.java).apply {
                    flagss = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                }

                val pendingIntent: PendingIntent = PendingIntent.getActivity(this@StartService, 0, intent, 0)

                var builder = NotificationCompat.Builder(this@StartService, "CHANNEL_ID")
                        .setSmallIcon(R.drawable.a0)
                        .setContentTitle("music")
                        .setContentText("红尘滚滚来")
//                        .setStyle(NotificationCompat.BigTextStyle()
//                                .bigText("Much longer text that cannot fit one line..."))
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .addAction(R.drawable.a6t,"Previous",pendingIntent)
                        .setContentIntent(pendingIntent)
                createNotificationChannel()
                NotificationManagerCompat.from(this@StartService).apply {
                    notify(notificationId, builder.build())
                }
                while (isRunning) {
                    if (System.currentTimeMillis() - last > 1000) {
                        last = System.currentTimeMillis()
                        println("xxxxxxxxxxxx StartService Thread in " + System.currentTimeMillis() / 1000)
                    }
                }
            }
        }
//        stopSelf()
        thread.name = "StartService"
        thread.start()
        println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" + "--->onStartCommand" + Thread.currentThread().name + "flags=" + flags + "startId=" + startId + "name=" + name)
        //        Log.d("print", "--->onStartCommand" + Thread.currentThread().getName() + "flags=" + flags + "startId=" + startId+"name="+name);
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
        println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" + "--->onDestroy" + Thread.currentThread().name)
    }

    override fun onBind(arg0: Intent): IBinder? {
        println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" + "--->onBind" + Thread.currentThread().name)
        return null
    }

    override fun onRebind(intent: Intent) {
        println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" + "--->onRebind" + Thread.currentThread().name)
        super.onRebind(intent)
    }

    override fun onUnbind(intent: Intent): Boolean {
        println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" + "--->onUnbind" + Thread.currentThread().name)
        return super.onUnbind(intent)
    }
}