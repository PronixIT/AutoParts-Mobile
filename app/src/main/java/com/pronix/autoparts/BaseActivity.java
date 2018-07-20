package com.pronix.autoparts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.pronix.autoparts.common.Constants;

public abstract class BaseActivity extends AppCompatActivity {

    Activity activity;

    public void setView(int layoutResID, Activity activity) {
        this.activity = activity;
        setContentView(layoutResID);
    }

    @Override
    public void setContentView(int layoutResID) {
        final DrawerLayout fullView = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_main, null);
        FrameLayout activityContainer = (FrameLayout) fullView.findViewById(R.id.activity_content);
        View v = getLayoutInflater().inflate(layoutResID, activityContainer, true);
        super.setContentView(fullView);
        final NavigationView navigationView = (NavigationView) fullView.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        if (activity instanceof MainActivity)
                            fullView.closeDrawers();
                        else {
                            Intent i = new Intent(getApplicationContext(), MainActivity.class);
                            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            activity.startActivity(i);
                            finish();
                        }
                        fullView.closeDrawers();
                        return true;
                    case R.id.nav_category:
                        if (activity instanceof ShopByCategoryActivity)
                            fullView.closeDrawers();
                        else {
                            activity.startActivity(new Intent(getApplicationContext(), ShopByCategoryActivity.class));
                            if (activity instanceof MainActivity) {

                            } else
                                finish();
                        }
                        fullView.closeDrawers();
                        return true;

                    case R.id.nav_orders:
                        if (!(activity instanceof OrdersActivity)) {
                            activity.startActivity(new Intent(getApplicationContext(), OrdersActivity.class));
                            if (!(activity instanceof MainActivity))
                                finish();
                        }
                        fullView.closeDrawers();
                        return true;
                    case R.id.nav_account:
                        if (!(activity instanceof AccountActivity)) {
                            activity.startActivity(new Intent(getApplicationContext(), AccountActivity.class));
                            if (!(activity instanceof MainActivity))
                                finish();
                        }
                        fullView.closeDrawers();
                        return true;

//                    case R.id.nav_settings:
//                        if (!(activity instanceof ImageSliding)) {
//                            activity.startActivity(new Intent(getApplicationContext(), ImageSliding.class));
//                            if (!(activity instanceof MainActivity))
//                                finish();
//                        }
//                        fullView.closeDrawers();
//                        return true;

                    default:
                        fullView.closeDrawers();
                        return false;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_cart) {
            startActivity(new Intent(this, AddCartActivity.class));
        } else if (id == R.id.action_search) {
            Intent in = new Intent(this, SearchActivity.class);
            if (activity instanceof MainActivity) {
                in.putExtra("Hint", "Search");
            } else {
                in.putExtra("Hint", (!Constants.SEARCHHINTNAME.equals("")) ? "Search in " + Constants.SEARCHHINTNAME : "Search");
            }
            startActivity(in);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (activity instanceof MainActivity) {
            MenuItem item = menu.findItem(R.id.action_search);
            item.setVisible(false);
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
