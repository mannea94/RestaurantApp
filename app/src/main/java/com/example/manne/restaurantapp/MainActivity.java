package com.example.manne.restaurantapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.manne.restaurantapp.Adapter.RestoranAdapter;
import com.example.manne.restaurantapp.Listener.OnRowClickListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.buttonADD)
    ImageButton buttonADD;

    @BindView(R.id.textWelcome)
    TextView text;

    static int REQUEST_CODE=1000;
    RestoranAdapter adapter;

    RestoranData data;

    MediaPlayer mediaPlayer;
    MediaPlayer mediaPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mediaPlayer = MediaPlayer.create(this, R.raw.macdonaldsoff);
        mediaPlayer2=MediaPlayer.create(this, R.raw.voved);
        mediaPlayer2.start();

        adapter = new RestoranAdapter(this, new OnRowClickListener() {
            @Override
            public void onRowClick(Restoran restoranData, int position) {
                Intent intent = new Intent(MainActivity.this, RestoranDetailsActivity.class);
                intent.putExtra("EXTRA", restoranData);
                intent.putExtra("POZICIJA", position);
                if(restoranData.getName().equals("McDonald’s")) {
                    mediaPlayer2.stop();
                    mediaPlayer.start();
                }
                startActivity(intent);
            }

            @Override
            public void onLongRowClick(final Restoran restoran, final int position) {
                final AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
//                myBuilder.setTitle("Remove restaurant");
                myBuilder.setMessage("Are you sure to delete this restaurant?");
                myBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        data=PreferencesManager.getRestaurants(MainActivity.this);
                        data.restaurants.remove(position);
                        PreferencesManager.addRestaurants(data, MainActivity.this);
                        adapter.setItems(generateList());
                        adapter.notifyDataSetChanged();
                    }
                });
                myBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                myBuilder.create().show();
            }
        });



        text.setText("                                                   Добредојдовте во комплексот ресторани креирани по ваша желба!");
        text.setSelected(true);


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        recyclerView.setAdapter(adapter);



    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.setItems(generateList());
        adapter.notifyDataSetChanged();
    }

    ArrayList<Restoran> generateList() {

        RestoranData restoranData = PreferencesManager.getRestaurants(this);

        return restoranData.restaurants;

    }

    @OnClick(R.id.buttonADD)
    public void onClickADD(View view){
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_CODE && resultCode==RESULT_OK){
            adapter.setItems(generateList());
            adapter.notifyDataSetChanged();
        }

    }


}
