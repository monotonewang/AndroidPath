package com.androidpath.view.glsurfaceview;

import android.opengl.GLSurfaceView;
import android.util.Log;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * desc：TODO <br/>
 * time: 2016/7/26 14:49 <br/>
 * author：傅晴望 <br/>
 * since：V TODO <br/>
 */
public class BgGLSurfaceViewRender implements GLSurfaceView.Renderer {
    private final String TAG = "BgGLSurfaceViewRender";

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        Log.i(TAG, "onSurfaceCreated");

        // 设置背景颜色
        gl.glClearColor(0.0f, 0f, 1f, 0.5f);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        // 设置输出屏幕大小
        gl.glViewport(0, 0, width, height);
        Log.i(TAG, "onSurfaceChanged");
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        Log.i(TAG, "onDrawFrame");
        // 清除屏幕和深度缓存(如果不调用该代码, 将不显示glClearColor设置的颜色)
        // 同样如果将该代码放到 onSurfaceCreated 中屏幕会一直闪动
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
    }
}
