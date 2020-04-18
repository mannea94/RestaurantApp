package com.example.manne.restaurantapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.manne.restaurantapp.Adapter.MenuAdapter;
import com.example.manne.restaurantapp.Adapter.RestoranAdapter;
import com.example.manne.restaurantapp.Listener.OnRowClickListener;
import com.example.manne.restaurantapp.Listener.OnRowMenuClickListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RestoranDetailsActivity extends AppCompatActivity {
    @BindView(R.id.imeRES)
    TextView imeRES;
    @BindView(R.id.mesto)
    TextView mesto;
    @BindView(R.id.rejting)
    TextView rejting;
    @BindView(R.id.imageView)
    ImageView imageView;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.buttonADD)
    ImageButton buttonADD;

    @BindView(R.id.currentRestaurant)
    LinearLayout currentRestaurant;

    @BindView(R.id.buttonInfo)
    ImageButton buttonInfo;

    @BindView(R.id.textTopic)
    TextView textTopic;

    Restoran data;

    MenuAdapter adapter;

    Menu meni;
    ArrayList<Menu> menuData;

    RestoranData restoranData;

    @BindView(R.id.buttonGallery)
    ImageButton buttonGallery;



    String url;
    String ime;

    static int CODE=1002;
    static int CODE_EDIT=1004;
    static int CODE_EDIT_MENU=1006;
    static int CODE_REMOVE=1008;
    int pozicija;

//    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ButterKnife.bind(this);

//        mediaPlayer = MediaPlayer.create(this, R.raw.dajtequila);


        restoranData=PreferencesManager.getRestaurants(RestoranDetailsActivity.this);
        adapter = new MenuAdapter(this, new OnRowMenuClickListener() {
            @Override
            public void onRowClick(final Menu menuData, int _position) {
                Intent intent = new Intent(RestoranDetailsActivity.this, MenuActivity.class);
                intent.putExtra("EXTRA_MENU", menuData);
                intent.putExtra("POZICIJA_MENU", _position);
                intent.putExtra("POZICIJA_RESTORAN", pozicija);
                startActivityForResult(intent, CODE_EDIT_MENU);
            }

            @Override
            public void onLongRowClick(final Menu menuD, final int position) {
                final AlertDialog.Builder myBuilder = new AlertDialog.Builder(RestoranDetailsActivity.this);
//                myBuilder.setTitle("Remove menu");
                myBuilder.setMessage("Are you sure to delete this item?");
                myBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        data=restoranData.restaurants.get(pozicija);
                        data.menu.remove(position);
                        PreferencesManager.addRestaurants(restoranData, RestoranDetailsActivity.this);
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

        restoranData = PreferencesManager.getRestaurants(this);
        Intent intent = getIntent();
        if(intent.hasExtra("EXTRA")){
            data = (Restoran) intent.getSerializableExtra("EXTRA");
            pozicija = intent.getIntExtra("POZICIJA", 0);
        }


        Picasso.with(this)
                .load(data.getLogo())
                .fit()
                .centerInside()
                .into(imageView);

        imeRES.setText(data.getName());
        mesto.setText(data.getCity());
        rejting.setText(data.getRating());
        menuData = generateList();
        adapter.setItems(menuData);
        adapter.notifyDataSetChanged();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        if(data.getName().equals("McDonald’s")){
            ime=data.getName();
            textTopic.setText("                                    Willkommen bei "+ ime + " ihre Bestellung bitte!");
            textTopic.setSelected(true);
        }
        else{
            ime=data.getName();
            textTopic.setText("                                    Добредојдовте во ресторан " + ime + "! За повеќе информации посетете го нашиот website.");
            textTopic.setSelected(true);
        }

    }

    final ArrayList<Menu> generateList() {

        return data.getMenu();

    }


    @OnClick(R.id.buttonADD)
    public void onClickADD(View view){
        Intent intent = new Intent(RestoranDetailsActivity.this, MenuDetailsActivity.class);
//        if(data.getName().equals("McDonald’s")) {
//            mediaPlayer.start();
//        }
        startActivityForResult(intent, CODE);
    }

    @OnClick(R.id.buttonGallery)
    public void onClickGallery(View view){
        if(!data.getMenu().isEmpty()) {
            startActivity(new Intent(RestoranDetailsActivity.this, FragmentActivity.class).putExtra("pozicija_gallery", pozicija));
        }
        else{
            Toast.makeText(RestoranDetailsActivity.this, "Please insert menu", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.currentRestaurant)
    public void onClickCurrent(View view){
        Intent intent = new Intent(RestoranDetailsActivity.this, CurrentRestaurantActivity.class);
        intent.putExtra("Current", data);
        intent.putExtra("POZICIJA_RES", pozicija);
        startActivityForResult(intent, CODE_EDIT);
    }

    @OnClick(R.id.buttonInfo)
    public void onClickInfo (View view){
        if(data.getName().equals("Vijayawada")){
            url="https://www.tripadvisor.com/Restaurants-g303876-Vijayawada_Krishna_District_Andhra_Pradesh.html";
        }
        else if(data.getName().equals("Skopski Merak")){
            url="https://skopskimerak.mk";
        }
        else if(data.getName().equals("Бравос")){
            url="https://bravos.mk";
        }
        else if(data.getName().equals("Sвезден Океан")){
            url="http://www.kineskirestoran.com.mk";
        }
        else if(data.getName().equals("McDonald’s")){
            url="https://www.mcdonalds.com/de";
        }
        else if(data.getName().equals("Negorski Banji")){
            url="http://www.negorskibanji.com.mk/restoran";
        }
        else{
            url="http://www.google.com";
        }

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent _data) {
        if(requestCode==CODE && resultCode==RESULT_OK){

                meni = (Menu) _data.getSerializableExtra("Menu");
               if(menuData==null) {
                   menuData = new ArrayList<>();
               }
                menuData.add(meni);
                data.menu = menuData;
                restoranData.restaurants.get(pozicija).menu = menuData;
                PreferencesManager.addRestaurants(restoranData, this);
                adapter.setItems(menuData);
                adapter.notifyDataSetChanged();
        }

        if(requestCode==CODE_EDIT && resultCode==RESULT_OK) {
            if (_data.hasExtra("Current")) {
                data = (Restoran) _data.getSerializableExtra("Current");
                Picasso.with(this)
                        .load(data.getLogo())
                        .fit()
                        .centerInside()
                        .into(imageView);

                imeRES.setText(data.getName());
                mesto.setText(data.getCity());
                rejting.setText(data.getRating());
                restoranData = PreferencesManager.getRestaurants(this);
                restoranData.restaurants.set(pozicija, data);
                PreferencesManager.addRestaurants(restoranData, this);

                if(data.getName().equals("McDonald's")){
                    ime=data.getName();
                    textTopic.setText("                                    Willkommen bei "+ ime + " ihre Bestellung bitte!");
                    textTopic.setSelected(true);
                }
                else{
                    ime=data.getName();
                    textTopic.setText("                                    Добредојдовте во ресторан " + ime + "! За повеќе информации посетете го нашиот website.");
                    textTopic.setSelected(true);
                }

            }
        }

        if(requestCode==CODE_EDIT_MENU && resultCode==RESULT_OK) {
            restoranData = PreferencesManager.getRestaurants(this);
            data = restoranData.restaurants.get(pozicija);
            menuData = generateList();
            adapter.setItems(menuData);
            adapter.notifyDataSetChanged();

        }


    }

    @Override
    protected void onResume() {
        super.onResume();
        restoranData = PreferencesManager.getRestaurants(this);
        data=restoranData.restaurants.get(pozicija);
        menuData = generateList();
        adapter.setItems(menuData);
        adapter.notifyDataSetChanged();
    }
}
