package ru.cretch.app.ui.login;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import ru.cretch.app.data.Result;
import ru.cretch.app.data.UserRepository;
import ru.cretch.app.ui.profile.ProfileResult;
import ru.cretch.app.ui.profile.ProfileUI;

public class LoginViewModel extends ViewModel {

    @Inject
    UserRepository userRepository;

    private MutableLiveData<LoginResult> loginResult= new MutableLiveData<>();

    public MutableLiveData<LoginResult> getLoginResult() {
        return loginResult;
    }


    public void login(String username, String password){
        userRepository.login(username, password).observeForever(result -> {
            if (result instanceof Result.Success) {
                loginResult.setValue(new LoginResult(true));
            } else {
                loginResult.setValue(new LoginResult((Result.Error) result));
            }
        });
    }

}
