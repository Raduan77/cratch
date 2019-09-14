package ru.rentateam.rttestapp;

import android.app.Application;

import ru.rentateam.rttestapp.di.AppComponent;
import ru.rentateam.rttestapp.di.AppModule;
import ru.rentateam.rttestapp.di.DaggerAppComponent;

public class App extends Application {

    private AppComponent appComponent;
    public AppComponent getComponent(){
        return appComponent;
    }

    protected static App instance;
    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        appComponent = buildComponent();

    }

    protected AppComponent buildComponent(){
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
}