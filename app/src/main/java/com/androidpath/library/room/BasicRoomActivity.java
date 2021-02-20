package com.androidpath.library.room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.androidpath.R;
import com.androidpath.library.room.model.Product;
import com.androidpath.library.room.ui.ProductFragment;
import com.androidpath.library.room.ui.ProductListFragment;

//BasicSample
//https://github.com/android/architecture-components-samples
public class BasicRoomActivity extends AppCompatActivity {


    public static void show(Context context){
        context.startActivity(new Intent(context,BasicRoomActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_room_basic);
        // Add product list fragment if this is first creation
        if (savedInstanceState == null) {
            ProductListFragment fragment = new ProductListFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, fragment, ProductListFragment.TAG).commit();
        }
    }

    /** Shows the product detail fragment */
    public void show(Product product) {

        ProductFragment productFragment = ProductFragment.forProduct(product.getId());

        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack("product")
                .replace(R.id.fragment_container,
                        productFragment, null).commit();
    }
}
