package com.androidpath.view.widget.custom.customview1;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/18 15:24 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class PieData {
    int color;
    int leftAngle;
    int rightAngle;
    int colorIndex;
    int per;
    float perCentage;
    float angle;

    public PieData(int colorIndex, int per) {
        this.colorIndex = colorIndex;
        this.per = per;
    }

    public void setColorIndex(int colorIndex) {
        this.colorIndex = colorIndex;
    }

    public int getPer() {
        return per;
    }

    public int getColorIndex() {
        return colorIndex;
    }

    public void setPer(int per) {
        this.per = per;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getAngle() {
        return angle;
    }
}
