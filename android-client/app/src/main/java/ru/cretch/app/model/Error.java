package ru.cretch.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Error {

    @Expose
    public int code;

    @SerializedName("code_message")
    public String codeMessage;

    @Expose
    public int timeForNewCode;
}