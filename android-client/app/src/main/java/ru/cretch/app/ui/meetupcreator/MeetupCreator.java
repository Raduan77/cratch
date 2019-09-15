package ru.cretch.app.ui.meetupcreator;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import ru.cretch.app.R;

public class MeetupCreator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_meetup);
        EditText name = findViewById(R.id.edit_meetup_name);
        EditText description = findViewById(R.id.edit_meetup_desctiption);
        EditText place = findViewById(R.id.edit_meetup_place);
        EditText time = findViewById(R.id.edit_meetup_time);
    }
}
