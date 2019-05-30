package com.androidpath.architecture.meterial;


import android.os.Bundle;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

import com.androidpath.R;

public class MeterialActivity extends AppCompatActivity implements OnClickListener {

	DrawerLayout drawerLayout;
	CollapsingToolbarLayout collapsingToolbarLayout;
	Toolbar toolbar;
	TabLayout tabLayout;
//	FloatingActionButton fab;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_meterial);
		
		setupNavigationView();
		setupToolbar();
//		setupTablayout();
		setupCollapsingToolbarLayout();
//		setupFab();

	}
	

	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
            	if(drawerLayout != null)
            		drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
	
	private void setupNavigationView(){
		
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
	}
	
	private void setupCollapsingToolbarLayout(){
		
		collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
		if(collapsingToolbarLayout != null){
			collapsingToolbarLayout.setTitle(toolbar.getTitle());
			//collapsingToolbarLayout.setCollapsedTitleTextColor(0xED1C24);	
			//collapsingToolbarLayout.setExpandedTitleColor(0xED1C24);
		}
	}
	
//	private void setupTablayout(){
//
//		tabLayout = (TabLayout) findViewById(R.id.tabLayout);
//
//		if(tabLayout == null)
//			return;
//
//		tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
//		tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
//		tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
//		tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));
//		tabLayout.addTab(tabLayout.newTab().setText("Tab 4"));
//	}

//	private void setupFab(){
//		fab = (FloatingActionButton) findViewById(fab);
//		if(fab != null)
//			fab.setOnClickListener(this);
//	}
	//ss
	private void setupToolbar(){
		toolbar = (Toolbar) findViewById(R.id.toolbar);
		if(toolbar != null)
			setSupportActionBar(toolbar);

		// Show menu icon
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public void onClick(View view) {
		
//		if(view.getId() == R.id.fab){
//
//			Snackbar
//			  .make(findViewById(R.id.coordinatorLayout), "This is Snackbar", Snackbar.LENGTH_LONG)
//			  .setAction("Action", this)
//			  .show(); // Don�t forget to show!
//		}
	}
}
