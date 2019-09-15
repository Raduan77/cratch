package ru.cretch.app.data;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.cretch.app.model.Error;
import ru.cretch.app.model.LoginResponse;
import ru.cretch.app.model.User;
import ru.cretch.app.model.UserInfoResponse;

import static ru.cretch.app.model.ErrorCode.CONNECTION_ERROR;
import static ru.cretch.app.model.ErrorCode.INCORRECT_DATA;

public class UserRepository {

    private Result connectionError = new Result.Error(CONNECTION_ERROR, "Не удалось подключиться к серверу");
    private Result incorrectDataError = new Result.Error(INCORRECT_DATA, "Получены некорректные данные");


    private static final String TAG = "UserRepository";
    private DataManager dataManager;

    private MutableLiveData<User> curUser;

    @Inject
    public UserRepository(DataManager dataManager){
        this.dataManager = dataManager;
        this.curUser = new MutableLiveData<>();
    }

    private void setCurUser(User curUser) {
        if (curUser==null){
            curUser = new User();
        }

        this.curUser.setValue(curUser);
    }

    private Error getError(ResponseBody responseBody){
        Gson gson = new Gson();
        try {
            return gson.fromJson(responseBody.charStream(), Error.class);
        } catch (Exception e) {
            Error error = new Error();
            error.code = INCORRECT_DATA;
            error.codeMessage = "Ошибка сервера";
            return error;
        }

    }

    private void logResponse(Response response){
        Log.d(TAG, "logResponse: " + response.toString());
    }

    public MutableLiveData<Result> getUserInfo(){

        final MutableLiveData<Result> retResult = new MutableLiveData<>();

        dataManager.getUserInfo().enqueue(new Callback<UserInfoResponse>() {
            @Override
            public void onResponse(@NonNull Call<UserInfoResponse> call, @NonNull Response<UserInfoResponse> response) {

                UserInfoResponse userInfoResponse = response.body();
                ResponseBody errorBody = response.errorBody();
                if (userInfoResponse!=null){
                    setCurUser(userInfoResponse.user);
                    Result.Success<UserInfoResponse> result = new Result.Success<>(userInfoResponse);
                    retResult.postValue(result);
                } else if (errorBody!=null) {
                    setCurUser(null);
                    Error error = getError(errorBody);
                    Result resultError = new Result.Error(error.code, error.codeMessage);
                    retResult.postValue(resultError);
                } else {
                    setCurUser(null);
                    retResult.postValue(incorrectDataError);
                }

                logResponse(response);
            }

            @Override
            public void onFailure(@NonNull Call<UserInfoResponse> call, @NonNull Throwable t) {
                t.printStackTrace();
                retResult.postValue(connectionError);
            }
        });

        return retResult;
    }

    public MutableLiveData<Result> login(String username, String password){

        final MutableLiveData<Result> retResult = new MutableLiveData<>();

        dataManager.login(username, password).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {

                LoginResponse loginResponse = response.body();
                ResponseBody errorBody = response.errorBody();
                if (loginResponse!=null){
                    Result.Success<LoginResponse> result = new Result.Success<>(loginResponse);
                    retResult.postValue(result);
                } else if (errorBody!=null) {
                    Error error = getError(errorBody);
                    Result resultError = new Result.Error(error.code, error.codeMessage);
                    retResult.postValue(resultError);
                } else {
                    setCurUser(null);
                    retResult.postValue(incorrectDataError);
                }

                logResponse(response);
            }

            @Override
            public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                t.printStackTrace();
                retResult.postValue(connectionError);
            }
        });

        return retResult;
    }

}
