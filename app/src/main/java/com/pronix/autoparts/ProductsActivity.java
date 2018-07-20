package com.pronix.autoparts;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.pronix.autoparts.common.Constants;
import com.pronix.autoparts.renderer.MyProductsAdapter;

public class ProductsActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private MyProductsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView(R.layout.activity_products, this);
//        TextView tv_Title = (TextView) findViewById(R.id.tv_Title);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        if (getIntent().getStringExtra("PARTS") != null) {

            getSupportActionBar().setTitle(Constants.MAKER + " > " + getIntent().getStringExtra("PARTS"));
            Constants.SEARCHHINTNAME = Constants.MAKER + " > " + getIntent().getStringExtra("PARTS");
//            tv_Title.setText(Constants.MAKER + " > " + getIntent().getStringExtra("PARTS"));
        } else {
            getSupportActionBar().setTitle(R.string.app_name);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        recyclerView = findViewById(R.id.recyclerView);

        int numberOfColumns = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        adapter = new MyProductsAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (getIntent().getStringExtra("PARTS") != null) {
            Constants.SEARCHHINTNAME = Constants.MAKER + " > " + getIntent().getStringExtra("PARTS");
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
