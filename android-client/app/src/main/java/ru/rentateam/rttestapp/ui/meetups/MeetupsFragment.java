package ru.rentateam.rttestapp.ui.meetups;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ru.rentateam.rttestapp.R;
import ru.rentateam.rttestapp.ui.groupcreator.CreateGroup;
import ru.rentateam.rttestapp.ui.groups.GroupModel;
import ru.rentateam.rttestapp.ui.groups.GroupAdapter;

public class MeetupsFragment extends Fragment {

    private RecyclerView recyclerView;
    private MeetupAdapter mAdapter;

    public static MeetupsFragment newInstance() {
        return new MeetupsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        List<MeetupModel> data = new ArrayList<>();
        data.add(new MeetupModel(getContext()));
        data.add(new MeetupModel(getContext()));
        data.add(new MeetupModel(getContext()));
        MeetupModel[] arr = new MeetupModel[data.size()];
        data.toArray(arr);
        mAdapter = new MeetupAdapter(arr);
        return inflater.inflate(R.layout.fragment_users_meetups, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.meetups_list);
        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);
        recyclerView.setAdapter(mAdapter);
    }
}
