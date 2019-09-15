package ru.cretch.app.ui.login;

import androidx.annotation.Nullable;

import ru.cretch.app.data.Result;
import ru.cretch.app.ui.profile.ProfileUI;

public class LoginResult {



    @Nullable
    private Boolean success;
    @Nullable
    private Result.Error error;

    public LoginResult(@Nullable Result.Error error) {
        this.error = error;
    }

    public LoginResult(@Nullable Boolean success) {
        this.success = success;
    }

    @Nullable
    public Boolean getSuccess() {
        return success;
    }

    @Nullable
    public Result.Error getError() {
        return error;
    }



}
