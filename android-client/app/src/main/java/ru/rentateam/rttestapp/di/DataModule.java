package ru.rentateam.rttestapp.di;

import androidx.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.rentateam.rttestapp.data.DataManager;
import ru.rentateam.rttestapp.data.UserRepository;
import ru.rentateam.rttestapp.data.local.PreferencesHelper;
import ru.rentateam.rttestapp.data.remote.ApiClient;


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
