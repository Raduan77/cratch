package ru.rentateam.rttestapp.data;

import javax.inject.Inject;

import retrofit2.Call;
import ru.rentateam.rttestapp.data.local.IPreferencesHelper;
import ru.rentateam.rttestapp.data.local.PreferencesHelper;
import ru.rentateam.rttestapp.data.remote.ApiClient;
import ru.rentateam.rttestapp.data.remote.IApiClient;
import ru.rentateam.rttestapp.model.UserInfoResponse;

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
    public Call<UserInfoResponse> getUserInfo() {
        return apiClient.getUserInfo();
    }
}
