package com.example.manne.restaurantapp.Listener;

import com.example.manne.restaurantapp.Restoran;

/**
 * Created by manne on 20.12.2017.
 */

public interface OnRowClickListener {
    public void onRowClick(Restoran restoranData, int position);
    public void onLongRowClick(Restoran restoran, int position);
}
