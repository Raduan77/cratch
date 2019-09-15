package ru.rentateam.rttestapp.data.remote;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import ru.rentateam.rttestapp.model.UserInfoResponse;


public interface CratchApi {

    @GET("/api/clientInfo")
    Call<UserInfoResponse> getUserInfo(@Header("Accept") String sessionIdAndToken);
}
