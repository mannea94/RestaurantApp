package com.example.manne.restaurantapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity2 extends AppCompatActivity {
    @BindView(R.id.ime)
    EditText ime;
    @BindView(R.id.lokacija)
    EditText lokacija;

    @BindView(R.id.buttonSAVE)
    Button buttonADD;
    @BindView(R.id.logo)
    EditText logo;
    @BindView(R.id.rating)
    EditText rating;

    RestoranData restoran;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        restoran = PreferencesManager.getRestaurants(this);
    }

    @OnClick(R.id.buttonSAVE)
    public void onClickSave(View view){
        Restoran restorani = new Restoran(logo.getText().toString(), ime.getText().toString(), lokacija.getText().toString(), rating.getText().toString());
       restoran.restaurants.add(restorani);
        PreferencesManager.addRestaurants(restoran, MainActivity2.this);
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();

    }

}
