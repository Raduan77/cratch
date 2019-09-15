package ru.cretch.app.ui.groups;

import androidx.annotation.Nullable;

import ru.cretch.app.data.Result;
import ru.cretch.app.ui.profile.ProfileUI;

public class GroupsResult {



    @Nullable
    private GroupsUI success;
    @Nullable
    private Result.Error error;

    public GroupsResult(@Nullable Result.Error error) {
        this.error = error;
    }

    public GroupsResult(@Nullable GroupsUI success) {
        this.success = success;
    }

    @Nullable
    public GroupsUI getSuccess() {
        return success;
    }

    @Nullable
    public Result.Error getError() {
        return error;
    }



}
