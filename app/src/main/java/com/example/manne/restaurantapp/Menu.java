package com.example.manne.restaurantapp;

import java.io.Serializable;

/**
 * Created by manne on 18.12.2017.
 */

public class Menu implements Serializable {
    public String link;
    public String price;
    public String foodname;
    public boolean isveg;

    public Menu(){

    }

    public String getFoodname() {
        return foodname;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }
}
