package com.pronix.autoparts.renderer;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;

import com.pronix.autoparts.MainActivity;
import com.pronix.autoparts.MakerActivity;
import com.pronix.autoparts.ModelActivity;
import com.pronix.autoparts.R;

public class ImageAdapter extends BaseAdapter {

    private Context mContext;

    // Keep all Images in array
    private Integer[] mThumbIds = {
            R.drawable.hero,R.drawable.rsz_audi, R.drawable.rsz_bmw,
            R.drawable.rsz_datsun, R.drawable.rsz_honda,
            R.drawable.rsz_honda_bike, R.drawable.rsz_hyundai,
            R.drawable.rsz_jeep, R.drawable.rsz_nissan,
            R.drawable.rsz_toyota
    };

    private String[] models = {"hero","audi","bmw","datsun","honda","honda_bikes","hyundai","jeep","nissan","toyota"};

    public ImageAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setBackgroundResource(R.drawable.border);
        imageView.setLayoutParams(new GridView.LayoutParams(300,300));
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, ModelActivity.class);
                // passing array index
                i.putExtra("model", models[position]);
                mContext.startActivity(i);
            }
        });
        return imageView;
    }
}

