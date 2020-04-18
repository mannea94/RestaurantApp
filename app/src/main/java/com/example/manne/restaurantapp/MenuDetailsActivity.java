package com.example.manne.restaurantapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MenuDetailsActivity extends AppCompatActivity {

    @BindView(R.id.cena)
    EditText cena;

    @BindView(R.id.hrana)
    EditText hrana;

    @BindView(R.id.link)
    EditText link;

    @BindView(R.id.checkBox)
    CheckBox checkBox;

    @BindView(R.id.buttonSAVE)
    ImageButton buttonSave;

    ArrayList<Menu> meni;

//    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_details);
        ButterKnife.bind(this);

//        mediaPlayer=MediaPlayer.create(this, R.raw.ednatequila);

        link.setText("http://images.media-allrecipes.com/userphotos/960x960/3757723.jpg");


    }



    @OnClick(R.id.buttonSAVE)
    public void onClickSave(View view){
        if(!link.getText().toString().isEmpty() && !hrana.getText().toString().isEmpty() && !cena.getText().toString().isEmpty()) {
            Menu menus = new Menu(link.getText().toString(), hrana.getText().toString(), cena.getText().toString(), checkBox.isChecked());
            Intent intent = new Intent();
            intent.putExtra("Menu", menus);
            setResult(RESULT_OK, intent);
//            mediaPlayer.start();
            finish();
        }
        else{
            Toast.makeText(MenuDetailsActivity.this, "Please fill whole menu", Toast.LENGTH_SHORT).show();
        }
    }




}
