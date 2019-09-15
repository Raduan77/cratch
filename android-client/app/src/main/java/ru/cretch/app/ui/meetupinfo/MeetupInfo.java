package ru.cretch.app.ui.meetupinfo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ru.cretch.app.R;
import ru.cretch.app.ui.meetupcreator.MeetupCreator;
import ru.cretch.app.ui.seecheck.SeeCheckActivity;

public class MeetupInfo extends AppCompatActivity {
    public static int status = 0;
    public static final int DONE = 0, GOING = 1, WAITING = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch (status) {
            case GOING:
                setContentView(R.layout.activity_meetup_info_going);
            case WAITING:
                setContentView(R.layout.activity_meetup_info_waiting);
            default:
            case DONE:
                setContentView(R.layout.activity_meetup_info_done);
        }
        TextView name = findViewById(R.id.meetup_name);
        TextView description = findViewById(R.id.meetup_description);
        TextView place = findViewById(R.id.meetup_place);
        TextView time = findViewById(R.id.meetup_time);
        name.setText("School");
        description.setText("Таким образом, консультация с профессионалами из IT представляет собой интересный эксперимент проверки модели развития. ");
        place.setText("Hookah");
        time.setText("10 Sep");

        RecyclerView recyclerView = findViewById(R.id.teammates);
        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);
        recyclerView.setAdapter(new TeammatesAdapter(initDate()));
        Button button = findViewById(R.id.button);
        View.OnClickListener listener;

        switch (status) {
            case GOING:
                listener = v -> {
                    startActivity(new Intent(this, SeeCheckActivity.class));
                };
            case WAITING:
                listener = v -> {
                    startActivity(new Intent(this, SeeCheckActivity.class));
                };
            default:
            case DONE:
                listener = v -> {
                    startActivity(new Intent(this, SeeCheckActivity.class));
                };
        }
        button.setOnClickListener(listener);
    }

    TeammatesModel[] initDate() {
        TeammatesModel[] date = new TeammatesModel[3];
        date[0] = new TeammatesModel(this);
        date[1] = new TeammatesModel(this);
        date[2] = new TeammatesModel(this);
        return date;
    }
}
