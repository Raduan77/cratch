package ru.rentateam.rttestapp.ui.checksplitter;

import android.content.Context;
import android.graphics.drawable.Drawable;

import ru.rentateam.rttestapp.R;

public class ProductModel {
    public String name;
    public float price;
    public boolean selected;

    public ProductModel() {
        name = "name";
        price = 100;
        selected = false;
    }

    public void select() {
        selected ^= true;
    }
}
