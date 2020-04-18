package com.example.manne.restaurantapp;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MenuActivity extends AppCompatActivity {

    @BindView(R.id.imageMenu)
    ImageView imageMenu;

    @BindView(R.id.imeMenu)
    EditText imeMenu;

    @BindView(R.id.cena)
    EditText cena;

    @BindView(R.id.checkBox)
    CheckBox checkBox;

    @BindView(R.id.linkSlika)
    EditText linkSlika;

    @BindView(R.id.buttonEDIT)
    ImageButton buttonEdit;

    Menu data;

    int position;

    String link;

    RestoranData restoranData;
    private int position_restoran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);

        restoranData = PreferencesManager.getRestaurants(this);


        Intent intent = getIntent();
        if(intent.hasExtra("EXTRA_MENU")){
            data = (Menu) intent.getSerializableExtra("EXTRA_MENU");
            position = intent.getIntExtra("POZICIJA_MENU", 0);
            position_restoran = intent.getIntExtra("POZICIJA_RESTORAN", 0);
        }


        Picasso.with(this)
                .load(data.getLink())
                .fit()
                .centerInside()
                .into(imageMenu);

        imeMenu.setText(data.getFoodname());
        cena.setText(data.getPrice());
        checkBox.setChecked(data.isIsveg());
        linkSlika.setText(data.getLink());

    }

    @OnClick(R.id.buttonEDIT)
    public void onClickEdit(View view){
        if(!linkSlika.getText().toString().isEmpty() && !imeMenu.getText().toString().isEmpty() && !cena.getText().toString().isEmpty()) {
            data = new Menu(linkSlika.getText().toString(), imeMenu.getText().toString(), cena.getText().toString(), checkBox.isChecked());

            restoranData.restaurants.get(position_restoran).menu.set(position, data);
            PreferencesManager.addRestaurants(restoranData, this);

            Intent intent = new Intent().putExtra("EDIT", data);
            setResult(RESULT_OK, intent);
            finish();
        }
        else{
            Toast.makeText(MenuActivity.this, "Please fill whole menu", Toast.LENGTH_SHORT).show();
        }
    }


}
