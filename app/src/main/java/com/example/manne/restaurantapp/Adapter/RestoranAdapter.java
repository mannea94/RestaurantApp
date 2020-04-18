package com.example.manne.restaurantapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.manne.restaurantapp.Listener.OnRowClickListener;
import com.example.manne.restaurantapp.R;
import com.example.manne.restaurantapp.Restoran;
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
    OnRowClickListener onRowClickListener;

    public void setItems(List<Restoran> _restorans){
        restorans = _restorans;
    }

    public RestoranAdapter(Context context_, OnRowClickListener _onRowClickListener) {
        context = context_;
        onRowClickListener = _onRowClickListener;
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
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        // Get the data model based on position
        final Restoran restoran= restorans.get(position);
        viewHolder.textView2.setText(restoran.getCity());
        viewHolder.textView3.setText(restoran.getRating());
        viewHolder.textView.setText(restoran.getName());
        viewHolder.url=restoran.getUrl();
        viewHolder.ratingBar.setRating(Float.valueOf(restoran.getRating()));
        viewHolder.ratingBar.setEnabled(false);




        if(restoran.getLogo()!=null&& !restoran.getLogo().equals("")) {
            Picasso.with(context)
                    .load(restoran.getLogo())
                    .fit()
                    .centerInside()
                    .into(viewHolder.imageView);
        }

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRowClickListener.onRowClick(restoran, position);
            }
        });

        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                onRowClickListener.onLongRowClick(restoran, position);
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return restorans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.textIME)
        TextView textView;
        @BindView(R.id.textGRAD)
        TextView textView2;
        @BindView(R.id.textREJTING)
        TextView textView3;
        @BindView(R.id.imageView)
        ImageView imageView;
        @BindView(R.id.ratingBar)
        RatingBar ratingBar;
        String url;

        public ViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
