package com.pronix.autoparts;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Payment");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.but_Pay:
                startActivity(new Intent(this, ConfirmationActivity.class));
                break;
        }

    }

    public void movetoCardDetails(View view)
    {
        startActivity(new Intent(this, PaymentDetails.class));
//        Toast.makeText(this, "Click", Toast.LENGTH_SHORT).show();
    }

    public void movetWalletDetails(View view)
    {
        startActivity(new Intent(this, WalletActivity.class));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
