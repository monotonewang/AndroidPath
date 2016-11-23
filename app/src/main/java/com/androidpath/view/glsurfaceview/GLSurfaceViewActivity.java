package com.androidpath.view.glsurfaceview;

import android.opengl.GLSurfaceView;
import android.os.Bundle;


import com.androidpath.activity.aabase.BaseActivity;
import com.androidpath.view.glsurfaceview.libs.MyGLSurfaceView;

public class GLSurfaceViewActivity extends BaseActivity {
    private GLSurfaceView mGLView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGLView =new MyGLSurfaceView(this);
        setContentView(mGLView);

//        GLSurfaceView glSurfaceView=new GLSurfaceView(this);
//        BgGLSurfaceViewRender myGLSurfaceViewRender=new BgGLSurfaceViewRender();
//        glSurfaceView.setRenderer(myGLSurfaceViewRender);
//        this.setContentView(glSurfaceView);
    }
}
