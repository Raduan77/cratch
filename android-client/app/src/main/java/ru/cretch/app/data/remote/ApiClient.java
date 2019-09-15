package ru.cretch.app.data.remote;

import java.util.ArrayList;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import ru.cretch.app.App;
import ru.cretch.app.model.Group;
import ru.cretch.app.model.LoginResponse;
import ru.cretch.app.model.UserInfoResponse;

public class ApiClient implements IApiClient {

    private static final String TAG = "ApiClient";

    @Inject
    public ApiClient(){ }


    @Override
    public Call<LoginResponse> login(String username, String password) {
        return App.getInstance().getApi().login(username, password);
    }

    @Override
    public Call<UserInfoResponse> getUserInfo() {

        return App.getInstance().getApi().getUserInfo("application/json");
    }

    @Override
    public Call<ArrayList<Group>> getGroups(String token) {
        return App.getInstance().getApi().getGroups(token);
    }

    @Override
    public Call<ResponseBody> createGroup(String username, String password, Integer backId, Integer[] array) {
        return App.getInstance().getApi().createGroup(username, password, backId, array);
    }
}
