package com.androidpath.view.glsurfaceview.libs;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.SystemClock;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * desc：渲染类 <br/>
 * time: 2016/7/26 15:32 <br/>
 * author：傅晴望 <br/>
 * since：V TODO <br/>
 */
public class MyGLRenderer implements GLSurfaceView.Renderer {

    private Triangle triangle;
    // mMVPMatrix is an abbreviation for "Model View Projection Matrix"
    private final float[] mMVPMatrix = new float[16];
    private final float[] mProjectionMatrix = new float[16];
    private final float[] mViewMatrix = new float[16];
    private float[] mRotationMatrix = new float[16];

    public volatile float mAngle;

    public float getAngle() {
        return mAngle;
    }

    public void setAngle(float angle) {
        mAngle = angle;
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        // Set the background frame color
//        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        triangle = new Triangle();


    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        GLES20.glViewport(0, 0, width, height);
        float ratio = (float) width / height;

        // this projection matrix is applied to object coordinates
        // in the onDrawFrame() method
        Matrix.frustumM(mProjectionMatrix, 0, -ratio, ratio, -1, 1, 3, 7);

    }

    @Override
    public void onDrawFrame(GL10 gl) {
        // Redraw background color
//        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
//        triangle.draw();
        // Set the camera position (View matrix)
        float[] scratch = new float[16];

        Matrix.setLookAtM(mViewMatrix, 0, 0, 0, -3, 0f, 0f, 0f, 0f, 1.0f, 0.0f);

        // Calculate the projection and view transformation
        Matrix.multiplyMM(mMVPMatrix, 0, mProjectionMatrix, 0, mViewMatrix, 0);

        // Draw shape
        triangle.draw(mMVPMatrix);

        // Create a rotation transformation for the triangle
        long time = SystemClock.uptimeMillis() % 4000L;
        float angle = 0.090f * ((int) time);
        Matrix.setRotateM(mRotationMatrix, 0, angle, 0, 0, -1.0f);

        // Combine the rotation matrix with the projection and camera view
        // Note that the mMVPMatrix factor *must be first* in order
        // for the matrix multiplication product to be correct.
        Matrix.multiplyMM(scratch, 0, mMVPMatrix, 0, mRotationMatrix, 0);

        // Draw triangle
        triangle.draw(scratch);
        Matrix.setRotateM(mRotationMatrix, 0, mAngle, 0, 0, -1.0f);

        // 合并旋转矩阵到投影和相机视口矩阵
        Matrix.multiplyMM(mMVPMatrix, 0, mRotationMatrix, 0, mMVPMatrix, 0);

        // 画一个角度
        triangle.draw(mMVPMatrix);

    }
    public static int loadShader(int type, String shaderCode){

        // create a vertex shader type (GLES20.GL_VERTEX_SHADER)
        // or a fragment shader type (GLES20.GL_FRAGMENT_SHADER)
        int shader = GLES20.glCreateShader(type);

        // add the source code to the shader and compile it
        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);

        return shader;
    }
}
