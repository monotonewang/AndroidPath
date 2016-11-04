package com.androidpath.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.androidpath.R;
import com.androidpath.actiivty.activityjump50.MainActivity50;
import com.androidpath.actiivty.activitypassvalue54.MainActivity54;
import com.androidpath.controls.buttonbgcolor40.MainActivity40;
import com.androidpath.controls.buttonselector30.ButtonSelectorActivtiy3;
import com.androidpath.controls.checkradio41.MainActivity41;
import com.androidpath.controls.clickreponse31.ButtonTestActivity31;
import com.androidpath.controls.edittextdemo32.MainActivity32;
import com.androidpath.controls.imageviewtest.MainActivity33;
import com.androidpath.controls.layoutdemo2.LayoutActivity2;
import com.androidpath.controls.spinner.spinnerdemo42.MainActivity42;
import com.androidpath.controls.spinner.spinnerdemo43.MainActivity43;
import com.androidpath.controls.spinner.spinnersimpleAdapter44.MainActivity44;
import com.androidpath.controls.viewtest34.MainActivity34;
import com.androidpath.widget.view.HandActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layoutdemo2:
                startActivity(new Intent(MainActivity.this, LayoutActivity2.class));
                break;
            case R.id.buttonselectordemo3:
                startActivity(new Intent(MainActivity.this, ButtonSelectorActivtiy3.class));
                break;
            case R.id.buttontestactivity31:
                startActivity(new Intent(MainActivity.this, ButtonTestActivity31.class));
                break;
            case R.id.edittextdemo32:
                startActivity(new Intent(MainActivity.this, MainActivity32.class));
                break;
            case R.id.imageviewTest33:
                startActivity(new Intent(MainActivity.this, MainActivity33.class));
                break;
            case R.id.viewTest34:
                startActivity(new Intent(MainActivity.this, MainActivity34.class));
                break;
            case R.id.handview:
                startActivity(new Intent(MainActivity.this, HandActivity.class));
                break;
            case R.id.buttonbgcolor40:
                startActivity(new Intent(MainActivity.this, MainActivity40.class));
                break;
            case R.id.checkRadio41:
                startActivity(new Intent(MainActivity.this, MainActivity41.class));
                break;
            case R.id.spinnerDemo42:
                startActivity(new Intent(MainActivity.this, MainActivity42.class));
                break;
            case R.id.spinnerDemo43:
                startActivity(new Intent(MainActivity.this, MainActivity43.class));
                break;
            case R.id.spinnerSimpleAdapter44:
                startActivity(new Intent(MainActivity.this, MainActivity44.class));
                break;
            case R.id.activityPassValue50:
                startActivity(new Intent(MainActivity.this, MainActivity54.class));
                break;
            case R.id.activityJump50:
                startActivity(new Intent(MainActivity.this, MainActivity50.class));
                break;

            default:

                break;

        }
    }
}
