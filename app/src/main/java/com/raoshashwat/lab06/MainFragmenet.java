package com.raoshashwat.lab06;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainFragmenet extends Fragment
{
    ViewPager2 pager;
    int pos;
    ImageView imageDisplay;
    String[] planets;

    public static Fragment newInstance(ViewPager2 pager, int pos)
    {
        MainFragmenet fragmenet = new MainFragmenet();
        fragmenet.pager = pager;
        fragmenet.pos = pos;
        return fragmenet;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        TabLayout tabLayout = getActivity().findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabLayout, pager, (tab, pos) -> tab.setText("" + (pos + 1))).attach();

        planets = getResources().getStringArray(R.array.planets);

        Button button = view.findViewById(R.id.pressme);
        button.setText(planets[pos].toUpperCase());

        int resId = getResources().getIdentifier(planets[pos], "drawable", getActivity().getPackageName());
        imageDisplay = view.findViewById(R.id.image_display);
        imageDisplay.setImageResource(resId);
    }
}
