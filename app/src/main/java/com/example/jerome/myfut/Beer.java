package com.example.jerome.myfut;

import android.graphics.drawable.Drawable;

public class Beer {
    int id;
    String name;
    Drawable picture;
    float price;

    public Beer(int id, String name, Drawable picture, float price) {
        super();
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.price = price;
    }

    public Beer() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable getPicture() {
        return picture;
    }

    public void setPicture(Drawable picture) {
        this.picture = picture;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Beer [id=" + id + ", name=" + name + ", picture=" + picture
                + ", price=" + price + "]";
    }

}
