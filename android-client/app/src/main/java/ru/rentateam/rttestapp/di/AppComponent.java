package ru.rentateam.rttestapp.di;


import javax.inject.Singleton;

import dagger.Component;
import ru.rentateam.rttestapp.ui.profile.ProfileViewModel;


@Component(modules = {AppModule.class, DataModule.class})
@Singleton
public interface AppComponent {

    void inject(ProfileViewModel profileViewModel);
}
