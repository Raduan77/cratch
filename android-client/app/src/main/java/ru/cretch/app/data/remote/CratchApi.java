package ru.cretch.app.data.remote;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import ru.cretch.app.model.Group;
import ru.cretch.app.model.LoginResponse;
import ru.cretch.app.model.UserInfoResponse;


public interface CratchApi {

    @FormUrlEncoded
    @POST("/api/v1/token")
    Call<LoginResponse> login(@Field("username") String username, @Field("password") String password);

    @POST("/api/v1/group/create")
    Call<ResponseBody> createGroup(@Field("name") String username, @Field("description") String password, @Field("background_id") Integer backId, @Field("friends") Integer[] array);

    @GET("/api/v1/group/list")
    Call<ArrayList<Group>> getGroups(@Header("Authorization") String token);

    @GET("/api/clientInfo")
    Call<UserInfoResponse> getUserInfo(@Header("Accept") String sessionIdAndToken);
}
