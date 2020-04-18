package com.example.manne.restaurantapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by manne on 22.12.2017.
 */

public class Fragment1 extends Fragment {
    public Unbinder unbinder;
    @BindView(R.id.imageFragment)
    ImageView imageFragment;
    @BindView(R.id.nameFood)
    TextView nameFood;
    @BindView(R.id.priceFood)
    TextView priceFood;

    public static Fragment1 newInstance(String imageUrl, String food, String price){
        Bundle args = new Bundle();
        args.putString("imageUrl", imageUrl);
        args.putString("foodUrl", food);
        args.putString("priceUrl", price);
        Fragment1 fragment = new Fragment1();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, null);
        unbinder= ButterKnife.bind(this, view);

            if (getArguments() != null && getArguments().getString("imageUrl") != null) {
                Picasso.with(getActivity())
                        .load(getArguments().getString("imageUrl"))
                        .centerInside()
                        .fit()
                        .into(imageFragment);
            }
            if (getArguments() != null && getArguments().getString("foodUrl") != null) {
                nameFood.setText(getArguments().getString("foodUrl"));
            }
            if (getArguments() != null && getArguments().getString("priceUrl") != null) {
                priceFood.setText(getArguments().getString("priceUrl"));
            }


        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
