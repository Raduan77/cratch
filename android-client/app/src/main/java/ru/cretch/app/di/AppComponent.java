package ru.cretch.app.di;


import javax.inject.Singleton;

import dagger.Component;
import ru.cretch.app.ui.login.LoginViewModel;
import ru.cretch.app.ui.profile.ProfileViewModel;


@Component(modules = {AppModule.class, DataModule.class})
@Singleton
public interface AppComponent {

    void inject(ProfileViewModel profileViewModel);
    void inject(LoginViewModel loginViewModel);
}
