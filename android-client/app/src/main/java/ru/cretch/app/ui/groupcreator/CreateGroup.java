package ru.cretch.app.ui.groupcreator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ru.cretch.app.R;
import ru.cretch.app.ui.groupinfo.GroupInfo;

import android.content.Intent;
import android.os.Bundle;

public class CreateGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);
        findViewById(R.id.group_button_create).setOnClickListener(v -> {
            startActivity(new Intent(this, GroupInfo.class));
        });

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
