package com.longluo.android.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;
import com.longluo.android.R;
import com.longluo.android.ui.fragment.DetailFragment;
import com.longluo.android.ui.fragment.MasterFragment;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements MasterFragment.Callbacks {
    private static final String LOG_TAG = "MainActivity";

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.toolbar)
    Toolbar toolBar;

    @BindView(R.id.nv_drawer)
    NavigationView navigationView;

    ActionBarDrawerToggle actionBarDrawerToggle;

    private String[] mNavigationDrawerItemTitles;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setupToolbar(toolBar);
        mNavigationDrawerItemTitles = getResources().getStringArray(R.array.navigation_drawer_items_array);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        // pass the Open and Close toggle for the drawer layout listener to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        init();
    }

    private void init() {
        // Setup drawer view
        setupDrawerContent(navigationView);

        // insert detail fragment into detail container
        DetailFragment detailFragment = DetailFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.nv_drawer, detailFragment, "DETAIL")
                .commit();

        // insert master fragment into master container (i.e. nav view)
        MasterFragment masterFragment = MasterFragment.newInstance();
        fragmentManager.beginTransaction()
                .add(R.id.flContent, masterFragment, "MASTER")
                .commit();
    }

    private void setupToolbar(Toolbar toolbar) {
//        setSupportActionBar(toolBar);
        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
//                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    /**
     * function to implement the item click listener callback to open and
     * close the navigation drawer when the icon is clicked.
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;

            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMasterItemClicked(int masterItemId) {
        Log.d(LOG_TAG, "onMasterItemClicked id=" + masterItemId);

        DetailFragment detailFragment = (DetailFragment) getSupportFragmentManager()
                .findFragmentByTag("DETAIL");
        detailFragment.onMasterItemClicked(masterItemId);

        // Close the navigation drawer
        if (drawerLayout != null) {
            drawerLayout.closeDrawers();
        }
    }

    private void selectItem(int position) {
        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new DetailFragment();
                break;

            case 1:
//                fragment = new GreenDaoFragment();
                break;

            case 2:
                fragment = new MasterFragment();
                break;

            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

//            mDrawerList.setItemChecked(position, true);
//            mDrawerList.setSelection(position);
            setTitle(mNavigationDrawerItemTitles[position]);
//            drawerLayout.closeDrawer(mDrawerList);
        } else {
            Log.e(LOG_TAG, "Error in creating fragment");
        }
    }

}
