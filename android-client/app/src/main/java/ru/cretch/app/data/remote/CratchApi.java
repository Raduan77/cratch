package ru.cretch.app.data.remote;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import ru.cretch.app.model.UserInfoResponse;


public interface CratchApi {

    @GET("/api/clientInfo")
    Call<UserInfoResponse> getUserInfo(@Header("Accept") String sessionIdAndToken);
}
