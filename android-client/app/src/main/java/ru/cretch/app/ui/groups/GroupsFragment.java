package ru.cretch.app.ui.groups;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.iid.FirebaseInstanceId;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ru.cretch.app.App;
import ru.cretch.app.R;
import ru.cretch.app.ui.groupcreator.CreateGroup;
import ru.cretch.app.ui.profile.ProfileViewModel;

public class GroupsFragment extends Fragment {

    private GroupsViewModel mViewModel;

    private RecyclerView recyclerView;
    private GroupAdapter mAdapter;

    public static GroupsFragment newInstance() {
        return new GroupsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mAdapter = new GroupAdapter(getContext());
        return inflater.inflate(R.layout.fragment_groups, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel = ViewModelProviders.of(this).get(GroupsViewModel.class);
        App.getInstance().getComponent().inject(mViewModel);

        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(instanceIdResult -> {
            String newToken = instanceIdResult.getToken();
            Log.e("newToken", newToken);
            getActivity().getPreferences(Context.MODE_PRIVATE).edit().putString("fb", newToken).apply();
        });

        Log.d("newToken", getActivity().getPreferences(Context.MODE_PRIVATE).getString("fb", "empty :("));

        recyclerView = view.findViewById(R.id.groups_list);
        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);
        recyclerView.setAdapter(mAdapter);
        FloatingActionButton fab = view.findViewById(R.id.fab_add_group);
        fab.setOnClickListener(v -> startActivity(new Intent(getContext(), CreateGroup.class)));

        mViewModel.getGroupsResult().observe(this, groupsResult -> {
            if (groupsResult == null)
                return;

            if (groupsResult.getSuccess()!=null){
                mAdapter.setDataset(groupsResult.getSuccess().items);
            }
        });

        mViewModel.getGroups();
    }

}
