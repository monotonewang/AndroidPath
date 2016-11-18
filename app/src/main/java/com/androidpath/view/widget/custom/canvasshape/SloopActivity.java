package com.androidpath.view.widget.custom.canvasshape;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.androidpath.activity.aabase.BaseActivity;

import java.util.ArrayList;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/17 16:51 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class SloopActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//    SloopView sloopView = new SloopView(this);
//    setContentView(sloopView);
        int a = 20;
        int b = 30;
        PieView pieView = new PieView(this);
        setContentView(pieView);
        ArrayList<PieData> arrayList = new ArrayList<>();
        arrayList.add(new PieData((int) (Math.random() * a + 1), (int) (Math.random() * b + 1)));
        arrayList.add(new PieData((int) (Math.random() * a + 1), (int) (Math.random() * b + 1)));//第一个是颜色种类，第二个占有比例
        arrayList.add(new PieData((int) (Math.random() * a + 1), (int) (Math.random() * b + 1)));
        arrayList.add(new PieData((int) (Math.random() * a + 1), (int) (Math.random() * b + 1)));
        arrayList.add(new PieData((int) (Math.random() * a + 1), (int) (Math.random() * b + 1)));
//        arrayList.add(new PieData((int) (Math.random() * a + 1), (int) (Math.random() * b + 1)));
//        arrayList.add(new PieData((int) (Math.random() * a + 1), (int) (Math.random() * b + 1)));
//        arrayList.add(new PieData((int) (Math.random() * a + 1), (int) (Math.random() * b + 1)));
//        arrayList.add(new PieData((int) (Math.random() * a + 1), (int) (Math.random() * b + 1)));
//        arrayList.add(new PieData((int) (Math.random() * a + 1), (int) (Math.random() * b + 1)));
//        arrayList.add(new PieData((int) (Math.random() * a + 1), (int) (Math.random() * b + 1)));
//        arrayList.add(new PieData((int) (Math.random() * a + 1), (int) (Math.random() * b + 1)));
//        arrayList.add(new PieData((int) (Math.random() * a + 1), (int) (Math.random() * b + 1)));
        pieView.setDatas(arrayList);
    }
}

