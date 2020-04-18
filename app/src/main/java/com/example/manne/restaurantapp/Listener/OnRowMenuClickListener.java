package com.example.manne.restaurantapp.Listener;

import com.example.manne.restaurantapp.Menu;
import com.example.manne.restaurantapp.Restoran;

/**
 * Created by manne on 20.12.2017.
 */

public interface OnRowMenuClickListener {
    public void onRowClick(Menu menuData, int position);
    public void onLongRowClick(Menu menuData, int position);
}
