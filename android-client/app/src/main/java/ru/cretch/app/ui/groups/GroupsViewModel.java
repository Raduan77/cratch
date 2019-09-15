package ru.cretch.app.ui.groups;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import javax.inject.Inject;

import ru.cretch.app.data.Result;
import ru.cretch.app.data.UserRepository;
import ru.cretch.app.model.Group;
import ru.cretch.app.ui.profile.ProfileResult;
import ru.cretch.app.ui.profile.ProfileUI;

public class GroupsViewModel extends ViewModel {

    @Inject
    UserRepository userRepository;

    private MutableLiveData<GroupsResult> groupsResult = new MutableLiveData<>();

    public MutableLiveData<GroupsResult> getGroupsResult() {
        return groupsResult;
    }


    public void getGroups(){
        userRepository.getGroups().observeForever(result -> {
            if (result instanceof Result.Success) {
                ArrayList<Group> data = ((Result.Success<ArrayList<Group>>) result).getData();
                GroupsUI groupsUI = new GroupsUI(data);
                groupsResult.setValue(new GroupsResult(groupsUI));
            } else {
                groupsResult.setValue(new GroupsResult((Result.Error) result));
            }
        });
    }

}
