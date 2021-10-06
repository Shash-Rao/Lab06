package com.raoshashwat.lab06;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{
    ViewPager2 pager;
    RecyclerView.Adapter fragStateAdapter;
    int NUM_ITEMS = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = findViewById(R.id.container);
        fragStateAdapter = new FragStateAdapter(this);
        pager.setAdapter(fragStateAdapter);
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