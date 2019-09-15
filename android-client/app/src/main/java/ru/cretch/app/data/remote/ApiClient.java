package ru.cretch.app.data.remote;

import javax.inject.Inject;
import retrofit2.Call;
import ru.cretch.app.App;
import ru.cretch.app.model.UserInfoResponse;

public class ApiClient implements IApiClient {

    private static final String TAG = "ApiClient";

    @Inject
    public ApiClient(){ }


    @Override
    public Call<UserInfoResponse> getUserInfo() {

        return App.getInstance().getApi().getUserInfo("application/json");
    }
}
