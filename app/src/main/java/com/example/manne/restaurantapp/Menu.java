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

    public Menu(String link, String foodname, String price, boolean isveg){
        this.link=link;
        this.price=price;
        this.foodname=foodname;
        this.isveg=isveg;
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

    public String getPrice() {
        return price;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public void setIsveg(boolean isveg) {
        this.isveg = isveg;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean isIsveg() {
        return isveg;
    }
}
