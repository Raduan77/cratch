package ru.cretch.app.data.remote;


import retrofit2.Call;
import ru.cretch.app.model.LoginResponse;
import ru.cretch.app.model.UserInfoResponse;

public interface IApiClient {

    Call<LoginResponse> login(String username, String password);

    Call<UserInfoResponse> getUserInfo();
}