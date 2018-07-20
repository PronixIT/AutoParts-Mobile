package com.pronix.autoparts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.pronix.autoparts.common.Constants;
import com.pronix.autoparts.common.CustomItemClickListener;
import com.pronix.autoparts.renderer.SearchAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchActivity extends Activity {

    private RecyclerView.LayoutManager mLayoutManager;
    List<String> arrayList = new ArrayList<>();
    EditText et_Search;
    SearchAdapter adapter;
    RecyclerView rv_Search;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        et_Search = (EditText) findViewById(R.id.et_Search);
        rv_Search = (RecyclerView) findViewById(R.id.rv_Search);
        if (getIntent().getStringExtra("Hint") != null)
            et_Search.setHint(getIntent().getStringExtra("Hint"));
        et_Search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mLayoutManager = new LinearLayoutManager(this);
        rv_Search.setLayoutManager(mLayoutManager);
        arrayList.clear();
        adapter = new SearchAdapter(this, arrayList, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, String value, int position) {
                et_Search.setText(value);
                Intent in = new Intent(SearchActivity.this, SampleActivity.class);
                in.putExtra("MODEL", value);
                startActivity(in);
                Constants.SEARCHITEM = value;
            }
        });
        rv_Search.setAdapter(adapter);

//        arrayList = Arrays.asList(getResources().getStringArray(R.array.items));
        List<String> temp = Arrays.asList(getResources().getStringArray(R.array.bmw));
        arrayList.addAll(temp);
        temp = Arrays.asList(getResources().getStringArray(R.array.audi));
        arrayList.addAll(temp);
        temp = Arrays.asList(getResources().getStringArray(R.array.datsun));
        arrayList.addAll(temp);
        temp = Arrays.asList(getResources().getStringArray(R.array.hero));
        arrayList.addAll(temp);
        temp = Arrays.asList(getResources().getStringArray(R.array.honda));
        arrayList.addAll(temp);
        temp = Arrays.asList(getResources().getStringArray(R.array.honda_bikes));
        arrayList.addAll(temp);
        temp = Arrays.asList(getResources().getStringArray(R.array.hyundai));
        arrayList.addAll(temp);
        temp = Arrays.asList(getResources().getStringArray(R.array.hero));
        arrayList.addAll(temp);
        temp = Arrays.asList(getResources().getStringArray(R.array.toyota));
        arrayList.addAll(temp);
        temp = Arrays.asList(getResources().getStringArray(R.array.jeep));
        arrayList.addAll(temp);
        temp = Arrays.asList(getResources().getStringArray(R.array.nissan));
        arrayList.addAll(temp);
        et_Search.setText(Constants.SEARCHITEM);


    }

    public void clearText(View view) {
        et_Search.setText("");
        Constants.SEARCHITEM = "";
    }

    void filter(String text) {
        ArrayList<String> temp = new ArrayList();
        if (!text.equals("")) {
            for (String d : arrayList) {
                //or use .equal(text) with you want equal match
                //use .toLowerCase() for better matches
                if (d.toUpperCase().contains(text.toUpperCase())) {
                    temp.add(d);
                }
            }
        } else {
            Constants.SEARCHITEM = "";
        }
        //update recyclerview
        adapter.updateList(temp);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
