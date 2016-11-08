package com.androidpath.view.listview.gradview102;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.androidpath.R;

public class MainActivity102 extends Activity {

    private ImageView headImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main102);
        headImageView = (ImageView) findViewById(R.id.head_imageView);

    }

    public void clickSelect(View view) {
        //跳转到一个新界面，选择头像后返回
        Intent intent = new Intent(this, HeadImageActivity102.class);
//        startActivity(intent);
        startActivityForResult(intent, 0);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        int imageId = data.getIntExtra("selectedId", R.drawable.none);

        headImageView.setImageResource(imageId);
    }
}
