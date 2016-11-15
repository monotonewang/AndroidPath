package com.androidpath.view.glsurfaceview;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class GLSurfaceViewActivity extends AppCompatActivity {
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
