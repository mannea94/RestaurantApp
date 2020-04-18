package com.example.manne.restaurantapp;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by manne on 18.12.2017.
 */

public class Restoran implements Serializable{
    public String logo;
    public String city;
    public String name;
    public String rating;
    public String url;
    public ArrayList<Menu> menu;

    public Restoran (String logo, String name, String city, String rating){
        this.logo=logo;
        this.city=city;
        this.name=name;
        this.rating=rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public String getLogo() {
        return logo;
    }

    public void setCity(String city) {
        this.city = city;
    }



    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public ArrayList<Menu> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<Menu> menu) {
        this.menu = menu;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
