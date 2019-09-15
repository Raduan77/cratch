package ru.cretch.app.di;

import androidx.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.cretch.app.data.DataManager;
import ru.cretch.app.data.UserRepository;
import ru.cretch.app.data.local.PreferencesHelper;
import ru.cretch.app.data.remote.ApiClient;


@Module
public class DataModule {

    @Provides
    @NonNull
    @Singleton
    public DataManager provideDataManager(ApiClient apiClient, PreferencesHelper preferencesHelper){
        return new DataManager(apiClient, preferencesHelper);
    }

    @Provides
    @NonNull
    @Singleton
    public UserRepository provideMenuRepository(DataManager dataManager){
        return new UserRepository(dataManager);
    }

}
