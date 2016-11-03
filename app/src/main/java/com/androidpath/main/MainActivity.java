package com.androidpath.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.androidpath.R;
import com.androidpath.buttonselector30.ButtonSelectorActivtiy3;
import com.androidpath.clickreponse31.ButtonTestActivity31;
import com.androidpath.edittextdemo32.MainActivity32;
import com.androidpath.widget.view.HandActivity;
import com.androidpath.imageviewtest.MainActivity33;
import com.androidpath.layoutdemo2.LayoutActivity2;
import com.androidpath.viewtest34.MainActivity34;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layoutdemo2:
                Intent intent2 = new Intent(MainActivity.this, LayoutActivity2.class);
                startActivity(intent2);
                break;
            case R.id.buttonselectordemo3:
                Intent intent3 = new Intent(MainActivity.this, ButtonSelectorActivtiy3.class);
                startActivity(intent3);
                break;
            case R.id.buttontestactivity31:
                Intent intent31 = new Intent(MainActivity.this, ButtonTestActivity31.class);
                startActivity(intent31);
                break;
            case R.id.edittextdemo32:
                Intent intent32 = new Intent(MainActivity.this, MainActivity32.class);
                startActivity(intent32);
                break;
            case R.id.imageviewTest33:
                Intent intent33 = new Intent(MainActivity.this, MainActivity33.class);
                startActivity(intent33);
                break;
            case R.id.viewTest34:
                Intent intent34 = new Intent(MainActivity.this, MainActivity34.class);
                startActivity(intent34);
                break;
            case R.id.handview:
                Intent handview = new Intent(MainActivity.this, HandActivity.class);
                startActivity(handview);
                break;

            default:

                break;

        }
    }
}
