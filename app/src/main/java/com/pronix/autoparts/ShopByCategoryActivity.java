package com.pronix.autoparts;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;

import com.pronix.autoparts.common.Constants;
import com.pronix.autoparts.renderer.ModelListAdapter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ShopByCategoryActivity extends BaseActivity {

    private ExpandableListView modelList;
    private List<String> listMake;
    private HashMap<String, List<String>> listModel;
    public ModelListAdapter listAdapter;
    private int lastExpandedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        LayoutInflater inflater = (LayoutInflater) this
//                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View contentView = inflater.inflate(R.layout.activity_shop_by_category, null, false);
//        drawer.addView(contentView, 0);
        setView(R.layout.activity_shop_by_category, this);

        modelList = findViewById(R.id.modelList);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Makers & Models");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // preparing list data
        prepareListData();

        listAdapter = new ModelListAdapter(this, listMake, listModel);

        // setting list adapter
        modelList.setAdapter(listAdapter);

        modelList.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                if (lastExpandedPosition != -1
                        && groupPosition != lastExpandedPosition) {
                    modelList.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = groupPosition;
            }
        });
    }

    private void prepareListData() {
        listMake = Arrays.asList(getResources().getStringArray(R.array.make));
        listModel = new HashMap<>();
        listModel.put(listMake.get(0), Arrays.asList(getResources().getStringArray(R.array.hero)));
        listModel.put(listMake.get(1),Arrays.asList(getResources().getStringArray(R.array.audi)));
        listModel.put(listMake.get(2),Arrays.asList(getResources().getStringArray(R.array.bmw)));
        listModel.put(listMake.get(3),Arrays.asList(getResources().getStringArray(R.array.datsun)));
        listModel.put(listMake.get(4),Arrays.asList(getResources().getStringArray(R.array.honda)));
        listModel.put(listMake.get(5),Arrays.asList(getResources().getStringArray(R.array.honda_bikes)));
        listModel.put(listMake.get(6),Arrays.asList(getResources().getStringArray(R.array.hyundai)));
        listModel.put(listMake.get(7),Arrays.asList(getResources().getStringArray(R.array.jeep)));
        listModel.put(listMake.get(8),Arrays.asList(getResources().getStringArray(R.array.nissan)));
        listModel.put(listMake.get(9),Arrays.asList(getResources().getStringArray(R.array.toyota)));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Constants.SEARCHHINTNAME = "Makers & Models";
    }
}
