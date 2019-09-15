package ru.cretch.app.model;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    public enum UserStatus implements Serializable{
        NO_AUTHED("Войдите в аккаунт"),
        NEW("Пройдите регистрацию"),
        ON_CHECK("На проверке"),
        NEED_DOCS("Нужны документы"),
        ACTIVE("Активный"),
        BLOCKED("Заблокирован");

        public final String stringStatus;

        UserStatus(String stringStatus) {
            this.stringStatus = stringStatus;
        }
    }

    @Expose
    public String id;

    @Expose
    public String name;

    @Expose
    public String middleName;

    @Expose
    public String surname;

    @Expose
    public String phone;

    @Expose
    public String email;

    @Expose
    public boolean hasBankCard;

    @Expose
    public boolean needSign;

    @Expose
    public int debit;

    @Expose
    public int bonus;

    @Expose
    public UserStatus status;

    @Expose
    public ArrayList<String> required;




}
