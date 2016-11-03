package com.androidpath.imageviewtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

import com.androidpath.R;

public class MainActivity33 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main33);

        ImageView imageView = (ImageView) findViewById(R.id.image_view);
        ImageView imageView2 = (ImageView) findViewById(R.id.image_2);

        imageView2.setImageResource(R.drawable.wallet_base_btn_pressed_on33);
        imageView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(MainActivity33.this, "图片按钮点击", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
