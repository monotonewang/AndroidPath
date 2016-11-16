package com.androidpath.activity.aalayout.layoutdemo2;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.androidpath.R;


public class LayoutActivity2 extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private Fragment layout2Fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layoutdemo2);
        fragmentManager = getFragmentManager();
//        layout2Fragment = new Layout2Fragment();
        layout2Fragment = Layout2Fragment.getInstance(R.layout.linear_layout2, 0);
        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.layoutdemo2Fargment, layout2Fragment);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings2) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("CommitTransaction")
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layoutdemo2LinearLayout:
                transaction = fragmentManager.beginTransaction();
                transaction.detach(layout2Fragment);
                Fragment layout2Fragment1 = Layout2Fragment.getInstance(R.layout.linear_layout2, 1);
//                transaction.add(R.id.layoutdemo2Fargment, layout2Fragment1);
                transaction.replace(R.id.layoutdemo2Fargment, layout2Fragment1);
                transaction.commit();
                break;
            case R.id.layoutdemo2LinearLayout2:
                transaction = fragmentManager.beginTransaction();
                transaction.detach(layout2Fragment);
                Fragment layout2Fragment2 = Layout2Fragment.getInstance(R.layout.linear_layout_2, 2);
//                transaction.add(R.id.layoutdemo2Fargment, layout2Fragment2);
                transaction.replace(R.id.layoutdemo2Fargment, layout2Fragment2);
                transaction.commit();
                break;
            case R.id.layoutdemo2LinearBaseLine:
                transaction = fragmentManager.beginTransaction();
                transaction.detach(layout2Fragment);
                Fragment layout2Fragment3 = Layout2Fragment.getInstance(R.layout.linear_baseline_layout2, 3);
//                transaction.add(R.id.layoutdemo2Fargment, layout2Fragment3);
                transaction.replace(R.id.layoutdemo2Fargment, layout2Fragment3);
                transaction.commit();
                break;
            case R.id.layoutdemo2LinearRelative:
                transaction = fragmentManager.beginTransaction();
                transaction.detach(layout2Fragment);
                Fragment layout2Fragment4 = Layout2Fragment.getInstance(R.layout.linear_rel_layout2, 4);
//                transaction.add(R.id.layoutdemo2Fargment, layout2Fragment4);
                transaction.replace(R.id.layoutdemo2Fargment, layout2Fragment4);
                transaction.commit();
                break;
            case R.id.layoutdemo2RelativeLayout:
                transaction = fragmentManager.beginTransaction();
                transaction.detach(layout2Fragment);
                Fragment layout2Fragment5 = Layout2Fragment.getInstance(R.layout.rela_layout2, 5);
//                transaction.add(R.id.layoutdemo2Fargment, layout2Fragment5);
                transaction.replace(R.id.layoutdemo2Fargment, layout2Fragment5);
                transaction.commit();
                break;
            case R.id.layoutdemo2FrameLayout:
                transaction = fragmentManager.beginTransaction();
                transaction.detach(layout2Fragment);
                Fragment layout2Fragment6 = Layout2Fragment.getInstance(R.layout.frame_layout2, 6);
//                transaction.add(R.id.layoutdemo2Fargment, layout2Fragment6);
                transaction.replace(R.id.layoutdemo2Fargment, layout2Fragment6);
                transaction.commit();
                break;
            case R.id.layoutdemo2GridLayout:
                transaction = fragmentManager.beginTransaction();
                transaction.detach(layout2Fragment);
                Fragment layout2Fragment7 = Layout2Fragment.getInstance(R.layout.grid_layout2, 7);
//                transaction.add(R.id.layoutdemo2Fargment, layout2Fragment7);
                transaction.replace(R.id.layoutdemo2Fargment, layout2Fragment7);
                transaction.commit();
                break;
        }
    }
}
