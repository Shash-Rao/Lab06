package com.raoshashwat.lab06;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.media.MediaPlayer;
import android.os.Bundle;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity
{
    ViewPager2 pager;
    //ViewPager.OnPageChangeListener pageChangeListener;
    RecyclerView.Adapter fragStateAdapter;
    MediaPlayer mp;
    int NUM_ITEMS = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = findViewById(R.id.container);
        fragStateAdapter = new FragStateAdapter(this);
        pager.setAdapter(fragStateAdapter);
        mp = MediaPlayer.create(this, R.raw.swoosh);
        pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback()
        {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                mp.start();
                System.out.println("sound");
            }

            @Override
            public void onPageSelected(int position)
            {
                super.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state)
            {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    private class FragStateAdapter extends FragmentStateAdapter
    {

        public FragStateAdapter(@NonNull FragmentActivity fragmentActivity)
        {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position)
        {
            return MainFragmenet.newInstance(pager, position);
        }

        @Override
        public int getItemCount()
        {
            return NUM_ITEMS;
        }
    }
}