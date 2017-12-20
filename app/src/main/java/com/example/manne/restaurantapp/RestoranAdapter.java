package com.example.manne.restaurantapp;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by manne on 18.12.2017.
 */

public class RestoranAdapter extends RecyclerView.Adapter<RestoranAdapter.ViewHolder> {
    Context context;
    List<Restoran> restorans = new ArrayList<>();

    public void setItems(List<Restoran> _restorans){
        restorans = _restorans;
    }

    public RestoranAdapter(Context context_) {
        context = context_;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        //Inflate the custom layout
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);
        //Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Restoran restoran= restorans.get(position);
        viewHolder.textView2.setText(restoran.getRating());
        viewHolder.textView.setText(restoran.getName());



        Picasso.with(context)
                .load(restoran.getLogo())
                .fit()
                .centerInside()
                .into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return restorans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.text)
        TextView textView;
        @BindView(R.id.text2)
        TextView textView2;
        @BindView(R.id.imageView)
        ImageView imageView;

        public ViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
