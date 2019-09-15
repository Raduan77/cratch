package ru.cretch.app.data;

import javax.inject.Inject;

import retrofit2.Call;
import ru.cretch.app.data.local.IPreferencesHelper;
import ru.cretch.app.data.local.PreferencesHelper;
import ru.cretch.app.data.remote.ApiClient;
import ru.cretch.app.data.remote.IApiClient;
import ru.cretch.app.model.LoginResponse;
import ru.cretch.app.model.UserInfoResponse;

public class DataManager implements IApiClient, IPreferencesHelper {

    private ApiClient apiClient;
    private PreferencesHelper preferencesHelper;

    @Inject
    public DataManager(ApiClient apiClient, PreferencesHelper preferencesHelper){
        this.apiClient = apiClient;
        this.preferencesHelper = preferencesHelper;
    }

    @Override
    public void saveSessId(String data) {
        preferencesHelper.saveSessId(data);
    }

    @Override
    public String getSessId() {
        return preferencesHelper.getSessId();
    }

    @Override
    public Call<LoginResponse> login(String username, String password) {
        return apiClient.login(username, password);
    }

    @Override
    public Call<UserInfoResponse> getUserInfo() {
        return apiClient.getUserInfo();
    }
}
