package ru.rentateam.rttestapp.ui.meetupinfo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ru.rentateam.rttestapp.R;
import ru.rentateam.rttestapp.ui.groupcreator.TeammatesAdapter;
import ru.rentateam.rttestapp.ui.groupcreator.TeammatesModel;

public class MeetupInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meetup_info);
        findViewById(R.id.group_button_meet).setOnClickListener(v -> {}); // open another activity

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
    }

    TeammatesModel[] initDate() {
        TeammatesModel[] date = new TeammatesModel[3];
        date[0] = new TeammatesModel(this);
        date[1] = new TeammatesModel(this);
        date[2] = new TeammatesModel(this);
        return date;
    }
}
