package ru.rentateam.rttestapp.data.remote;


import retrofit2.Call;
import ru.rentateam.rttestapp.model.UserInfoResponse;

public interface IApiClient {

    Call<UserInfoResponse> getUserInfo();
}