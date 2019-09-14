package ru.rentateam.rttestapp.di;

import androidx.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.rentateam.rttestapp.data.MenuDataSource;
import ru.rentateam.rttestapp.data.MenuRepository;


@Module
public class DataModule {

    @Provides
    @NonNull
    @Singleton
    public MenuDataSource provideDataManager(){
        return new MenuDataSource();
    }

    @Provides
    @NonNull
    @Singleton
    public MenuRepository provideMenuRepository(MenuDataSource menuDataSource){
        return new MenuRepository(menuDataSource);
    }

}
