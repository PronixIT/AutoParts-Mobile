package com.pronix.autoparts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class WalletActivity extends AppCompatActivity {
    RadioGroup rg_WalletGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Wallet");
        inializeControls();
    }

    public void moveConfirmationScreen(View view)
    {
        startActivity(new Intent(this, ConfirmationActivity.class));
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    public void inializeControls()
    {
        rg_WalletGroup = (RadioGroup) findViewById(R.id.rg_PaymentWalletGroup);
        rg_WalletGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rb_Paytm)
                {
                    ((EditText) findViewById(R.id.et_Paytm)).setVisibility(View.VISIBLE);
                    ((EditText) findViewById(R.id.et_Freecharge)).setVisibility(View.GONE);
                    ((EditText) findViewById(R.id.et_Mobikwik)).setVisibility(View.GONE);
                    ((EditText) findViewById(R.id.et_Amazon)).setVisibility(View.GONE);
                }
                else if(checkedId == R.id.rb_Freecharge)
                {
                    ((EditText) findViewById(R.id.et_Freecharge)).setVisibility(View.VISIBLE);
                    ((EditText) findViewById(R.id.et_Paytm)).setVisibility(View.GONE);
                    ((EditText) findViewById(R.id.et_Mobikwik)).setVisibility(View.GONE);
                    ((EditText) findViewById(R.id.et_Amazon)).setVisibility(View.GONE);
                }
                else if(checkedId == R.id.rb_Mobikwik)
                {
                    ((EditText) findViewById(R.id.et_Mobikwik)).setVisibility(View.VISIBLE);
                    ((EditText) findViewById(R.id.et_Freecharge)).setVisibility(View.GONE);
                    ((EditText) findViewById(R.id.et_Paytm)).setVisibility(View.GONE);
                    ((EditText) findViewById(R.id.et_Amazon)).setVisibility(View.GONE);
                }
                else if(checkedId == R.id.rb_Amazon)
                {
                    ((EditText) findViewById(R.id.et_Amazon)).setVisibility(View.VISIBLE);
                    ((EditText) findViewById(R.id.et_Mobikwik)).setVisibility(View.GONE);
                    ((EditText) findViewById(R.id.et_Freecharge)).setVisibility(View.GONE);
                    ((EditText) findViewById(R.id.et_Paytm)).setVisibility(View.GONE);
                }
            }
        });
    }
}
