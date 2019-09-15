package ru.cretch.app.ui.meetups;

import android.content.Context;

public class MeetupModel {
    public String title, subtitle, time, place;

    public MeetupModel(Context context) {
        title = "Title";
        subtitle = "SubTitle";
        time = "10 Sep";
        place = "Hookah";
    }
}
