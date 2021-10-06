package com.raoshashwat.lab06;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainFragmenet extends Fragment
{
    ViewPager2 pager;
    int pos;

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
        new TabLayoutMediator(tabLayout, pager, (tab, pos) -> tab.setText("I am " + (pos + 1))).attach();

        Button button = view.findViewById(R.id.pressme);
        button.setText("Press " + (pos + 1));
    }
}
