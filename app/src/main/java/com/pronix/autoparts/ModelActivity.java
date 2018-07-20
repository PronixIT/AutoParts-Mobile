package com.pronix.autoparts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;

import com.pronix.autoparts.common.Constants;

public class ModelActivity extends BaseActivity {

    private ListView listView;
    private String model;
    private String[] models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView(R.layout.activity_model, this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Models");


        listView = findViewById(R.id.listView);

        model = getIntent().getExtras().getString("model");

        switch (model) {
            case "hero":
                models = getResources().getStringArray(R.array.hero);
                break;
            case "bmw":
                models = getResources().getStringArray(R.array.bmw);
                break;
            case "datsun":
                models = getResources().getStringArray(R.array.datsun);
                break;
            case "honda":
                models = getResources().getStringArray(R.array.honda);
                break;
            case "honda_bikes":
                models = getResources().getStringArray(R.array.honda_bikes);
                break;
            case "hyundai":
                models = getResources().getStringArray(R.array.hyundai);
                break;
            case "jeep":
                models = getResources().getStringArray(R.array.jeep);
                break;
            case "nissan":
                models = getResources().getStringArray(R.array.nissan);
                break;
            case "toyota":
                models = getResources().getStringArray(R.array.toyota);
                break;
            case "audi":
                models = getResources().getStringArray(R.array.audi);
                break;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, models);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent in = new Intent(ModelActivity.this, SampleActivity.class);
                in.putExtra("MODEL", models[position]);
                startActivity(in);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Constants.SEARCHHINTNAME = "Models";
    }
}
