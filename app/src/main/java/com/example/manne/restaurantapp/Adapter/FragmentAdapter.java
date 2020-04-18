package com.example.manne.restaurantapp.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.manne.restaurantapp.Fragment1;
import com.example.manne.restaurantapp.Menu;
import com.example.manne.restaurantapp.Restoran;

import java.util.ArrayList;

/**
 * Created by manne on 22.12.2017.
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    public FragmentAdapter(FragmentManager fm, ArrayList<Menu> _menuArrayList) {
        super(fm);
        menuArrayList=_menuArrayList;
    }

    public ArrayList<Menu> menuArrayList = new ArrayList<>();

    @Override
    public Fragment getItem(int position) {
        return Fragment1.newInstance(menuArrayList.get(position).link, menuArrayList.get(position).foodname, menuArrayList.get(position).price);
    }

    @Override
    public int getCount() {
        return menuArrayList.size();
    }
}
