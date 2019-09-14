package ru.rentateam.rttestapp.ui.groupcreator;

import android.content.Context;
import android.graphics.drawable.Drawable;

import ru.rentateam.rttestapp.R;

public class TeammatesModel {
    public String name, tag;
    public Drawable avatarIcon;

    public TeammatesModel() {

    }

    public TeammatesModel(Context context) {
        name = "Artemiy Shirokov";
        tag = "@tema7707";
        avatarIcon = context.getResources().getDrawable(R.drawable.ic_home_black_24dp);
    }
}
