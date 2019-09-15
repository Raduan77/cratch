package ru.cretch.app.model;

import com.google.gson.annotations.Expose;

public class Friend {

    @Expose
    public String name;

    @Expose
    public User user;

    @Expose
    public Integer pk;

}
