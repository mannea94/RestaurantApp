package com.example.manne.restaurantapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CurrentRestaurantActivity extends AppCompatActivity {

    @BindView(R.id.imageRestoran)
    ImageView imageRestoran;
    @BindView(R.id.imeRestoran)
    EditText imeRestoran;
    @BindView(R.id.gradRestoran)
    EditText gradRestoran;
    @BindView(R.id.rejtingRestoran)
    EditText rejtingRestoran;
    @BindView(R.id.buttonEDIT)
    ImageButton buttonEdit;
    @BindView(R.id.linkImage)
    EditText linkImage;
    Restoran data;
    int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_restaurant);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        if(intent.hasExtra("Current")){
           data = (Restoran) intent.getSerializableExtra("Current");
           position = intent.getIntExtra("POZICIJA_RES", 0);
        }

        Picasso.with(this)
                .load(data.getLogo())
                .fit()
                .centerInside()
                .into(imageRestoran);

        imeRestoran.setText(data.getName());
        gradRestoran.setText(data.getCity());
        rejtingRestoran.setText(data.getRating());
        linkImage.setText(data.getLogo());
    }


    @OnClick(R.id.buttonEDIT)
    public void onClickEdit(View view){
        if(!linkImage.getText().toString().isEmpty() && !imeRestoran.getText().toString().isEmpty() && !gradRestoran.getText().toString().isEmpty() && !rejtingRestoran.getText().toString().isEmpty()) {
            data.setName(imeRestoran.getText().toString());
            data.setCity(gradRestoran.getText().toString());
            data.setRating(rejtingRestoran.getText().toString());
            data.setLogo(linkImage.getText().toString());

            Intent intent = new Intent().putExtra("Current", data);
            setResult(RESULT_OK, intent);
            finish();
        }
        else{
            Toast.makeText(CurrentRestaurantActivity.this, "Please fill whole restaurant", Toast.LENGTH_SHORT).show();
        }
    }


}
