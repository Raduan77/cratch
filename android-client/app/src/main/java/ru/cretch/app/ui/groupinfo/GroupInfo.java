package ru.cretch.app.ui.groupinfo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ru.cretch.app.R;
import ru.cretch.app.ui.meetupcreator.MeetupCreator;
import ru.cretch.app.ui.meetupinfo.MeetupInfo;

public class GroupInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_info);
        findViewById(R.id.group_button_meet).setOnClickListener(v ->
                startActivity(new Intent(this, MeetupCreator.class)));

        TextView name = findViewById(R.id.group_name);
        TextView description = findViewById(R.id.group_description);
        name.setText("School");
        description.setText("Таким образом, консультация с профессионалами из IT представляет собой интересный эксперимент проверки модели развития. ");

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
