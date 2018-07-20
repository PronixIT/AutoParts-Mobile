package com.pronix.autoparts;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.pronix.autoparts.common.Constants;
import com.pronix.autoparts.renderer.CategoriesAdapter;
import com.pronix.autoparts.renderer.ImageAdapter;

public class MainActivity extends BaseActivity
        implements View.OnClickListener {
    RecyclerView rv_Categories;
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    protected DrawerLayout drawer;
    ViewFlipper mViewFlipper;
    private final GestureDetector detector = new GestureDetector(new SwipeGestureDetector());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView(R.layout.content_main, this);
        initializeControls();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);
        String html = "<i style = \"font-weight:50;\">Shop By</i> </br> <label>Category</label>";
        ((Button) findViewById(R.id.but_Search)).setText(Html.fromHtml(html));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        ((TextView) findViewById(R.id.Search)).setText(Constants.SEARCHITEM);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_cart) {
            startActivity(new Intent(this, AddCartActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }*/

//    @SuppressWarnings("StatementWithEmptyBody")
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        if (id == R.id.nav_orders) {
//            startActivity(new Intent(this, AddressActivity.class));
//        } else if (id == R.id.nav_category) {
//            startActivity(new Intent(this, ShopByCategoryActivity.class));
//        }
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }

    public void initializeControls() {
//        LinearLayout ll_Layout = (LinearLayout) findViewById(R.id.ll_Search);
//        rv_Categories = (RecyclerView) findViewById(R.id.rv_Categories);
//        String[] data = {"Engine", "Tyres", "Breaks", "Headlights", "Toolss", "Wheels"};
//        rv_Categories.setLayoutManager(new GridLayoutManager(this, 2));
//        CategoriesAdapter adapter = new CategoriesAdapter(this, data);
//        rv_Categories.setAdapter(adapter);

        mViewFlipper = (ViewFlipper) findViewById(R.id.view_flipper);
        mViewFlipper.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(final View view, final MotionEvent event) {
                detector.onTouchEvent(event);
                return true;
            }
        });
        mViewFlipper.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.left_in));
        mViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.left_out));

        GridView gridView = findViewById(R.id.gridview);

        // Instance of ImageAdapter Class
        gridView.setAdapter(new ImageAdapter(this));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Search:
            case R.id.ll_Search:
                Constants.SEARCHITEM = ((TextView) findViewById(R.id.Search)).getText().toString();
                startActivity(new Intent(this, SearchActivity.class));
                break;
            case R.id.but_Search:
                startActivity(new Intent(this, ShopByCategoryActivity.class));
                break;
            case R.id.signIn:
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
    }

    class SwipeGestureDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            try {
                // right to left swipe
                if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    mViewFlipper.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.left_in));
                    mViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.left_out));
                    mViewFlipper.showNext();
                    return true;
                } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
//                    mViewFlipper.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.right_in));
//                    mViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.right_out));
                    mViewFlipper.showPrevious();
                    return true;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return false;
        }
    }
}

