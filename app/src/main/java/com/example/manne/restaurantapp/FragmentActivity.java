package com.example.manne.restaurantapp;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.manne.restaurantapp.Adapter.FragmentAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentActivity extends AppCompatActivity {

    @BindView(R.id.pager)
    ViewPager pager;
    private int pozicija;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        ButterKnife.bind(this);

        pozicija = getIntent().getIntExtra("pozicija_gallery", 0);
        setUpViewPager(pager);


    }

    public void setUpViewPager(ViewPager upViewPager){
        FragmentAdapter adapter = new FragmentAdapter(this.getSupportFragmentManager(), getList());
        pager.setAdapter(adapter);
    }

    ArrayList <Menu> getList(){
        RestoranData menuData = PreferencesManager.getRestaurants(this);
        return menuData.restaurants.get(pozicija).getMenu();
    }



}
