package ru.rentateam.rttestapp.ui.groups;

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
import androidx.recyclerview.widget.RecyclerView;
import ru.rentateam.rttestapp.R;
import ru.rentateam.rttestapp.ui.menu.pizza.PizzaFragment;

public class GroupsFragment extends Fragment {

    private RecyclerView recyclerView;
    private GroupsAdapter mAdapter;

    public static GroupsFragment newInstance() {
        return new GroupsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        List<GroupModel> data = new ArrayList<>();
        data.add(new GroupModel(getContext()));
        data.add(new GroupModel(getContext()));
        data.add(new GroupModel(getContext()));
        GroupModel[] arr = new GroupModel[data.size()];
        data.toArray(arr);
        mAdapter = new GroupsAdapter(arr);
        return inflater.inflate(R.layout.fragment_groups, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.groups_list);
        recyclerView.setAdapter(mAdapter);
        FloatingActionButton fab = view.findViewById(R.id.fab_add_group);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.pager, new PizzaFragment()).commit();
            }
        });
    }

}
