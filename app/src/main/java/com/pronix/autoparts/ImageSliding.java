package com.pronix.autoparts;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.pronix.autoparts.renderer.ViewPagerAdapter;

import java.util.Timer;
import java.util.TimerTask;

public class ImageSliding extends AppCompatActivity implements ViewPager.OnPageChangeListener{
    ViewPager viewPager;
    LinearLayout ll_Dots;
    int noOfDots;
    ViewPagerAdapter mAdapter;
    private ImageView[] dots;
    private int[] mImageResources = {
            R.mipmap.images1,
            R.mipmap.img11,
            R.mipmap.img12,
            R.mipmap.img13};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_sliding);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        ll_Dots = (LinearLayout) findViewById(R.id.viewPagerCountDots);

        noOfDots = 0;

        mAdapter = new ViewPagerAdapter(this, mImageResources);
        viewPager.setAdapter(mAdapter);
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(this);
        setUiPageViewController();
    }

    private void setUiPageViewController() {

        noOfDots = mAdapter.getCount();
        dots = new ImageView[noOfDots];

        for (int i = 0; i < noOfDots; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(4, 0, 4, 0);

            ll_Dots.addView(dots[i], params);
        }

        dots[0].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int position) {
        for (int i = 0; i < noOfDots; i++) {
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));
        }

        dots[position].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));

    }

    public class MyTimerTask extends TimerTask
    {

        @Override
        public void run() {

        }
    }
}
