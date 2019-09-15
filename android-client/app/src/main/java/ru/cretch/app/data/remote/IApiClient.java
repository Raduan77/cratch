package ru.cretch.app.data.remote;


import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.Header;
import ru.cretch.app.model.Group;
import ru.cretch.app.model.LoginResponse;
import ru.cretch.app.model.UserInfoResponse;

public interface IApiClient {

    Call<LoginResponse> login(String username, String password);

    Call<UserInfoResponse> getUserInfo();

    Call<ArrayList<Group>> getGroups(String token);

    Call<ResponseBody> createGroup(String username, String password, Integer backId, Integer[] array);
}