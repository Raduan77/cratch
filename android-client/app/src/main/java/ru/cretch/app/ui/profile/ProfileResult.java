package ru.cretch.app.ui.profile;

import androidx.annotation.Nullable;

import ru.cretch.app.data.Result;

public class ProfileResult {



    @Nullable
    private ProfileUI success;
    @Nullable
    private Result.Error error;

    public ProfileResult(@Nullable Result.Error error) {
        this.error = error;
    }

    public ProfileResult(@Nullable ProfileUI success) {
        this.success = success;
    }

    @Nullable
    public ProfileUI getSuccess() {
        return success;
    }

    @Nullable
    public Result.Error getError() {
        return error;
    }



}
