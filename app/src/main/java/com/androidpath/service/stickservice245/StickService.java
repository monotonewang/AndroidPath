package com.androidpath.service.stickservice245;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.util.List;

public class StickService extends Service {

    private ActivityManager activityManager;

    @Override
    public void onCreate() {
        super.onCreate();
        new MyThread().start();
    }

    /**
     * 该方法的返回值，用来决定Service是否为粘性Service，有三个标示：
     * START_STICKY：表示粘性Service，当该Service如果被系统异常kill，
     * 那么该Service会尝试重启，重启成功以后，intent为null
     * <p>
     * START_NOT_STICKY：非粘性Service，普通的，被kill后不会尝试重启
     * <p>
     * START_REDELIVER_INTENT：带数据的粘性Service，当该Service如果被系统异常kill，
     * 那么该Service会尝试重启，重启成功以后，intent仍然保留原来的数据
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    class MyThread extends Thread {
        @Override
        public void run() {
            while (true) {
                //获得用来管理Activity、service、回退栈等 的一个系统服务
                activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
                //获取当前系统中，正在运行的Service管理对象集合，参数表示获取多少个
                List<RunningServiceInfo> runServiceInfoList = activityManager
                        .getRunningServices(100);
                boolean flag = false;
                for (RunningServiceInfo runServiceInfo : runServiceInfoList) {
                    //判断这些正在运行的服务中，有没有和当前Service同名的服务
                    if (runServiceInfo.service.getClassName().equals(
                            StickService.class.getName())) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    //如果没有 则重启
                    startService(new Intent(StickService.this,
                            StickService.class));
                    break;
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}
