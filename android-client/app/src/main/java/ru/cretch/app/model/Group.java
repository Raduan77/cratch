package ru.cretch.app.model;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class Group {


    @Expose
    public ArrayList<Friend> friends;

    @Expose
    public String name;

    @Expose
    public String description;

    @Expose
    public Integer pk;


}
