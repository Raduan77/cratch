package ru.cretch.app.model;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.ArrayList;

public class LoginResponse implements Serializable {

    @Expose
    public String token;

}
