package ru.cretch.app.ui.checksplitter;

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
