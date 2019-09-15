package ru.rentateam.rttestapp.ui.meetups;

import android.content.Context;
import android.graphics.drawable.Drawable;

import ru.rentateam.rttestapp.R;

public class MeetupModel {
    public String title, subtitle, time, place;

    public MeetupModel(Context context) {
        title = "Title";
        subtitle = "SubTitle";
        time = "10 Sep";
        place = "Hookah";
    }
}
