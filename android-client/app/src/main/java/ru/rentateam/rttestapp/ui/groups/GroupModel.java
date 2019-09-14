package ru.rentateam.rttestapp.ui.groups;

import android.content.Context;
import android.graphics.drawable.Drawable;

import ru.rentateam.rttestapp.R;

public class GroupModel {
    public String title, subtitle;
    public Drawable largeIcon, mediumItem, smallItem;

    public GroupModel(Context context) {
        title = "Title";
        subtitle = "SubTitle";
        largeIcon = context.getResources().getDrawable(R.drawable.ic_bottom_nav_basket);
        mediumItem = context.getResources().getDrawable(R.drawable.ic_bottom_nav_basket);
        smallItem = context.getResources().getDrawable(R.drawable.ic_bottom_nav_basket);
    }
}
