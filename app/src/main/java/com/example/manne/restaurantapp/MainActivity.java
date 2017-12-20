package com.example.manne.restaurantapp;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.manne.restaurantapp.PreferencesManager.restorans;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.buttonADD)
    Button buttonADD;

    static int REQUEST_CODE=1000;
    RestoranAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        adapter = new RestoranAdapter(this);

        adapter.setItems(generateList());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        recyclerView.setAdapter(adapter);

    }






    ArrayList<Restoran> generateList() {
//       RestoranData restoranData = new Gson().fromJson(restorans, RestoranData.class);
        RestoranData restoranData = PreferencesManager.getRestaurants(this);

        return restoranData.restaurants;

    }

    @OnClick(R.id.buttonADD)
    public void onClickADD(View view){
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivityForResult(intent, RESULT_OK);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_CODE && resultCode==RESULT_OK){
            adapter.setItems(generateList());
            adapter.notifyDataSetChanged();

        }
    }


}
