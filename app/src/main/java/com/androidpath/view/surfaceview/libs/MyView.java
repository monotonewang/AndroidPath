package com.androidpath.view.surfaceview.libs;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.androidpath.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2016/1/20.
 */
public class MyView extends SurfaceView implements SurfaceHolder.Callback {
    /**
     * 定义一个枚举表示游戏的状态
     */
    private enum GameStatus {
        WAITTING, RUNNING, STOP
    }

    /**
     * 记录游戏的状态
     */
    private GameStatus mStatus = GameStatus.WAITTING;

    private SurfaceHolder holder = null;
    private Paint mPaint = null;
    private Bitmap mBg;
    private Canvas mCanvas;
    /**
     * 当前View的尺寸
     */
    private int mWidth;
    private int mHeight;
    private RectF mGamePanelRect = new RectF();
    /**
     * 鸟
     */
    private Bird mBird;
    private Bitmap mBitmap_bird;
    /**
     * 地板
     */
    private Bitmap mBitmap_floor;
    private Floor mFloor;
    private int mSpeed;
    /**
     * 管道
     */
    private List<Pipe> mPipes = new ArrayList<>();
    private Bitmap topBitmap, bottomBitmap;
    private List<Pipe> mNeedRemovePipes = new ArrayList<>();
    /**
     * 分数
     */
    private final int[] mNums = new int[]{R.mipmap.n0, R.mipmap.n1,
            R.mipmap.n2, R.mipmap.n3, R.mipmap.n4, R.mipmap.n5,
            R.mipmap.n6, R.mipmap.n7, R.mipmap.n8, R.mipmap.n9};
    private int mGrade = 100;
    private Bitmap[] mNumBitmap;
    //移除的管道，用来计算分数
    private int mRemovedPipe = 0;
    /**
     * 单个数字的高度的1/15
     */
    private static final float RADIO_SINGLE_NUM_HEIGHT = 1 / 15f;
    /**
     * 单个数字的宽度
     */
    private int mSingleGradeWidth;
    /**
     * 单个数字的高度
     */
    private int mSingleGradeHeight;
    /**
     * 单个数字的范围
     */
    private RectF mSingleNumRectF;

    /**
     * 初始化分数图片
     */
    private void initNumBitmaps() {

        mNumBitmap = new Bitmap[mNums.length];
        for (int i = 0; i < mNumBitmap.length; i++) {
            mNumBitmap[i] = BitmapFactory.decodeResource(getResources(), mNums[i]);
        }
    }

    /**
     * 触摸上升的距离，因为是上升，所以为负值
     */
    private static final int TOUCH_UP_SIZE = -16;
    /**
     * 将上升的距离转化为px；这里多存储一个变量，变量在run中计算
     */
    private final int mBirdUpDis = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, TOUCH_UP_SIZE, getResources().getDisplayMetrics());

    private int mTmpBirdDis;
    /**
     * 鸟自动下落的距离
     */
    private final int mAutoDownSpeed = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, getResources().getDisplayMetrics());
    /**
     * 两个管道间距离
     */
    private final int PIPE_DIS_BETWEEN_TWO = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300, getResources().getDisplayMetrics());
    /**
     * 记录移动的距离，达到 PIPE_DIS_BETWEEN_TWO 则生成一个管道
     */
    private int mTmpMoveDistance;

    public MyView(Context context) {
        super(context);
        init();
    }


    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
        mGamePanelRect.set(0, 0, w, h);
        mBird = new Bird(mBitmap_bird, mWidth, mHeight, getContext());
        mFloor = new Floor(mBitmap_floor, mWidth, mHeight);
        Pipe pipe = new Pipe(getContext(), mWidth, mHeight, bottomBitmap, topBitmap);
        mPipes.add(pipe);
        mSingleGradeHeight = (int) (mHeight * RADIO_SINGLE_NUM_HEIGHT);
        mSingleGradeWidth = (int) (mSingleGradeHeight * 1.0f / mNumBitmap[0].getHeight() * mNumBitmap[0].getWidth());
        mSingleNumRectF = new RectF(0, 0, mSingleGradeWidth, mSingleGradeHeight);
    }

    private void init() {
        initBitmaps();
        holder = getHolder();
        holder.addCallback(this);
        mPaint = new Paint();
        mPaint.setDither(true);
        mPaint.setAntiAlias(true);
        setZOrderOnTop(true);// 设置画布 背景透明
        holder.setFormat(PixelFormat.TRANSLUCENT);

        // 设置可获得焦点
        setFocusable(true);
        setFocusableInTouchMode(true);
        // 设置常亮
        this.setKeepScreenOn(true);
        mSpeed = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
    }

    private void initBitmaps() {
        mBg = BitmapFactory.decodeResource(getResources(), R.mipmap.bg1);
        mBitmap_bird = BitmapFactory.decodeResource(getResources(), R.mipmap.b1);
        mBitmap_floor = BitmapFactory.decodeResource(getResources(), R.mipmap.floor_bg2);
        topBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.g2);
        bottomBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.g1);
        initNumBitmaps();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        run = true;
        new Thread(new drawThread()).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        run = false;
    }

    private boolean run = true;

    class drawThread implements Runnable {

        @Override
        public void run() {
            while (run) {

                long startTime = System.currentTimeMillis();


                long endTime = System.currentTimeMillis();
                logic();
                doDraw();
                int diffTime = (int) (endTime - startTime);

                if (diffTime < 50) {
                    try {
                        Thread.sleep(50 - diffTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                switch (mStatus) {
                    case WAITTING:
                        mStatus = GameStatus.RUNNING;
                        break;
                    case RUNNING:
                        mTmpBirdDis = mBirdUpDis;
                        break;
                }

                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:

                break;

            default:
                break;
        }
        return true;
    }

    private void doDraw() {
        try {
            mCanvas = holder.lockCanvas();
            if (mCanvas != null) {
                drawBg();
                mBird.drawBird(mCanvas);
                drawPipe();
                mFloor.drawFloor(mCanvas, mPaint);
                //mFloor.setX(mFloor.getX() - mSpeed);
                drawGrades();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (mCanvas != null) {
                holder.unlockCanvasAndPost(mCanvas);
            }
        }
    }

    private void logic() {
        switch (mStatus) {
            case RUNNING:
                //重置分数
                mGrade = 0;
                // 管道移动的距离
                mTmpMoveDistance += mSpeed;
                //如果达到管道间的距离 则生成 一个管道加入list里面
                if (mTmpMoveDistance > PIPE_DIS_BETWEEN_TWO) {
                    mPipes.add(new Pipe(getContext(), mWidth, mHeight, bottomBitmap, topBitmap));
                    mTmpMoveDistance = 0;
                }
                // 管道移动
                for (Pipe pipe : mPipes) {
                    pipe.setX(pipe.getX() - mSpeed);
                    if (pipe.getX() < -pipe.getmPipeWidth()) {
                        mNeedRemovePipes.add(pipe);
                        mRemovedPipe++;
                        continue;
                    }
                }
                mPipes.removeAll(mNeedRemovePipes);
                mNeedRemovePipes.clear();
                // Log.e("TAG", "现存管道数量：" + mPipes.size());
                // 地板移动
                mFloor.setX(mFloor.getX() - mSpeed);
                //鸟自由下落
                mTmpBirdDis += mAutoDownSpeed;
                mBird.setY(mBird.getY() + mTmpBirdDis);
                // 计算分数
                mGrade += mRemovedPipe;
                for (Pipe pipe : mPipes) {
                    if (pipe.getX() + pipe.getmPipeWidth() < mBird.getX()) {
                        mGrade++;
                    }
                }
                checkGameOver();
                break;
            case WAITTING:
                break;
            case STOP:
                if (mBird.getY() < mFloor.getY() - mBird.getHeight()) {
                    mTmpBirdDis += mAutoDownSpeed;
                    mBird.setY(mBird.getY() + mTmpBirdDis);
                } else {
                    mStatus = GameStatus.WAITTING;
                    initPos();
                }
                break;
        }
    }

    private void drawBg() {
        mCanvas.drawBitmap(mBg, null, mGamePanelRect, null);
    }

    private void drawPipe() {
        for (Pipe pipe : mPipes) {
            //pipe.setX(pipe.getX() - mSpeed);
            pipe.drawPipe(mCanvas);
        }
    }

    private void drawGrades() {
        String grade = mGrade + "";
        mCanvas.save();
        mCanvas.translate((mWidth - grade.length() * mSingleGradeWidth) / 2, mHeight / 15f);
        for (int i = 0; i < grade.length(); i++) {
            String str = grade.substring(i, i + 1);
            int num = Integer.valueOf(str);
            mCanvas.drawBitmap(mNumBitmap[num], null, mSingleNumRectF, null);
            mCanvas.translate(mSingleGradeWidth, 0);
        }
        mCanvas.restore();
    }

    private void checkGameOver() {
        if (mBird.getY() > mFloor.getY() - mBird.getHeight()) {
            mStatus = GameStatus.STOP;
        }
        for (Pipe pipe : mPipes) {
            if (mBird.getX() > pipe.getX() + pipe.getmPipeWidth()) {
                continue;
            }
            if (pipe.touchBird(mBird)) {
                mStatus = GameStatus.STOP;
                break;
            }
        }
    }

    //重置数据
    private void initPos() {
        mPipes.clear();
        mPipes.add(new Pipe(getContext(), mWidth, mHeight, bottomBitmap, topBitmap));
        mBird.setY(mHeight * 2 / 3);
        mTmpBirdDis = 0;
        mTmpMoveDistance = 0;
        mRemovedPipe = 0;
    }
}
