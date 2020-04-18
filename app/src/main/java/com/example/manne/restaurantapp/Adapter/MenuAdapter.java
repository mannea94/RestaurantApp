package com.example.manne.restaurantapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manne.restaurantapp.Listener.OnRowMenuClickListener;
import com.example.manne.restaurantapp.Menu;
import com.example.manne.restaurantapp.Listener.OnRowClickListener;
import com.example.manne.restaurantapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by manne on 20.12.2017.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {
    Context context;
    List<Menu> menus = new ArrayList<>();
    OnRowMenuClickListener onRowMenuClickListener;

    public void setItems(List<Menu> _menus){
        menus = _menus;
    }

    public MenuAdapter(Context context_, OnRowMenuClickListener _onRowMenuClickListener) {
        context = context_;
        onRowMenuClickListener=_onRowMenuClickListener;
    }

    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        //Inflate the custom layout
        View view = inflater.inflate(R.layout.recycler_view_row_menu, parent, false);
        //Return a new holder instance
        MenuAdapter.ViewHolder viewHolder = new MenuAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MenuAdapter.ViewHolder viewHolder, final int position) {
        // Get the data model based on position
        final Menu menu= menus.get(position);
        viewHolder.textFood.setText(menu.getFoodname());
        viewHolder.textPrice.setText("Cena: "+menu.getPrice());
        if(menu.isveg){
            viewHolder.isVeg.setText("Veg: DA");
        }
        else{
            viewHolder.isVeg.setText("Veg: NE");
        }



        if(menu.getLink()!=null&& !menu.getLink().equals("")) {
            Picasso.with(context)
                    .load(menu.getLink())
                    .fit()
                    .centerInside()
                    .into(viewHolder.imageMenu);
        }

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRowMenuClickListener.onRowClick(menu, position);
            }
        });

        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                onRowMenuClickListener.onLongRowClick(menu, position);
               return true;
            }
        });



    }

    @Override
    public int getItemCount() {
        if(menus==null)
            return 0;
        return menus.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.textPrice)
        TextView textPrice;
        @BindView(R.id.textFood)
        TextView textFood;
        @BindView(R.id.isVeg)
        TextView isVeg;
        @BindView(R.id.imageMenu)
        ImageView imageMenu;

        public ViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
