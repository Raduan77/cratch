package ru.rentateam.rttestapp.ui.groupcreator;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.util.Random;

import ru.rentateam.rttestapp.R;

public class TeammatesModel {
    private static Random rnd = new Random();
    public String name, tag;
    public Drawable avatarIcon;

    public TeammatesModel() {

    }

    public TeammatesModel(Context context) {
        name = "Artemiy Shirokov";
        tag = "@tema7707";
        avatarIcon = context.getResources().getDrawable(randomImgId());
    }

    int randomImgId() {
        int id = rnd.nextInt();
        switch (id % 8) {
            case 0: return R.drawable.ic_boy1;
            case 1: return R.drawable.ic_boy2;
            case 2: return R.drawable.ic_girl1;
            case 3: return R.drawable.ic_girl2;
            case 4: return R.drawable.ic_man1;
            case 5: return R.drawable.ic_man2;
            case 6: return R.drawable.ic_man3;
            case 7: return R.drawable.ic_man4;
            default: return R.drawable.ic_man5;
        }
    }
}
