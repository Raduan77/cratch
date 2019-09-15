package ru.cretch.app.ui.groups;


import java.util.ArrayList;

import ru.cretch.app.model.Group;

public class GroupsUI {

    public ArrayList<GroupModel> items = new ArrayList<>();

    public GroupsUI(){}

    public GroupsUI(ArrayList<Group> groups){
        for (Group group: groups){
            items.add(new GroupModel(group));
        }
    }
}
