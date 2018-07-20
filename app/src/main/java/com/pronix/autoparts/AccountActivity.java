package com.pronix.autoparts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.pronix.autoparts.renderer.OrdersListAdapter;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Account");
    }

    public void movetoAddress(View view)
    {
        startActivity(new Intent(this, PrefileAddressActivity.class));
    }

    public void movetoCard(View view)
    {
        startActivity(new Intent(this, ProfileCardsActivity.class));
    }
    public void movetoLoginSecurity(View view)
    {
        startActivity(new Intent(this, ProfileActivity.class));
    }

    public void movetoYourOrders(View view)
    {
        startActivity(new Intent(this, OrdersActivity.class));
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
