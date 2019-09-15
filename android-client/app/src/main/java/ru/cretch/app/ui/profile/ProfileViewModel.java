package ru.cretch.app.ui.profile;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import ru.cretch.app.data.Result;
import ru.cretch.app.data.UserRepository;

public class ProfileViewModel extends ViewModel {

    @Inject
    UserRepository userRepository;

    private MutableLiveData<ProfileResult> profileResult = new MutableLiveData<>();

    public MutableLiveData<ProfileResult> getProfileResult() {
        return profileResult;
    }


    public void getUserInfo(){
        userRepository.getUserInfo().observeForever(result -> {
            if (result instanceof Result.Success) {
                String[] data = ((Result.Success<String[]>) result).getData();
                ProfileUI profileUI = new ProfileUI(data);
                profileResult.setValue(new ProfileResult(profileUI));
            } else {
                profileResult.setValue(new ProfileResult((Result.Error) result));
            }
        });
    }
}
