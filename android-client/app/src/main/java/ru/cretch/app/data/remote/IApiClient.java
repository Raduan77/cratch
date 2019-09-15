package ru.cretch.app.data.remote;


import retrofit2.Call;
import ru.cretch.app.model.UserInfoResponse;

public interface IApiClient {

    Call<UserInfoResponse> getUserInfo();
}